package my.company.tests;

import my.company.steps.*;
import org.junit.Test;
import ru.yandex.qatools.allure.annotations.Description;
import ru.yandex.qatools.allure.annotations.Severity;
import ru.yandex.qatools.allure.annotations.Title;
import ru.yandex.qatools.allure.model.SeverityLevel;

import java.util.Calendar;

import static org.junit.Assert.*;

/**
 * @author Nikita Ivanov tazg@ya.ru
 *         Date: 6.02.16
 */

@Title("Suite contain positive and negative cases")
@Description("In this suite we'll test creating new app form")
public class AddNewAppTest extends TestSettings {
    int todayDay;
    int year;
    String fullDate;
    String todaysDayAndYear;

    @Severity(SeverityLevel.CRITICAL)
    @Description("Creating new app and checking saved fields")
    @Test
    public void addNewApp() throws Exception {
        fullDate = rightNow.getInstance().getTime().toString();       // date in same format: Sun Feb 07 18:59:20 MSK 2016
        todayDay = rightNow.getInstance().get(Calendar.DAY_OF_MONTH);
        year = rightNow.getInstance().get(Calendar.YEAR);
        todaysDayAndYear = todayDay + ", " + year;                    // converting date to moneytapp format

        LoginPage lp = new LoginPage(driver);
        HomePage dashboardpage = lp.submitLogin(valid_email, valid_password); // authorization
        assertNotNull(dashboardpage);
        AppsPage appspage = new HomePage(driver).goToApps();                  //go to APPS page
        appspage.clickAddNewApp();                                            // open create new app form
        NetworksPage netwpage = appspage.addNewApp(fullDate);                 //trying to save app with valid fields
        appspage = netwpage.goToApps();                                       //go back to app list
        assertEquals(fullDate, appspage.getLastEntryName());                  //get last row in table, and checking it with saved app
        assertEquals("0", appspage.getLastEntryNetworks());                   //check networks of saved app
        assertEquals("3", appspage.getLastEntryAdPlaces());                   //check adplaces of saved app
        assertEquals("Android", appspage.getLastEntryPlatform());             //check platform if saved app
        assertTrue("Not contains", appspage.getLastEntryDate().contains(todaysDayAndYear)); //check date
        appspage.makeScreenshot();                                            //make a screenshot, (available in allure)
    }

    @Severity(SeverityLevel.CRITICAL)
    @Description("Checking for validating empty fields")
    @Test
    public void checkFieldsValidating() throws Exception {
        LoginPage lp = new LoginPage(driver);
        HomePage dashboardpage = lp.submitLogin(valid_email, valid_password);
        assertNotNull(dashboardpage);
        AppsPage appspage = new HomePage(driver).goToApps();
        appspage.clickAddNewApp();
        appspage.clickSave();                                                     //click save without filling fields
        appspage.getAdplaceErrorMsg();
        assertEquals("Empty adPlace name field!", appspage.getAdplaceErrorMsg()); //check error message
        assertEquals("Empty category field!", appspage.getCategoryErrorMsg());    //check error message

    }
}

