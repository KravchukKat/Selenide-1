import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byTagAndText;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class GitHubWikiTest {
    @BeforeAll
    static void setupConfig() {
        Configuration.browserSize = "1920x1080";
        Configuration.pageLoadStrategy = "eager";
        Configuration.timeout = 5000; // default 4000
    }
    @Test
    void checkSoftAssertionsPage() {
        // Открыть страницу репозитория Selenide
        open("https://github.com/selenide/selenide");

        // Перейти в раздел Wiki проекта
        $(("#wiki-tab")).click();
        //Убедитесь, что в списке страниц (Pages) есть страница SoftAssertions
        $("#wiki-content").shouldHave(text("Soft assertions"));
        $("#wiki-content").$(byText("Soft assertions")).click();
        $(byTagAndText("h4","3. Using JUnit5 extend test class:")).shouldBe(visible);

    }
}
