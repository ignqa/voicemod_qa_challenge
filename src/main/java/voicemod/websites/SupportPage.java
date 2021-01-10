package voicemod.websites;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byId;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class SupportPage {
    public String url = "https://support.voicemod.net/";

    public SelenideElement contactSupportLink = $x(
            "//a[contains(@class, 'submit-a-request') " +
                    "and text() = 'Enviar una solicitud']");
    public SelenideElement label_email_text_box = $x(
            "//label[contains(@for, 'request_anonymous_requester_email') " +
                    "and text() = 'Correo electrónico']");
    public SelenideElement form_email_text_box = $(byId("request_anonymous_requester_email"));
    public SelenideElement label_request_subject_text_box = $x(
            "//label[contains(@for, 'request_subject') " +
                    "and text() = 'Asunto']");
    public SelenideElement form_request_subject_text_box = $(byId("request_subject"));
    public SelenideElement label_request_description_text_box = $x(
            "//label[contains(@for, 'request_description') " +
                    "and text() = 'Descripción']");
    public SelenideElement form_request_description_text_box = $(byId("request_description"));
    public SelenideElement submit_request = $x(
            "//input[contains(@type, 'submit') and contains(@name, 'commit') " +
                    "and contains(@value, 'Enviar')]");
}
