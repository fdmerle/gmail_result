import org.testng.Assert;
import org.testng.annotations.Test;
import pages.GmailPage;

public class TestRunner extends MainTest {

    @Test
    public void testRunner() {
        gmailPage.loginToGmail(gmailLogin.loginName, gmailLogin.passWord);
        Assert.assertTrue(GmailPage.isLoginToGmail());
    }
}
