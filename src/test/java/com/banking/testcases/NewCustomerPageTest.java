package com.banking.testcases;

import com.banking.base.BaseClass;
import com.banking.base.BasePage;
import com.banking.pages.CreateMangerCredentialPage;
import com.banking.pages.LoginPage;
import com.banking.pages.ManagerHomePage;
import com.banking.pages.NewCustomerPage;
import com.banking.util.IAutoConstant;
import com.banking.util.JsonReader;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.FileNotFoundException;

public class NewCustomerPageTest extends BaseTest {
    private NewCustomerPage newCustomerPage;
    private LoginPage loginPage;
    private ManagerHomePage managerHomePage;
    private CreateMangerCredentialPage mangerCredentialPage;
    private BasePage titleOfPage;

    @BeforeMethod
    public void setUp() {
        loginPage = new LoginPage();
        managerHomePage = new ManagerHomePage();
        titleOfPage = new BaseClass();
        mangerCredentialPage = new CreateMangerCredentialPage();
        loginPage = mangerCredentialPage.getCilckOnBankinProjectLink();
        log.info("Click on banking project link");
        managerHomePage = loginPage.login(properties.getProperty("userID"), properties.getProperty("password"));
        log.info("Enter email and password");
        newCustomerPage = new NewCustomerPage();
        newCustomerPage = managerHomePage.getClickOnNewCustomerLink();
        log.info("Click on new customer link");
    }

    @Test(description = "New customer page title test")
    public void verifyTitleTest() {
        String title = titleOfPage.getTitleOnPage();       //override
        Assert.assertEquals(title, IAutoConstant.NEW_COSTOMER_PAGE_TITLE);
        log.info("title is matched");
    }


    @Test(description = "All field to be added in new customer page")
    public void addAllFieldOfNewCustomerTest(){
        newCustomerPage.setCustomerName("sona");
        newCustomerPage.setGender();
        newCustomerPage.setDateOfBirth("19/05/1994");
        newCustomerPage.setAddress("casalotus");
        newCustomerPage.setCity("Nagpur");
        newCustomerPage.setState("maharashtra");
        newCustomerPage.setPinCode("4410004");
        newCustomerPage.setTelephoneNumber("9910006680");
        newCustomerPage.setEmailId("sonabankar@gmail.com");
        newCustomerPage.setSubmitButton();
        log.info("enter all the data of new customer and click on submit link");

    }

    @Test(description = "Click on home link then return to manager page")
    public void clickOnHomeLinkReturnTohomePageTest() {
        managerHomePage = newCustomerPage.clickOnHomeLink();
        log.info("Return to home page");
    }
}
