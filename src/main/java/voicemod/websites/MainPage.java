package voicemod.websites;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.WebElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selectors.*;

public class MainPage {
    public String url = "https://www.voicemod.net/";

    public WebElement logo = $(byId("logo"));
    public SelenideElement seeAllToolsButton = $("a.wt-button_mode_primary");
    public SelenideElement toolsMenu = $x("//div[contains(@class, 'menu-main__item') " +
            "and text() = 'Developer Tools']");
    public SelenideElement searchButton = $("[data-test=menu-main-icon-search]");
    public SelenideElement contactSupportLink =  $x("//a[contains(@href, 'https://support.voicemod.net/') " +
            "and text() = 'Contact us here']");
    public SelenideElement appsMenuLink =  $x(
            "//a[contains(@href, 'https://www.voicemod.net/products-voice-changer-app/') " +
            "and text() = 'OUR APPS']");
}
