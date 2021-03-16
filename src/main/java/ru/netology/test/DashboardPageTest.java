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

    @BeforeAll
    static void setUp() {

        Configuration.browser = "firefox";
        SqlMethods.clearTables();
        Configuration.startMaximized = true;
    }

    @BeforeEach
    void openSetUp() {
        open("http://localhost:9999");
    }

    @AfterAll
    static void shouldClearAll() {
       SqlMethods.clearTables();
    }

    @Test
    public void shouldSuccessfulLoginToDashboard() {
        val loginPage = new LoginPage();
        val authInfo = DataHelper.getAuthInfo();
        val verificationPage = loginPage.validLogin(authInfo);
        val verificationCode = SqlMethods.getCode();
        val dashboardPage = verificationPage.validVerify(verificationCode);
        dashboardPage.DashboardPageCheck();
    }

}
