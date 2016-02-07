package my.company.steps;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import ru.yandex.qatools.allure.annotations.Step;

/**
 * @author Nikita Ivanov tazg@ya.ru
 *         Date: 6.02.16
 */

public class NetworksPage {
    private WebDriver driver;

    public NetworksPage(WebDriver driver) {
        this.driver = driver;
    }

    By getAppNameFromHeaderLocator = By.cssSelector("h1");
    int MILLISECOND=5000;
    @Step
    public String getAppNameFromHeader() {
        return driver.findElement(getAppNameFromHeaderLocator).getText();
    }

    @Step
    public AppsPage goToApps() throws InterruptedException {
      //  driver.get("http://ui.moneytapp.vas61t.test.i-free.ru/webui-rc/apps/list");
        Thread.sleep(MILLISECOND);
        driver.findElement(By.linkText("Apps")).click();
        return new AppsPage(driver);
    }

}
