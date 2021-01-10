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
    public static final String URL = "https://www.voicemod.net/";
    /**
     * The Logo.
     */
    public static final WebElement logo = $(byId("logo"));
    /**
     * The Contact support link.
     */
    public static final SelenideElement contactSupportLink = $(byLinkText("Contact us here"));
    /**
     * The Apps menu link.
     */
    public static final SelenideElement appsMenuLink = $(byLinkText("OUR APPS"));
    /**
     * The English language menu item.
     */
    public static final SelenideElement englishLanguageMenuItem = $(byLinkText("English"));
    /**
     * The German language menu item.
     */
    public static final SelenideElement germanLanguageMenuItem = $(byLinkText("Deutsch"));
    /**
     * The French language menu item.
     */
    public static final SelenideElement frenchLanguageMenuItem = $(byLinkText("Français"));
    /**
     * The Japanese language menu item.
     */
    public static final SelenideElement japaneseLanguageMenuItem = $(byLinkText("日本語"));
    /**
     * The Russian language menu item.
     */
    public static final SelenideElement russianLanguageMenuItem = $(byLinkText("Русский"));
    private static final String HEADER_CONTAINS = "//h1[contains(";
    /**
     * The English header title.
     */
    public static final SelenideElement englishHeaderTitle = $x(HEADER_CONTAINS +
            "text(),'FREE Real Time Voice Changer for Online Games')]");
    /**
     * The German header title.
     */
    public static final SelenideElement germanHeaderTitle = $x(HEADER_CONTAINS +
            "text(),'GRATIS Echtzeit-Stimmenverzerrer für Online-Spiele')]");
    /**
     * The French header title.
     */
    public static final SelenideElement frenchHeaderTitle = $x(HEADER_CONTAINS +
            "text(),'Modificateur de voix GRATUIT en temps réel pour les jeux en ligne')]");
    /**
     * The Japanese header title.
     */
    public static final SelenideElement japaneseHeaderTitle = $x(HEADER_CONTAINS +
            "text(),'サウンドミキサー不要！すぐに使える簡単ボイスチェンジャーアプリ')]");
    /**
     * The Russian header title.
     */
    public static final SelenideElement russianHeaderTitle = $x(HEADER_CONTAINS +
            "text(),'Изменение голоса в реальном времени')]");
    private MainPage() {
        throw new IllegalStateException("MainPage class");
    }
}
