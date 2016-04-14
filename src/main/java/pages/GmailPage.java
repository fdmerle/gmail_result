package pages;

import com.codeborne.selenide.Condition;
import org.openqa.selenium.By;
import ru.yandex.qatools.allure.annotations.Step;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.open;



public class GmailPage {
    private By emailAddress = By.id("Email");
    private By nextButton = By.id("next");
    private By passwordField = By.id("Passwd");
    private By signInButton = By.id("signIn");
    private String pageURL = "http://gmail.com";
    private static By objOnGmailPage = By.xpath(".//a[@class='appbar-title']//span[@itemprop = 'title']");

    @Step ("Login to Gmail")
    public void loginToGmail(String gmailLoginName, String gmailPassword) {

        open(pageURL);
        $(emailAddress).shouldBe(Condition.visible).sendKeys(gmailLoginName);
        $(nextButton).click();
        $(passwordField).shouldBe(Condition.visible).sendKeys(gmailPassword);
        $(signInButton).click();


    }
    @Step ("Verify than login to gmail page was done")
    public static boolean isLoginToGmail() {

        if ($$(objOnGmailPage).size() >= 1) {
            return false;
        }
        return true;

    }


}
