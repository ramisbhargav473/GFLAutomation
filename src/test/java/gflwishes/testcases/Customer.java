package gflwishes.testcases;

import gflwishes.PageObjects.CustomerPage;
import gflwishes.PageObjects.LandingPage;
import gflwishes.PageObjects.LoginPage;
import gflwishes.base.EnhancedBaseClass;
import org.apache.log4j.Logger;
import org.testng.annotations.Test;

import java.io.IOException;

//import java.util.List;
//import java.util.Random;
//import org.openqa.selenium.*;

public class Customer extends EnhancedBaseClass {

    public Customer() {
        log4j = Logger.getLogger("Customer");
    }

    public static int getRandomIntBetweenRange(int min, int max) {
        int x = (int) ((Math.random() * ((max - min) + 1)) + min);
        return x;
    }

    @Test
    public void TC001WS_Verify_Create_new_Customer_Functionality() {

        testCaseLog("TC001_TC002_TC003_Verify_Create_new_Customer_Functionality");

        LoginPage login = new LoginPage(driver);
        LandingPage lp = new LandingPage(driver);
        CustomerPage cp = new CustomerPage(driver);
        int rows = cp.getRowsExcel();

        login.loginAs(USER_NAME, PASSWORD);

        if (lp.isUserLoginSuccessful()) {
            success("User Login Successful");
        } else {
            failure("Failed to Login");
        }

        for (int i = 1; i < rows - 1; i++) {
            try {
                lp.OpenCustomer();


                if (cp.isCustomerPageOpen()) {
                    success("Customers page open successfully");
                } else {
                    failure("Customers page not open");
                }
                cp.clickonAddCustomerButton();
                if (cp.isPopupdisplayed()) {
                    success("Popup displayed");
                } else {
                    failure("Popup not displayed");
                }
                cp.typeCustomername(i);
                cp.clickonCreateNewCustomerlnk();
                if (cp.isEnteredCustomerDisplayed()) {
                    success("Entered customer name displayed as companyname");
                } else {
                    failure("Entered customer name not displayed as companyname");
                }
                cp.selectBusinessUnit1(i);
                cp.selectJurisdiction();
                cp.selectcustomertype();
                cp.selectAddressline1();
                //cp.selectcountry();
                //cp.selectState();
                //cp.typeCity();

                cp.selectBillingAddAsCompanyAdd();
                cp.typeContact();
                cp.typeEmail();
                cp.typeContactPosition();
                cp.typePhoneNumber();
                cp.typeExtention();
                cp.typeSiteName(i);
                cp.selectBusinessUnit();
                cp.selectBusinessType();
                cp.typePoNumber();
                cp.DeSelectsiteAddressesSameAsCompanyAddresses();
                cp.selectAddressline1ofSite(i);
                cp.typePostalcode(i);
                cp.SelectbillToCustomerBillingAddress();
                cp.clickonbtnSaveCustomer();
                if (cp.isSuccessMessageDisplayed()) {
                    success("Success Message displayed");
                } else {
                    failure("Success message not displayed");
                }
                if (cp.isCustomerAdded()) {
                    success("Customer Added successfully");
                } else {
                    failure("Customer not Added successfully");
                }
                cp.getCustomerID(i);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        sa.assertAll();
    }

    @Test
    public void TC004_Edit_Customer_Functionality() throws IOException, InterruptedException {

        testCaseLog("TC004_Edit_Customer_Functionality");

        LoginPage login = new LoginPage(driver);
        LandingPage lp = new LandingPage(driver);
        CustomerPage cp = new CustomerPage(driver);//object creation for project page


        login.loginAs(USER_NAME, PASSWORD);

        if (lp.isUserLoginSuccessful()) {
            success("User Login Successful");
        } else {
            failure("Failed to Login");
        }


        lp.OpenCustomer();


        if (cp.isCustomerPageOpen()) {
            success("Customers page open successfully");
        } else {
            failure("Customers page not open");
        }

        cp.openfirstCustomer();
        cp.clickonEditCustomer();
        cp.EditContactPosition();
        cp.clickonSaveChanges();
        if (cp.ischangesSaved()) {
            success("Edit Customers functionality is working");
        } else {
            failure("Edit Customers Functionality not working");
        }


        sa.assertAll();
    }


}