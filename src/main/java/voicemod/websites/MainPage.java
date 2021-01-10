package voicemod.websites;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.WebElement;

import static com.codeborne.selenide.Selectors.byId;
import static com.codeborne.selenide.Selectors.byLinkText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;


/**
 * The class represents all the web items from the Voicemod home page.
 *
 * @author Ignacio Gazquez Navarrete
 */
public class MainPage {
    /**
     * The Url.
     */
    public String url = "https://www.voicemod.net/";
    /**
     * The Logo.
     */
    public WebElement logo = $(byId("logo"));
    /**
     * The Contact support link.
     */
    public SelenideElement contactSupportLink = $(byLinkText("Contact us here"));
    /**
     * The Apps menu link.
     */
    public SelenideElement appsMenuLink = $(byLinkText("OUR APPS"));

    /**
     * The English language menu item.
     */
    public SelenideElement englishLanguageMenuItem = $(byLinkText("English"));
    /**
     * The English header title.
     */
    public SelenideElement englishHeaderTitle = $x("//h1[contains(" +
            "text(),'FREE Real Time Voice Changer for Online Games')]");

    /**
     * The German language menu item.
     */
    public SelenideElement germanLanguageMenuItem = $(byLinkText("Deutsch"));
    /**
     * The German header title.
     */
    public SelenideElement germanHeaderTitle = $x("//h1[contains(" +
            "text(),'GRATIS Echtzeit-Stimmenverzerrer für Online-Spiele')]");

    /**
     * The French language menu item.
     */
    public SelenideElement frenchLanguageMenuItem = $(byLinkText("Français"));
    /**
     * The French header title.
     */
    public SelenideElement frenchHeaderTitle = $x("//h1[contains(" +
            "text(),'Modificateur de voix GRATUIT en temps réel pour les jeux en ligne')]");

    /**
     * The Japanese language menu item.
     */
    public SelenideElement japaneseLanguageMenuItem = $(byLinkText("日本語"));
    /**
     * The Japanese header title.
     */
    public SelenideElement japaneseHeaderTitle = $x("//h1[contains(" +
            "text(),'サウンドミキサー不要！すぐに使える簡単ボイスチェンジャーアプリ')]");

    /**
     * The Russian language menu item.
     */
    public SelenideElement russianLanguageMenuItem = $(byLinkText("Русский"));
    /**
     * The Russian header title.
     */
    public SelenideElement russianHeaderTitle = $x("//h1[contains(" +
            "text(),'Изменение голоса в реальном времени')]");
}
