package voicemod.websites;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byId;
import static com.codeborne.selenide.Selenide.$;

/**
 * The class represents all the web items from the Voicemod cookies banner.
 *
 * @author Ignacio Gazquez Navarrete
 */
public class CookiesBanner {
    /**
     * The Accept all cookies button.
     */
    public static final SelenideElement acceptAllCookiesButton = $(byId("onetrust-accept-btn-handler"));

    /**
     * Compliant constructor
     */
    private CookiesBanner() {
        throw new IllegalStateException("CookiesBanner class");
    }
}
