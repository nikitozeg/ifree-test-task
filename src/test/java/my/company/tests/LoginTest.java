package my.company.tests;

import my.company.steps.LoginPage;
import my.company.steps.TestSettings;
import org.junit.Ignore;
import org.junit.Test;
import ru.yandex.qatools.allure.annotations.Description;
import ru.yandex.qatools.allure.annotations.Severity;
import ru.yandex.qatools.allure.model.SeverityLevel;

/**
 * @author Nikita Ivanov tazg@ya.ru
 *         Date: 6.02.16
 */

//@Title("Positive test suite")
//@Description("In this suite we'll test creating new app")
public class LoginTest extends TestSettings {

    @Ignore
    @Severity(SeverityLevel.CRITICAL)
    @Description("Authorization Test that return HomePage if success")
    @Test
    public void authorizationTest() throws Exception {
        LoginPage lp = new LoginPage(driver);
        lp.submitLogin(valid_email, valid_password);
        //  assertNotNull(dashboardpage);
    }


}

