package my.company.steps;

import org.openqa.selenium.*;
import ru.yandex.qatools.allure.annotations.Attachment;
import ru.yandex.qatools.allure.annotations.Step;

/**
 * @author Nikita Ivanov tazg@ya.ru
 *         Date: 6.02.16
 */
public class AppsPage {

    private WebDriver driver;
    private WebElement element;

    public AppsPage(WebDriver driver) {
        this.driver = driver;
    }

    By appNameLocator = By.cssSelector("input#name.form-control");
    By clickAddNewAppLocator = By.cssSelector("a.pull-right");
    By setCategoryCheckboxLocator = By.xpath("//span[@class=\"tree-checkbox tree-checkbox0\"]");
    By clickSaveLocator = By.cssSelector("a.btn.btn-lg.btn-success");
    By getAdplaceErrorMsgLocator = By.xpath("//*[contains(@class, 'text-left')]/ul/li[1]");
    By getCategoryErrorMsgLocator = By.xpath("//*[contains(@class, 'text-left')]/ul/li[2]");
    By lastAppRowLocator = By.cssSelector("table#apps.table.table-striped.table-hover.listTable.appsList tbody tr:last-child");
    By setFileUploadLocator = By.name("appIconFile");
    By lastEntryNetworksLocator = By.xpath("td[2]/a");
    By lastEntryNameLocator = By.xpath("td[1]/a");
    By lastEntryAdplacesLocator = By.xpath("td[3]/a");
    By lastEntryPlatformLocator = By.xpath("td[4]");
    By lastEntryDateLocator = By.xpath("td[5]");

    String filePath = System.getProperty("user.dir") + "\\src\\test\\resources\\1.png"; //set relative path to icon


    @Step
    public void clickAddNewApp() {
        driver.findElement(clickAddNewAppLocator).click();
    }

    @Step("Set app name to: {0}")
    public void setAppName(String nameapp) {
        driver.findElement(appNameLocator).sendKeys(nameapp);
    }

    @Step
    public void setCategory() {
        driver.findElement(setCategoryCheckboxLocator).click();
    }

    @Step
    public void clickSave() {
        driver.findElement(clickSaveLocator).click();
    }

    @Step
    public String getAdplaceErrorMsg() {
        return driver.findElement(getAdplaceErrorMsgLocator).getText();
    }

    @Step
    public String getCategoryErrorMsg() {
        return driver.findElement(getCategoryErrorMsgLocator).getText();
    }

    @Step
    public void setFileUpload() {
        driver.findElement(setFileUploadLocator).sendKeys(filePath);
    }


    @Step
    public NetworksPage addNewApp(String nameapp) {
        setAppName(nameapp);
        setFileUpload();
        setCategory();
        clickSave();
        return new NetworksPage(driver);
    }

    @Step
    public String getLastEntryName() {
        element = driver.findElement(lastAppRowLocator);
        return element.findElement(lastEntryNameLocator).getText();
    }

    @Step
    public String getLastEntryNetworks() {
        return element.findElement(lastEntryNetworksLocator).getText();
    }

    @Step
    public String getLastEntryAdPlaces() {
        return element.findElement(lastEntryAdplacesLocator).getText();
    }

    @Step
    public String getLastEntryPlatform() {
        return element.findElement(lastEntryPlatformLocator).getText();
    }

    @Step
    public String getLastEntryDate() {
        return element.findElement(lastEntryDateLocator).getText();
    }


    @Attachment(type = "image/png")
    public byte[] makeScreenshot() {
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }

}
