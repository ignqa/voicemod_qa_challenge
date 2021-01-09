package voicemod.websites;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Condition.attribute;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;
import static org.testng.Assert.assertEquals;

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
    public void search() {
        mainPage.searchButton.click();
        $(byId("header-search")).sendKeys("Selenium");
        $(byXpath("//button[@type='submit' and text()='Search']")).click();
        $(byClassName("js-search-input")).shouldHave(attribute("value", "Selenium"));
    }

    @Test
    public void toolsMenu() {
        mainPage.toolsMenu.hover();
        $(byClassName("menu-main__popup-wrapper")).shouldBe(visible);
    }

    @Test
    public void navigationToAllTools() {
        mainPage.seeAllToolsButton.click();
        $(byId("products-page")).shouldBe(visible);
        assertEquals(Selenide.title(), "All Developer Tools and Products by JetBrains");
    }
}
