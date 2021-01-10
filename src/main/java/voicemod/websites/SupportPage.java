package voicemod.websites;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byLinkText;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;


/**
 * The class represents all the web items from the Voicemod Support page.
 *
 * @author Ignacio Gazquez Navarrete
 */
public class SupportPage {
    /**
     * The Url for the Voicemod support site.
     */
    public static final String URL = "https://support.voicemod.net/";
    /**
     * The Contact support link.
     */
    public static final SelenideElement contactSupportLink = $(byLinkText("Enviar una solicitud"));
    /**
     * The Email form.
     */
    public static final SelenideElement email_form = $(byText("Correo electrónico"));
    /**
     * The Subject form.
     */
    public static final SelenideElement subject_form = $(byText("Asunto"));
    /**
     * The Description description.
     */
    public static final SelenideElement description_description = $(byText("Descripción"));
    /**
     * The Submit request button.
     */
    public static final SelenideElement submit_request = $x(
            "//input[contains(@type, 'submit') and contains(@name, 'commit') " +
                    "and contains(@value, 'Enviar')]");
    /**
     * Compliant constructor
     */
    private SupportPage() {
        throw new IllegalStateException("SupportPage class");
    }
}
