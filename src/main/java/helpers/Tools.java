package helpers;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;


/**
 * This class serves the minimum custom functions needed for the automated tests implemented in this repository.
 *
 * @author Ignacio Gazquez Navarrete
 */
public class Tools {
    /**
     * Given a file calculates the MD5 checksum.
     *
     * @param file the file
     * @return the MD5 checksum
     * @throws IOException In case the file is corrupted or could not be executed the algorithm.
     * @see MessageDigest
     */
    public static String getMD5Checksum(File file) throws IOException {
        StringBuilder sb = new StringBuilder();
        try {
            MessageDigest digest = MessageDigest.getInstance("MD5");
            FileInputStream fis = new FileInputStream(file);

            //Create byte array to read data in chunks
            byte[] byteArray = new byte[1024];
            int bytesCount = 0;

            //Read file data and update in message digest
            while ((bytesCount = fis.read(byteArray)) != -1) {
                digest.update(byteArray, 0, bytesCount);
            }

            //close the stream;
            fis.close();

            //Get the hash's bytes
            byte[] bytes = digest.digest();

            //Convert it to hexadecimal format
            for (byte aByte : bytes) {
                sb.append(Integer.toString((aByte & 0xff) + 0x100, 16).substring(1));
            }
        } catch (NoSuchAlgorithmException e) {
            throw new AssertionError("Something wrong happened calculating the MD5 to the file. " +
                    "Exception: " + e.toString());
        }
        return sb.toString();
    }

    /**
     * Compares two images and return if they are graphically equals or not (according to their RGB matrix)
     *
     * @param img1 The first image to compare
     * @param img2 The second image to compare
     * @return True, in case they are equal. False, if they are not
     */
    public static boolean bufferedImagesEqual(BufferedImage img1, BufferedImage img2) {
        // Check first width and height
        if (img1.getWidth() == img2.getWidth() && img1.getHeight() == img2.getHeight()) {
            // Compare then pixel by pixel
            for (int x = 0; x < img1.getWidth(); x++) {
                for (int y = 0; y < img1.getHeight(); y++) {
                    if (img1.getRGB(x, y) != img2.getRGB(x, y))
                        return false;
                }
            }
        } else {
            return false;
        }
        return true;
    }
}
