package voicemod.websites;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.closeWebDriver;
import static com.codeborne.selenide.Selenide.open;

/**
 * This class contains all the tests related to the Voicemod support page.
 *
 * @author Ignacio Gazquez Navarrete
 */
public class SupportPageTest {
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
        open(SupportPage.URL);
    }

    /**
     * Tear down. After each test executed it closes the web driver (close the browser).
     */
    @AfterMethod
    public void tearDown() {
        closeWebDriver();
    }

    /**
     * Test the support form is visible, then, clicking on it the next elements are visible:
     * - Requester email
     * - Request subject
     * - Request description
     * - Submit request button
     * Notes for the interviewers: Ideally the form should be filled, and then the request submitted. Because this
     * tests are being launched in a production environment, the validations are minimal (only check if the form parts
     * are visible). To fill forms it would be enough to use the org.openqa.selenium.WebElement#sendKeys method.
     * Then, clicking on the submit_request selenidElement the request would be submitted.
     *
     * @see org.openqa.selenium.WebElement#sendKeys(CharSequence...)
     * @see SelenideElement#click()
     */
    @Test
    public void test_a_support_request_can_be_done() {
        SupportPage.contactSupportLink.shouldBe(visible);
        SupportPage.contactSupportLink.click();
        SupportPage.email_form.shouldBe(visible);
        SupportPage.subject_form.shouldBe(visible);
        SupportPage.description_description.shouldBe(visible);
        SupportPage.submit_request.shouldBe(visible);
    }
}
