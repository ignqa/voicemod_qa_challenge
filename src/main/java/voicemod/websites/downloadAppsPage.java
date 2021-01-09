package voicemod.websites;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.WebElement;

import static com.codeborne.selenide.Selectors.byId;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class downloadAppsPage {
    public String url = "https://www.voicemod.net/products-voice-changer-app/";

    public SelenideElement downloadAppButton_check =  $x(
            "//a[contains(@href, 'https://www.voicemod.net/downloadVoicemod.php') " +
                    "and contains(@class, 'button')]//span[contains(text(), 'DOWNLOAD NOW ')] ");

    public SelenideElement downloadAppButton_click =  $x(
            "//a[contains(@href, 'https://www.voicemod.net/downloadVoicemod.php') " +
                    "and contains(@class, 'button')]");
}
