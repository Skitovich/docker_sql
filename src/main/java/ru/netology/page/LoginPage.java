package ru.netology.page;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.Keys;
import ru.netology.data.DataHelper;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;

public class LoginPage {
    private final SelenideElement loginField = $("[name='login']");
    private final SelenideElement passwordField = $("[name='password']");
    private final SelenideElement loginButton = $(".button__text");
    private final SelenideElement errorMessage = $("[data-test-id=error-notification]");
    private final SelenideElement errorMessageAboutBlocking = $(withText("Система заблокирована из-за трехкратного неправильного ввода пароля"));

    public VerificationPage validLogin (DataHelper.AuthInfo info) {
        loginField.setValue(info.getLogin());
        passwordField.setValue(info.getPassword());
        loginButton.click();
        return new VerificationPage();
    }

    public LoginPage nonValidPassword(DataHelper.AuthInfo info, DataHelper.AuthInfo other) {
        loginField.setValue(info.getLogin());
        passwordField.setValue(other.getPassword());
        loginButton.click();
        errorMessage.shouldBe(Condition.visible);
        return new LoginPage();
    }

    public LoginPage clearFieldAndPutInvalidPassword(DataHelper.AuthInfo other) {
        passwordField.doubleClick().sendKeys(Keys.BACK_SPACE);
        passwordField.setValue(other.getPassword());
        loginButton.click();
        errorMessage.shouldBe(Condition.visible);
        return new LoginPage();
    }

    public void getErrorMessageAboutBlocking() {
        errorMessageAboutBlocking.shouldBe(Condition.visible);
    }
}
