package voicemod.websites;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.File;
import java.net.URL;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.closeWebDriver;
import static com.codeborne.selenide.Selenide.open;
import static org.testng.Assert.assertTrue;
import static org.testng.Assert.fail;

public class SupportPageTest {
    private final SupportPage supportPage = new SupportPage();
    private final String expected_logo = "src/test/resources/logos/logo-header.png";

    @BeforeClass
    public static void setUpAllure() {
        SelenideLogger.addListener("allure", new AllureSelenide());
    }

    @BeforeMethod
    public void setUp() {
        Configuration.browser = "firefox";
        Configuration.startMaximized = true;
        open(supportPage.url);
    }

    @AfterMethod
    public void tearDown() {
        closeWebDriver();
    }

    @Test
    public void test_a_support_request_can_be_done(){
        supportPage.contactSupportLink.shouldBe(visible);
        supportPage.contactSupportLink.click();
        supportPage.label_email_text_box.shouldBe(visible);
        supportPage.form_email_text_box.shouldBe(visible);
        supportPage.label_request_subject_text_box.shouldBe(visible);
        supportPage.form_request_subject_text_box.shouldBe(visible);
        supportPage.label_request_description_text_box.shouldBe(visible);
        supportPage.form_request_description_text_box.shouldBe(visible);
        supportPage.submit_request.shouldBe(visible);
    }
//    @Test
//    public void search() {
//        mainPage.searchButton.click();
//        $(byId("header-search")).sendKeys("Selenium");
//        $(byXpath("//button[@type='submit' and text()='Search']")).click();
//        $(byClassName("js-search-input")).shouldHave(attribute("value", "Selenium"));
//    }
//
//    @Test
//    public void toolsMenu() {
//        mainPage.toolsMenu.hover();
//        $(byClassName("menu-main__popup-wrapper")).shouldBe(visible);
//    }
//
//    @Test
//    public void navigationToAllTools() {
//        mainPage.seeAllToolsButton.click();
//        $(byId("products-page")).shouldBe(visible);
//        assertEquals(Selenide.title(), "All Developer Tools and Products by JetBrains");
//    }
}
