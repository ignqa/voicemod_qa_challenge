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
    public String url = "https://www.voicemod.net/products-voice-changer-app/";

    /**
     * The Download app button.
     */
    public SelenideElement downloadAppButton = $(byLinkText("DOWNLOAD NOW"));

}
