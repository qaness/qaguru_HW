package hw_selenide;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;


public class SoftAssertions {

    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
        //    Configuration.holdBrowserOpen = true;
        Configuration.pageLoadStrategy = "eager";
    }

    @Test
    void checkingJUnit5Test() {
        open("https://github.com/selenide/selenide");
        $("#wiki-tab").click();
        $("#wiki-pages-filter").setValue("Soft");
        $$(".js-wiki-sidebar-toggle-display li")
                .findBy(Condition.text("SoftAssertions"))
                .should(exist)
                .$("a").click();
        $(".markdown-body")
                .$$("h4")
                .findBy(Condition.text("Using JUnit5 extend test class:"))
                .sibling(0)
                .shouldHave(text("""
                   @ExtendWith({SoftAssertsExtension.class})
                                 class Tests {
                                   @Test
                                   void test() {
                                     Configuration.assertionMode = SOFT;
                                     open("page.html");

                                     $("#first").should(visible).click();
                                     $("#second").should(visible).click();
                                   }
                                 }
                """));
        // sleep(5000);

    }
}
