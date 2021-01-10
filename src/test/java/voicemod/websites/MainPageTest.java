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

    @Test
    public void test_header_logo_is_visible() {
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
        mainPage.contactSupportLink.shouldBe(visible);
    }

    @Test
    public void test_download_apps_menu_is_reachable() {
        mainPage.appsMenuLink.shouldBe(visible);
    }
}
