package voicemod.websites;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byLinkText;
import static com.codeborne.selenide.Selenide.$;

public class DownloadAppsPage {
    public String url = "https://www.voicemod.net/products-voice-changer-app/";

    public SelenideElement downloadAppButton = $(byLinkText("DOWNLOAD NOW"));

}
