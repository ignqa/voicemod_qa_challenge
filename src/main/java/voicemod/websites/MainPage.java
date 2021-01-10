package voicemod.websites;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.WebElement;

import static com.codeborne.selenide.Selectors.byId;
import static com.codeborne.selenide.Selectors.byLinkText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;


public class MainPage {
    public String url = "https://www.voicemod.net/";
    public WebElement logo = $(byId("logo"));
    public SelenideElement contactSupportLink = $(byLinkText("Contact us here"));
    public SelenideElement appsMenuLink = $(byLinkText("OUR APPS"));

    public SelenideElement englishLanguageMenuItem = $(byLinkText("English"));
    public SelenideElement englishHeaderTitle = $x("//h1[contains(" +
            "text(),'FREE Real Time Voice Changer for Online Games')]");

    public SelenideElement germanLanguageMenuItem = $(byLinkText("Deutsch"));
    public SelenideElement germanHeaderTitle = $x("//h1[contains(" +
            "text(),'GRATIS Echtzeit-Stimmenverzerrer für Online-Spiele')]");

    public SelenideElement frenchLanguageMenuItem = $(byLinkText("Français"));
    public SelenideElement frenchHeaderTitle = $x("//h1[contains(" +
            "text(),'Modificateur de voix GRATUIT en temps réel pour les jeux en ligne')]");

    public SelenideElement japaneseLanguageMenuItem = $(byLinkText("日本語"));
    public SelenideElement japaneseHeaderTitle = $x("//h1[contains(" +
            "text(),'サウンドミキサー不要！すぐに使える簡単ボイスチェンジャーアプリ')]");

    public SelenideElement russianLanguageMenuItem = $(byLinkText("Русский"));
    public SelenideElement russianHeaderTitle = $x("//h1[contains(" +
            "text(),'Изменение голоса в реальном времени')]");
}
