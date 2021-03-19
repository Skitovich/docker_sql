package ru.netology.test;

import com.codeborne.selenide.Configuration;
import lombok.val;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.data.DataHelper;
import ru.netology.page.LoginPage;
import ru.netology.sql.SqlMethods;

import static com.codeborne.selenide.Selenide.open;


public class DashboardPageTest {

    @BeforeEach
    void openSetUp() {
        open("http://localhost:9999");
    }

    @BeforeAll
    static void setUp() {
        Configuration.browser = "firefox";
        Configuration.startMaximized = true;
    }

    @AfterAll
    static void shouldClearAll() {
        SqlMethods.clearTables();
    }

    @Test
    void shouldSuccessfulLoginToDashboard() {
        val loginPage = new LoginPage();
        val authInfo = DataHelper.getAuthInfo();
        val verificationPage = loginPage.validLogin(authInfo);
        val verificationCode = SqlMethods.getCode();
        verificationPage.validVerify(verificationCode);
    }

    @Test
    void shouldBlockIfPasswordIsInvalid() {
        val loginPage = new LoginPage();
        val authInfo = DataHelper.getAuthInfo();
        val otherAuthInfo = DataHelper.getOtherAuthInfo();
        loginPage.nonValidPassword(authInfo, otherAuthInfo);
        loginPage.clearFieldAndPutInvalidPassword(otherAuthInfo);
        loginPage.clearFieldAndPutInvalidPassword(otherAuthInfo);
        loginPage.getErrorMessageAboutBlocking();
    }

}
