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
//        Configuration.browser = "opera";
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
    void shouldSuccessfulLoginToDashboard() {
        val loginPage = new LoginPage();
        val authInfo = DataHelper.getAuthInfo();
        val vericationPage = loginPage.validLogin(authInfo);
        val vericationCode = DataHelper.getVerificationCodeFor();
        val dashboardPage = vericationPage.validVerify(vericationCode);
        dashboardPage.DashboardPageCheck();
    }

}
