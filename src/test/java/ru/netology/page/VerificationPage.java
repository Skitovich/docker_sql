package ru.netology.page;

import com.codeborne.selenide.SelenideElement;
import ru.netology.sql.SqlMethods;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class VerificationPage {
    private final SelenideElement codeField = $("[name='code']");
    private final SelenideElement verifyButton = $(".button__text");

    public VerificationPage() {
        codeField.shouldBe(visible);
    }

    public DashboardPage validVerify (SqlMethods.CodeInfo verificationCode) {
        codeField.setValue(verificationCode.getCode());
        verifyButton.click();
        return new DashboardPage();
    }
}
