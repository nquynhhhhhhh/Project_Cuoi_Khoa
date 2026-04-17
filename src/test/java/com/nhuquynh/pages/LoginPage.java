package com.nhuquynh.pages;

import com.nhuquynh.drivers.DriverManager;
import com.nhuquynh.helpers.PropertiesHelper;
import com.nhuquynh.keywords.WebUI;
import com.nhuquynh.utils.LogUtils;
import org.openqa.selenium.By;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;

public class LoginPage {

    //Khai báo các element dạng đối tượng By (phương thức tìm kiếm)
    private By headerPage = By.xpath("//h1[normalize-space()='Login']");
    private By inputEmail = By.xpath("//input[@id='email']");
    private By inputPassword = By.xpath("//input[@id='password']");
    private By buttonLogin = By.xpath("//button[normalize-space()='Login']");
    private By errorMessage = By.xpath("//div[contains(@class,'alert-danger')]");
    private By errorMessage1 = By.xpath("(//div[contains(@class,'alert-danger')])[1]");
    private By errorMessage2 = By.xpath("(//div[contains(@class,'alert-danger')])[2]");


      public DashboardPage loginCRM() {
        WebUI.openURL(PropertiesHelper.getValue("URL"));
        WebUI.setText(inputEmail, "admin@example.com");
        WebUI.setText(inputPassword, "123456");
        WebUI.clickElement(buttonLogin);
        verifyLoginSuccess(); //khi login thì check luôn có succes kh

        return new DashboardPage();
    }

    public void loginCRM(String email, String password) {
        LogUtils.info("");
        WebUI.openURL(PropertiesHelper.getValue("URL"));
        WebUI.waitForPageLoaded();
        WebUI.clearText(inputEmail);
        WebUI.clearText(inputPassword);
        WebUI.setText(inputEmail, email);
        WebUI.setText(inputPassword, password);
        WebUI.clickElement(buttonLogin);
    }

    public void verifyLoginSuccess() {
        WebUI.waitForPageLoaded();
        WebUI.assertNotContains(WebUI.getCurrentURL(),"authentication", "FAIL. Vẫn đang ở trang Login");
    }

    public void verifyLoginFail() {
        WebUI.assertContains(WebUI.getCurrentURL(),"authentication", "FAIL. Vẫn đang ở trang Login");
        Assert.assertTrue(DriverManager.getDriver().findElement(errorMessage).isDisplayed(), "Error message NOT displays");
        WebUI.assertEquals(WebUI.getElementText(errorMessage),"Invalid email or password", "Content of error message NOT match.");
    }

    public void verifyLoginFail(String message) { //khi gọi hàm phải truyền text nhưng sử dụng được nhiều TH
        WebUI.assertContains(WebUI.getCurrentURL(),"authentication", "FAIL. Vẫn đang ở trang Login");
        Assert.assertTrue(DriverManager.getDriver().findElement(errorMessage).isDisplayed(), "Error message NOT displays");
        WebUI.assertEquals(WebUI.getElementText(errorMessage),message, "Content of error massage NOT match.");
    }


}

