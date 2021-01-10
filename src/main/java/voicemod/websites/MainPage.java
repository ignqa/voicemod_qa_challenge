package voicemod.websites;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.WebElement;

import static com.codeborne.selenide.Selectors.byId;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;


public class MainPage {
    public String url = "https://www.voicemod.net/";
    public WebElement logo = $(byId("logo"));
    public SelenideElement seeAllToolsButton = $("a.wt-button_mode_primary");
    public SelenideElement toolsMenu = $x("//div[contains(@class, 'menu-main__item') " +
            "and text() = 'Developer Tools']");
    public SelenideElement searchButton = $("[data-test=menu-main-icon-search]");
    SupportPage supportPage = new SupportPage();
    public SelenideElement contactSupportLink = $x(
            "//a[contains(@href, '" + supportPage.url + "') " +
                    "and text() = 'Contact us here']");
    DownloadAppsPage downloadAppsPage = new DownloadAppsPage();
    public SelenideElement appsMenuLink = $x(
            "//a[contains(@href, '" + downloadAppsPage.url + "') " +
                    "and text() = 'OUR APPS']");
}
