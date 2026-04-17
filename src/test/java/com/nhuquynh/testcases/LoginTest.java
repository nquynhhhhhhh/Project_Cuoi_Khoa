package com.nhuquynh.testcases;

import com.nhuquynh.helpers.ExcelHelper;
import com.nhuquynh.pages.LoginPage;
import com.nhuquynh.common.BaseTest;
import com.nhuquynh.helpers.CaptureHelper;
import com.nhuquynh.keywords.WebUI;
import org.testng.annotations.Test;


public class LoginTest extends BaseTest {

    LoginPage loginPage;

    @Test(priority = 1)
    public void loginSuccess(){
        ExcelHelper excelHelper = new ExcelHelper();
        excelHelper.setExcelFile("src/test/resources/dataTest/dataProjectCuoiKhoa.xlsx","Login");

        loginPage = new LoginPage();
        loginPage.loginCRM(
                excelHelper.getCellData("Email",1),
                excelHelper.getCellData("Password",1)
        );
        loginPage.verifyLoginSuccess();
    }

    @Test(priority = 2)
    public void loginFailWithEmailInvalid(){
        CaptureHelper.startRecord("loginFailWithEmailInvalid");
        ExcelHelper excelHelper = new ExcelHelper();
        excelHelper.setExcelFile("src/test/resources/dataTest/dataProjectCuoiKhoa.xlsx","Login");

        loginPage = new LoginPage();
        loginPage.loginCRM(
                excelHelper.getCellData("Email",2),
                excelHelper.getCellData("Password",2)
        );
        loginPage.verifyLoginFail("Invalid email or password");
    }

    @Test(priority = 3)
    public void loginFailWithPassInvalid(){
        CaptureHelper.startRecord("loginFailWithPassInvalid");
        ExcelHelper excelHelper = new ExcelHelper();
        excelHelper.setExcelFile("src/test/resources/dataTest/dataProjectCuoiKhoa.xlsx","Login");

        loginPage = new LoginPage();
        loginPage.loginCRM(
                excelHelper.getCellData("Email",3),
                excelHelper.getCellData("Password",3)
        );
        loginPage.verifyLoginFail("Invalid email or password");
    }

}
