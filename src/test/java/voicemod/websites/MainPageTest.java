package voicemod.websites;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import helpers.Tools;
import io.qameta.allure.selenide.AllureSelenide;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.net.URL;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.closeWebDriver;
import static com.codeborne.selenide.Selenide.open;
import static org.testng.Assert.assertTrue;
import static org.testng.Assert.fail;

public class MainPageTest {
    private final MainPage mainPage = new MainPage();
    private final CookiesBanner cookiesBanner = new CookiesBanner();

    @BeforeClass
    public static void setUpAllure() {
        SelenideLogger.addListener("allure", new AllureSelenide());
    }

    @BeforeMethod
    public void setUp() {
        Configuration.browser = "firefox";
        Configuration.startMaximized = true;
        open(mainPage.url);
    }

    @AfterMethod
    public void tearDown() {
        closeWebDriver();
    }

    public void accept_all_cookies() {
        cookiesBanner.acceptAllCookiesButton.shouldBe(visible);
        cookiesBanner.acceptAllCookiesButton.click();
    }

    @Test
    public void test_header_logo_is_visible() {
        accept_all_cookies();

        BufferedImage obtained_image;
        String expected_logo = "src/test/resources/logos/logo-header.png";
        try {
            URL web_logo = new URL(mainPage.logo.getAttribute("src"));
            obtained_image = ImageIO.read(web_logo);
            BufferedImage expected_image = ImageIO.read(new File(expected_logo));
            assertTrue(Tools.bufferedImagesEqual(obtained_image, expected_image),
                    "The website header logo is not the expected one.");
        } catch (Exception e) {
            fail("There was no possible to read the logo. Exception: " + e.toString());
        }
    }

    @Test
    public void test_contact_support_link_is_reachable() {
        accept_all_cookies();

        mainPage.contactSupportLink.shouldBe(visible);
    }

    @Test
    public void test_download_apps_menu_is_reachable() {
        accept_all_cookies();

        mainPage.appsMenuLink.shouldBe(visible);
    }

    @Test
    public void test_check_title_and_translations() {
        accept_all_cookies();

        mainPage.englishHeaderTitle.shouldBe(visible);
        mainPage.englishLanguageMenuItem.shouldBe(visible);
        mainPage.englishLanguageMenuItem.click();
        mainPage.germanLanguageMenuItem.shouldBe(visible);
        mainPage.germanLanguageMenuItem.click();
        mainPage.germanHeaderTitle.shouldBe(visible);

        mainPage.germanLanguageMenuItem.shouldBe(visible);
        mainPage.germanLanguageMenuItem.click();
        mainPage.frenchLanguageMenuItem.shouldBe(visible);
        mainPage.frenchLanguageMenuItem.click();
        mainPage.frenchHeaderTitle.shouldBe(visible);

        mainPage.frenchLanguageMenuItem.shouldBe(visible);
        mainPage.frenchLanguageMenuItem.click();
        mainPage.japaneseLanguageMenuItem.shouldBe(visible);
        mainPage.japaneseLanguageMenuItem.click();
        mainPage.japaneseHeaderTitle.shouldBe(visible);

        mainPage.japaneseLanguageMenuItem.shouldBe(visible);
        mainPage.japaneseLanguageMenuItem.click();
        mainPage.russianLanguageMenuItem.shouldBe(visible);
        mainPage.russianLanguageMenuItem.click();
        mainPage.russianHeaderTitle.shouldBe(visible);
    }
}
