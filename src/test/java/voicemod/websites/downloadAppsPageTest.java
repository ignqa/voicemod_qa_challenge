package voicemod.websites;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.testng.annotations.*;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.FileInputStream;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;


import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.closeWebDriver;
import static com.codeborne.selenide.Selenide.open;
import static org.testng.Assert.*;

public class downloadAppsPageTest {
    private final downloadAppsPage downloads_page = new downloadAppsPage();
    private File downloaded_test_file;

    @BeforeClass
    public static void setUpAllure() {
        SelenideLogger.addListener("allure", new AllureSelenide());
    }

    @BeforeMethod
    public void setUp() {
        downloaded_test_file = null;
        Configuration.browser = "firefox";
        Configuration.startMaximized = true;
        open(downloads_page.url);
    }

    @AfterMethod
    public void tearDown() {
        closeWebDriver();
        if(downloaded_test_file != null){
            try {
                FileUtils.deleteDirectory(new File(downloaded_test_file.getParent()));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @AfterClass
    public void tearDownClass() {

    }

    private static String getChecksum(File file) throws IOException
    {
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
            };

            //close the stream;
            fis.close();

            //Get the hash's bytes
            byte[] bytes = digest.digest();

            //Convert it to hexadecimal format
            for (byte aByte : bytes) {
                sb.append(Integer.toString((aByte & 0xff) + 0x100, 16).substring(1));
            }
        } catch (NoSuchAlgorithmException e) {
            fail("Something wrong happened calculating the MD5 to the file. Exception: " + e.toString());
        }
        return sb.toString();
    }

    @Test
    public void test_download_last_app_version(){
        downloads_page.downloadAppButton_check.shouldBe(visible);
        try {
            downloaded_test_file = downloads_page.downloadAppButton_click.download();
            String obtained_md5 = getChecksum(downloaded_test_file);
            assertEquals(obtained_md5,"023c7817631bdb009301e1250ce424d8",
                    "The downloaded file is not the expected Voicemod app binary. MD5");
        } catch (FileNotFoundException e) {
            fail("There was no possible to read the logo. Exception: " + e.toString());
        } catch (IOException e) {
            fail("There was no possible calculate the MD5 operation to the downloaded file. " +
                    "Exception: " + e.toString());
        }

    }

}
