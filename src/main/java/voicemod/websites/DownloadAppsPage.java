package voicemod.websites;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byLinkText;
import static com.codeborne.selenide.Selenide.$;

/**
 * The class represents all the web items from the Voicemod downloads apps page.
 *
 * @author Ignacio Gazquez Navarrete
 */
public class DownloadAppsPage {
    /**
     * The Url.
     */
    public static final String URL = "https://www.voicemod.net/products-voice-changer-app/";
    /**
     * The Download app button.
     */
    public static final SelenideElement downloadAppButton = $(byLinkText("DOWNLOAD NOW"));

    /**
     * Compliant constructor
     */
    private DownloadAppsPage() {
        throw new IllegalStateException("DownloadAppsPage class");
    }

}
