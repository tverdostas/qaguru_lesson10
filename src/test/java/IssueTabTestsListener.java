import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class IssueTabTestsListener {
    @Test
            void IssueTabListenerTest() {
        open("https://github.com");
        $("span.flex-1[data-target='qbsearch-input.inputButtonText']").click();
        $("input#query-builder-test").setValue("selenide").pressEnter();
        $("data-testid='results-list'").$(byText("selenide/selenide")).click();
        $("span[data-content='Issues']").shouldBe(Condition.visible);
    }
}
