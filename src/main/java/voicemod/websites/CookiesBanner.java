package voicemod.websites;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byId;
import static com.codeborne.selenide.Selenide.$;

public class CookiesBanner {
    public SelenideElement acceptAllCookiesButton = $(byId("onetrust-accept-btn-handler"));
}
