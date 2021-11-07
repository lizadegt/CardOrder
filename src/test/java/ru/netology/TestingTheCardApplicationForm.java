package ru.netology;

import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class TestingTheCardApplicationForm {
    @Test
    void shouldRegisterByApplication() {
        open("http://localhost:9999/");
        SelenideElement form = $("[data-test-id=card-application-form]");
        $("[name='name']").setValue("Иванов Иван");
        $("[name='phone']").setValue("+79270000000");
        $("[data-test-id='agreement']").click();
        $("button").click();
        $("[data-test-id='order-success']").shouldHave(exactText("  Ваша заявка успешно отправлена! Наш менеджер свяжется с вами в ближайшее время."));
    }
}
