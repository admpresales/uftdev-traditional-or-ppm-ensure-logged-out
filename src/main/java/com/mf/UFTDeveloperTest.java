package com.mf;

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
    }

    @Test
    public void test() throws GeneralLeanFtException {
        browser.navigate("http://nimbusserver.aos.com:8087");
    }

}