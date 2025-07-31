import com.codeborne.selenide.Condition;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;

public class IssueTabTestsListener {

    @Test
            void IssueTabListenerTest() {
        SelenideLogger.addListener("allure", new AllureSelenide());

        open("https://github.com");

        $("span.flex-1[data-target='qbsearch-input.inputButtonText']").click();
        $("input#query-builder-test").setValue("selenide").pressEnter();
        $("data-testid='results-list'").$(byText("selenide/selenide")).click();
        $("span[data-content='Issues']").shouldBe(Condition.visible);
    }

    @Test
    void IssueTabWithStepsTest() {
        SelenideLogger.addListener("allure", new AllureSelenide());

        step("Открыть главную страницу", () -> {
            open("https://github.com");
                });
        step("Поставить фокус на поле поиска", () -> $("span.flex-1[data-target='qbsearch-input.inputButtonText']").click());
        step("Ввести текст поиска и нажать Enter", () -> {
                    $("input#query-builder-test").setValue("selenide").pressEnter();
                });
        step("Перейти на страницу Селенида, первую в поиске", () -> {
        $("data-testid='results-list'").$(byText("selenide/selenide")).click();
        });
        step("Проверить, что таб Issues виден на странице", () -> {
        $("span[data-content='Issues']").shouldBe(Condition.visible);
        });
    }

    @Test
    void IssueTabWithAnnotatedStepsTest(){
        SelenideLogger.addListener("allure", new AllureSelenide());
        WebSteps steps = new WebSteps();
        steps.openMainPage();
        steps.clickOnSearchField();
        steps.fillSearchField();
        steps.goToSelenidePage();
        steps.checkIssueTabOnPage();
    }
}
