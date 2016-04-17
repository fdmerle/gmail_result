package pages;

import com.codeborne.selenide.Condition;
import org.openqa.selenium.By;
import ru.yandex.qatools.allure.annotations.Step;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.open;


import org.openqa.selenium.NoSuchElementException;


public class GmailPage {
    private By emailAddress = By.id("Email");
    private By nextButton = By.id("next");
    private By passwordField = By.id("Passwd");
    private By signInButton = By.id("signIn");
    private By pageIsLoaded = By.xpath(".//*[@id='gb_70']");
    private String pageURL = "http://gmail.com";
    private static By objOnGmailPage = By.xpath(".//a[@class='appbar-title']//span[@itemprop = 'title']");
    private long timeout = 3000;

    @Step("Login to Gmail")
    public boolean loginToGmail(String gmailLoginName, String gmailPassword) {

        open(pageURL);
        $(emailAddress).waitUntil(Condition.visible, timeout).sendKeys(gmailLoginName);
        $(nextButton).click();
        $(passwordField).waitUntil(Condition.visible, timeout).sendKeys(gmailPassword);
        $(signInButton).click();
        $(pageIsLoaded).waitUntil(Condition.visible, timeout);

        try {
            $(objOnGmailPage).waitUntil(Condition.visible, timeout);
        } catch (NoSuchElementException ex) {

            return false;

        }
        return true;


    }
}

