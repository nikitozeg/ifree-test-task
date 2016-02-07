package my.company.steps;

import org.openqa.selenium.WebDriver;
import ru.yandex.qatools.allure.annotations.Step;

/**
 * @author Nikita Ivanov tazg@ya.ru
 *         Date: 6.02.16
 */
public class HomePage {

    private WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    @Step
    public AppsPage goToApps() throws InterruptedException {
        driver.get("http://ui.moneytapp.vas61t.test.i-free.ru/webui-rc/apps/list");
        return new AppsPage(driver);
    }

}
