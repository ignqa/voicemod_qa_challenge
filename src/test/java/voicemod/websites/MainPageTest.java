package voicemod.websites;

import java.io.*;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.net.*;

import static com.codeborne.selenide.Condition.attribute;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;
import static org.testng.Assert.*;

public class MainPageTest {
    private final MainPage mainPage = new MainPage();

    boolean bufferedImagesEqual(BufferedImage img1, BufferedImage img2) {
        if (img1.getWidth() == img2.getWidth() && img1.getHeight() == img2.getHeight()) {
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
    public void test_header_logo_is_visible(){
        BufferedImage obtained_image = null;
        try{
            URL web_logo = new URL(mainPage.logo.getAttribute("src"));
            obtained_image = ImageIO.read(web_logo);
            String expected_logo = "src/test/resources/logos/logo-header.png";
            BufferedImage expected_image = ImageIO.read(new File(expected_logo));
            assertTrue(bufferedImagesEqual(obtained_image, expected_image), "The website header logo is not" +
                    "the expected one.");
        }catch(Exception e){
            fail("There was no possible to read the logo. Exception: " + e.toString());
        }
    }

    @Test
    public void test_contact_support_link_is_reachable(){
        mainPage.contactSupportLink.shouldBe(visible);
    }

    @Test
    public void test_download_apps_menu_is_reachable(){
        mainPage.appsMenuLink.shouldBe(visible);
    }
}
