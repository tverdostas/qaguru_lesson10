import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class WebSteps {

    @Step
    public void openMainPage(){
        open("https://github.com");
    }

    @Step
    public void clickOnSearchField(){
        $("span.flex-1[data-target='qbsearch-input.inputButtonText']").click();
    }

    @Step
    public void fillSearchField(){
        $("input#query-builder-test").setValue("selenide").pressEnter();
    }

    @Step
    public void goToSelenidePage(){
        $("data-testid='results-list'").$(byText("selenide/selenide")).click();
    }

    @Step
    public void checkIssueTabOnPage() {
        $("span[data-content='Issues']").shouldBe(Condition.visible);
    }
}
