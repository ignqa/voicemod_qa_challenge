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
    public String url = "https://support.voicemod.net/";

    /**
     * The Contact support link.
     */
    public SelenideElement contactSupportLink = $(byLinkText("Enviar una solicitud"));
    /**
     * The Email form.
     */
    public SelenideElement email_form = $(byText("Correo electrónico"));
    /**
     * The Subject form.
     */
    public SelenideElement subject_form = $(byText("Asunto"));
    /**
     * The Description description.
     */
    public SelenideElement description_description = $(byText("Descripción"));
    /**
     * The Submit request button.
     */
    public SelenideElement submit_request = $x(
            "//input[contains(@type, 'submit') and contains(@name, 'commit') " +
                    "and contains(@value, 'Enviar')]");
}
