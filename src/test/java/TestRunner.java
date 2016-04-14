import org.testng.Assert;
import org.testng.annotations.Test;
import pages.GmailPage;
import ru.yandex.qatools.allure.annotations.Description;
import ru.yandex.qatools.allure.annotations.Step;
@Description("This is an example test suite")
public class TestRunner extends MainTest {

    @Test
    public void testRunner() {
        gmailPage.loginToGmail(gmailLogin.loginName, gmailLogin.passWord);
        Assert.assertTrue(GmailPage.isLoginToGmail());
    }
}
