import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class WebSteps {

    private final SelenideElement sercInp = $("[data-testid='results-list']");
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
        sercInp.$(byText("selenide/")).click();
    }

    @Step
    public void checkIssueTabOnPage() {
        $("span[data-content='Issues']").shouldBe(Condition.visible);
    }
}
