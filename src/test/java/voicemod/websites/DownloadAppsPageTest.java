package voicemod.websites;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import helpers.Tools;
import io.qameta.allure.selenide.AllureSelenide;
import org.apache.commons.io.FileUtils;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.closeWebDriver;
import static com.codeborne.selenide.Selenide.open;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.fail;

/**
 * This class contains all the tests related to the Voicemod download apps webpage.
 *
 * @author Ignacio Gazquez Navarrete
 */
public class DownloadAppsPageTest {
    private final DownloadAppsPage downloads_page = new DownloadAppsPage();
    private final CookiesBanner cookiesBanner = new CookiesBanner();
    private File downloaded_test_file;

    /**
     * Sets up the Allure tool (results of the tests can be represented after execution).
     */
    @BeforeClass
    public static void setUpAllure() {
        SelenideLogger.addListener("allure", new AllureSelenide());
    }

    /**
     * Sets up. Before each test method it performs three main operations:
     * - Selects firefox as browser to be employed in the tests
     * - Set the browser configuration to start the tests with the windows maximized
     * - Open the relevant website where the tests from this class are going to be performed
     */
    @BeforeMethod
    public void setUp() {
        downloaded_test_file = null;
        Configuration.browser = "firefox";
        Configuration.startMaximized = true;
        open(downloads_page.url);
    }

    /**
     * Tear down. After each test executed it performs two operations:
     * - Close the web driver (close the browser)
     * - In case a file was downloaded during the test execution, the file and the parent (temporal) directory
     * are removed.
     *
     * @see FileUtils#deleteDirectory(File)
     */
    @AfterMethod
    public void tearDown() {
        closeWebDriver();
        if (downloaded_test_file != null) {
            try {
                FileUtils.deleteDirectory(new File(downloaded_test_file.getParent()));
            } catch (IOException e) {
                fail("Something happened when trying to remove the downloaded file for the current-executed test." +
                        "Exception: " + e.toString());
            }
        }
    }

    /**
     * Check if the cookies banner is visible, and then, click on the accept all cookies button inside it
     */
    public void accept_all_cookies() {
        cookiesBanner.acceptAllCookiesButton.shouldBe(visible);
        cookiesBanner.acceptAllCookiesButton.click();
    }

    /**
     * Test if it is possible to get the current desktop version of the VoiceMod application for Windows OS. Steps:
     * - Accept all the cookies before starting to navigate.
     * - Check if the download app button is visible. Click on it and download the app.
     * - Once the app is downloaded, performs the MD5 algorithm over the downloaded binaries to verify if it is the
     * expected downloaded file.
     *
     * @see Tools#getMD5Checksum(File)
     */
    @Test
    public void test_download_last_app_version() {
        accept_all_cookies();

        downloads_page.downloadAppButton.shouldBe(visible);
        String expected_md5_v2_4_0_6_binaries = "023c7817631bdb009301e1250ce424d8";
        try {
            downloaded_test_file = downloads_page.downloadAppButton.download();
            assertEquals(Tools.getMD5Checksum(downloaded_test_file), expected_md5_v2_4_0_6_binaries,
                    "The downloaded file is not the expected Voicemod app binary. MD5");
        } catch (FileNotFoundException e) {
            fail("There was no possible to read the downloaded file. Exception: " + e.toString());
        } catch (IOException e) {
            fail("There was no possible calculate the MD5 operation to the downloaded file. " +
                    "Exception: " + e.toString());
        }

    }

}
