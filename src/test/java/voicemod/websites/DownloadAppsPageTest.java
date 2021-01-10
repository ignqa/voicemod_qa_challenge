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

public class DownloadAppsPageTest {
    private final DownloadAppsPage downloads_page = new DownloadAppsPage();
    private final CookiesBanner cookiesBanner = new CookiesBanner();
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
        if (downloaded_test_file != null) {
            try {
                FileUtils.deleteDirectory(new File(downloaded_test_file.getParent()));
            } catch (IOException e) {
                fail("Something happened when trying to remove the downloaded file for the current-executed test." +
                        "Exception: " + e.toString());
            }
        }
    }

    public void accept_all_cookies() {
        cookiesBanner.acceptAllCookiesButton.shouldBe(visible);
        cookiesBanner.acceptAllCookiesButton.click();
    }

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
