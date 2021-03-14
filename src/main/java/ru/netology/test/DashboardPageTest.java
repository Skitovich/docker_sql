package ru.netology.test;

import com.codeborne.selenide.Configuration;
import lombok.val;
import org.junit.Test;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import ru.netology.page.LoginPage;
import ru.netology.sql.SqlMethods;

import static com.codeborne.selenide.Selenide.open;

public class DashboardPageTest {

    @BeforeAll
    static void setUp() {
        Configuration.browser = "firefox";
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
    void shouldSuccessfulLoginToDashboard () {
        val loginpage = new LoginPage();
    }

}
