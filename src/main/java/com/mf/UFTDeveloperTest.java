package com.mf;

import com.hp.lft.report.ReportException;
import com.hp.lft.report.Reporter;
import com.hp.lft.report.Status;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import com.hp.lft.sdk.*;
import com.hp.lft.verifications.*;
import com.hp.lft.sdk.web.*;
import com.hp.lft.sdk.utils.*;

import unittesting.*;

public class UFTDeveloperTest extends UnitTestClassBase {
    Browser browser;

    public UFTDeveloperTest() {
        //Change this constructor to private if you supply your own public constructor

    }

    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
        instance = new UFTDeveloperTest();
        globalSetup(UFTDeveloperTest.class);

    }

    @AfterClass
    public static void tearDownAfterClass() throws Exception {
        globalTearDown();
    }

    @Before
    public void setUp() throws Exception {
        browser = BrowserFactory.launch(BrowserType.CHROME);
        browser.clearCache();
        browser.deleteCookies();
    }

    @After
    public void tearDown() throws Exception {
        browser.closeAllTabs();
    }

    @Test
    public void test() throws GeneralLeanFtException {
        //Reporter.Init(new ReportConfiguration());// Initialize the Reporter with default values

        browser.navigate("http://nimbusserver.aos.com:8087");
        browser.sync();
        WebElement labelLOGONSUBMITBUTTONCAPTIONWebElement = browser.describe(WebElement.class, new WebElementDescription.Builder()
		    .className("button primary")
		    .innerText("Sign-In").build());
        if (labelLOGONSUBMITBUTTONCAPTIONWebElement.exists()){
            try {
                Reporter.reportEvent("Check Not Logged In","The PPM system prompted for credentials, exiting test", Status.Passed);
            } catch (ReportException e) {
                e.printStackTrace();
            }
            return;
        }
        WebElement menuUserIconWebElement = browser.describe(WebElement.class, new WebElementDescription.Builder()
                .id("menuUserIcon").build());
        if (menuUserIconWebElement.exists()){
            menuUserIconWebElement.click();
            try {
                Reporter.reportEvent("Check Not Logged In","The PPM system auto logged in, logging off", Status.Passed);
            } catch (ReportException e) {
                e.printStackTrace();
            }
            Link signOutAdminUserLink = browser.describe(Link.class, new LinkDescription.Builder()
                    .innerText(new RegExpProperty("Sign Out .*")).build());
            signOutAdminUserLink.click();
            browser.sync();
            return;
        }
        else{
            try {
                Reporter.reportEvent("Check Not Logged In","Unexpected page came up, aborting", Status.Failed);
            } catch (ReportException e) {
                e.printStackTrace();
            }
            return;
        }

    }

}