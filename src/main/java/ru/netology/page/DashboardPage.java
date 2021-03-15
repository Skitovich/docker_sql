package ru.netology.page;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selenide.$;


public class DashboardPage {
    private final SelenideElement dashboard = $("[data-test-id=dashboard]");

public DashboardPage () {

}
public void DashboardPageCheck () {
dashboard.shouldBe(Condition.visible);
}
}
