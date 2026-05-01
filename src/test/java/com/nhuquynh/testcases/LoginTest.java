package com.nhuquynh.testcases;

import com.nhuquynh.dataproviders.DataProviderFactory;
import com.nhuquynh.helpers.ExcelHelper;
import com.nhuquynh.pages.LoginPage;
import com.nhuquynh.common.BaseTest;
import com.nhuquynh.helpers.CaptureHelper;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class LoginTest extends BaseTest {

    LoginPage loginPage;
    ExcelHelper excelHelper;

    @BeforeMethod
    public void getExcelData(){
        ExcelHelper excelHelper = new ExcelHelper();
        excelHelper.setExcelFile("src/test/resources/dataTest/dataProjectCuoiKhoa.xlsx","Login");
    }

    @Test(priority = 1)
    public void loginSuccess(){
        loginPage = new LoginPage();
        loginPage.loginCRMSuccessWithDataExcel();
        loginPage.verifyLoginSuccess();
    }

    @Test(priority = 2)
    public void loginFailWithEmailInvalid(){
        CaptureHelper.startRecord("loginFailWithEmailInvalid");

        loginPage = new LoginPage();
        loginPage.loginCRMFailWithEmailInvalid();
        loginPage.verifyLoginFail("Invalid email");
    }

    @Test(priority = 3)
    public void loginFailWithPassInvalid(){
        CaptureHelper.startRecord("loginFailWithPassInvalid");

        loginPage = new LoginPage();
        loginPage.loginCRMFailWithPasswordInvalid();
        loginPage.verifyLoginFail("Invalid password");
    }

    @Test(dataProvider = "data_provider_login_excel", dataProviderClass = DataProviderFactory.class)
    public void loginSuccessFromDataProvider(String testcase, String email, String password){
        loginPage = new LoginPage();
        loginPage.loginCRMSuccessWithDataProvider(testcase, email,password);
        loginPage.verifyLoginSuccess();
    }

}
