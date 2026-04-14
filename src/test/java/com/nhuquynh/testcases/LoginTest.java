package com.nhuquynh.testcases;

import com.nhuquynh.pages.LoginPage;
import com.nhuquynh.common.BaseTest;
import com.nhuquynh.helpers.CaptureHelper;
import com.nhuquynh.keywords.WebUI;
import org.testng.annotations.Test;


public class LoginTest extends BaseTest {

    LoginPage loginPage;

    @Test(priority = 1)
    public void loginSuccess(){
        loginPage = new LoginPage();
        loginPage.loginCRM("admin@example.com","123456");
        WebUI.sleep(1);
        loginPage.verifyLoginSuccess();
    }

    @Test(priority = 2)
    public void loginFailWithEmailInvalid(){
        CaptureHelper.startRecord("loginFailWithEmailInvalid");
        loginPage = new LoginPage();
        loginPage.loginCRM("admin99@example.com","123456");
        loginPage.verifyLoginFail("Invalid email");
    }

    @Test(priority = 3)
    public void loginFailWithPassInvalid(){
        CaptureHelper.startRecord("loginFailWithPassInvalid");
        loginPage = new LoginPage();
        loginPage.loginCRM("admin@example.com","112233");
        loginPage.verifyLoginFail("Invalid password");
    }

}
