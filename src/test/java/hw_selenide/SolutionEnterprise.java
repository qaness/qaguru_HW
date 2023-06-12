package hw_selenide;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selectors;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverConditions.*;



public class SolutionEnterprise {

    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
        //    Configuration.holdBrowserOpen = true;
        Configuration.pageLoadStrategy = "eager";
    }

    @Test
    void tryingToUseHoverTest() {
        open("https://github.com");
        $$("button").findBy(Condition.text("Solutions")).hover()
               .sibling(0)
                .$(Selectors.byText("Enterprise")).should(exist).click();
        $(Selectors.byText("Build like the best")).should(exist);

        //дополнительная проверка что открылся нужный url
        webdriver().shouldHave(url("https://github.com/enterprise"));


        //sleep(5000);

    }
}
