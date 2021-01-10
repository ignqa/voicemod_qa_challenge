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

/**
 * This class contains all the tests related to the Voicemod home page.
 *
 * @author Ignacio Gazquez Navarrete
 */
public class MainPageTest {
    /**
     * Sets up the Allure tool (results of the tests can be represented after execution).
     */
    @BeforeClass
    public static void setUpAllure() {
        SelenideLogger.addListener("allure", new AllureSelenide());
    }

    /**
     * Sets up. Before each test method it performs three main operations:
     * - Selects firefox as browser to be employed in the tests.
     * - Set the browser configuration to start the tests with the windows maximized.
     * - Open the relevant website where the tests from this class are going to be performed.
     */
    @BeforeMethod
    public void setUp() {
        Configuration.browser = "firefox";
        Configuration.startMaximized = true;
        open(MainPage.URL);
    }

    /**
     * Tear down. After each test executed it closes the web driver (close the browser).
     */
    @AfterMethod
    public void tearDown() {
        closeWebDriver();
    }

    /**
     * Check if the cookies banner is visible, and then, click on the accept all cookies button inside it.
     */
    public void accept_all_cookies() {
        CookiesBanner.acceptAllCookiesButton.shouldBe(visible);
        CookiesBanner.acceptAllCookiesButton.click();
    }

    /**
     * After accepting all the cookies, it verifies if the header-logo is visible, then analyze it to check that
     * is the expected one.
     */
    @Test
    public void test_header_logo_is_visible() {
        accept_all_cookies();

        BufferedImage obtained_image;
        String expected_logo = "src/test/resources/logos/header-logo.png";
        try {
            URL web_logo = new URL(MainPage.logo.getAttribute("src"));
            obtained_image = ImageIO.read(web_logo);
            BufferedImage expected_image = ImageIO.read(new File(expected_logo));
            assertTrue(Tools.bufferedImagesEqual(obtained_image, expected_image),
                    "The website header logo is not the expected one.");
        } catch (Exception e) {
            fail("There was no possible to read the logo. Exception: " + e.toString());
        }
    }

    /**
     * After accepting all the cookies, tests that contact support link is visible.
     */
    @Test
    public void test_contact_support_link_is_reachable() {
        accept_all_cookies();

        MainPage.contactSupportLink.shouldBe(visible);
    }

    /**
     * After accepting all the cookies, tests that apps menu link is visible.
     */
    @Test
    public void test_download_apps_menu_is_reachable() {
        accept_all_cookies();

        MainPage.appsMenuLink.shouldBe(visible);
    }

    /**
     * After accepting all the cookies, test that the main site can be translated to the next languages:
     * - English (homepage is displayed in this language by default).
     * - German.
     * - French.
     * - Japanese.
     * - Russian.
     * For that, the languages menu is visible, one of these lenguages can be selected, and at minimum, the website
     * header title is translated into the expected language.
     */
    @Test
    public void test_check_title_and_translations() {
        accept_all_cookies();
        //English is defaulted
        MainPage.englishHeaderTitle.shouldBe(visible);
        //From English to German
        MainPage.englishLanguageMenuItem.shouldBe(visible);
        MainPage.englishLanguageMenuItem.click();
        MainPage.germanLanguageMenuItem.shouldBe(visible);
        MainPage.germanLanguageMenuItem.click();
        MainPage.germanHeaderTitle.shouldBe(visible);
        //From German to French
        MainPage.germanLanguageMenuItem.shouldBe(visible);
        MainPage.germanLanguageMenuItem.click();
        MainPage.frenchLanguageMenuItem.shouldBe(visible);
        MainPage.frenchLanguageMenuItem.click();
        MainPage.frenchHeaderTitle.shouldBe(visible);
        //From German to Japanese
        MainPage.frenchLanguageMenuItem.shouldBe(visible);
        MainPage.frenchLanguageMenuItem.click();
        MainPage.japaneseLanguageMenuItem.shouldBe(visible);
        MainPage.japaneseLanguageMenuItem.click();
        MainPage.japaneseHeaderTitle.shouldBe(visible);
        //From Japanese to Russian
        MainPage.japaneseLanguageMenuItem.shouldBe(visible);
        MainPage.japaneseLanguageMenuItem.click();
        MainPage.russianLanguageMenuItem.shouldBe(visible);
        MainPage.russianLanguageMenuItem.click();
        MainPage.russianHeaderTitle.shouldBe(visible);
    }
}
