package my.company.steps;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import ru.yandex.qatools.allure.annotations.Step;

/**
 * @author Nikita Ivanov tazg@ya.ru
 *         Date: 6.02.16
 */

public class LoginPage {

    private WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    By EmailLoginFieldLocator = By.id("j_username"); //поле для ввода e-mail
    By PasswdLoginFieldLocator = By.id("j_password"); //поле для ввода пароля
    By signInButtonLocator = By.cssSelector("input.force-right"); //кнопка Войти

    @Step
    public void userTypeEmailInLoginForm(String email) {
        driver.findElement(EmailLoginFieldLocator).sendKeys(email);
    }

    @Step
    public void userTypePasswdInLoginForm(String password) {
        driver.findElement(PasswdLoginFieldLocator).sendKeys(password);
    }

    @Step
    public void userClickSignInButton(){ //метод для клика по кнопке войти
        driver.findElement(signInButtonLocator).click(); //находим элемент и кликаем по нему
    }

    @Step
    public HomePage submitLogin(String email, String password){ //объединяем все 3 метода в один, который возвращает нам уже новую страницу
        userTypeEmailInLoginForm(email); //вводим email
        userTypePasswdInLoginForm(password); //вводим проль
        userClickSignInButton(); //кликаем войти
        return new HomePage(driver); //получаем страницу почты
    }

    @Step
    public LoginPage submitLoginExpectingFailure() {
        // This is the only place that submits the login form and expects the destination to be the login page due to login failure.
        driver.findElement(EmailLoginFieldLocator).submit();

        // Return a new page object representing the destination. Should the user ever be navigated to the home page after submiting a login with credentials
        // expected to fail login, the script will fail when it attempts to instantiate the LoginPage PageObject.
        return new LoginPage(driver);
    }
}
