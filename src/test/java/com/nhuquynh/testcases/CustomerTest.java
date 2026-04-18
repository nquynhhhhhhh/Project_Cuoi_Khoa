package com.nhuquynh.testcases;

import com.nhuquynh.helpers.ExcelHelper;
import com.nhuquynh.pages.CustomerPage;
import com.nhuquynh.pages.DashboardPage;
import com.nhuquynh.pages.LoginPage;
import com.nhuquynh.common.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CustomerTest extends BaseTest {
    LoginPage loginPage;
    DashboardPage dashboardPage;
    CustomerPage customerPage;
    ExcelHelper excelHelper;

    @BeforeMethod
    public void getExcelData(){
        ExcelHelper excelHelper = new ExcelHelper();
        excelHelper.setExcelFile("src/test/resources/dataTest/dataProjectCuoiKhoa.xlsx","Customer");
    }

    @Test
    public void testAddNewCustomer(){
        loginPage = new LoginPage();
        dashboardPage = loginPage.loginCRM();
        customerPage = dashboardPage.clickMenuCustomer();
        customerPage.verifyNavigateToCustomerPage();
        int berofeTotal = customerPage.getCustomersTotal();
        customerPage.clickButtonAddNewCustomer();
        customerPage.submitDataForNewCustomer(1);
        customerPage.verifyNavigateToCustomerDetailPage();
        //Lấy URL để check bên Project Page
        customerPage.getAndSetURLCustomer();
        customerPage.verifyAddNewCustomerSuccess(1);
        customerPage.clickMenuCustomer();

        int afterTotal = customerPage.getCustomersTotal();
        Assert.assertEquals(afterTotal, berofeTotal + 1, "The total customer beforeTotal and afterTotal not match ");
        customerPage.setStatus();
    }

    @Test
    public void testAddNewCustomer_NullCompany(){
        loginPage = new LoginPage();
        dashboardPage = loginPage.loginCRM();
        customerPage = dashboardPage.clickMenuCustomer();
        customerPage.verifyNavigateToCustomerPage();
        int berofeTotal = customerPage.getCustomersTotal();
        customerPage.clickButtonAddNewCustomer();
        //check có show alert không và có tạo được không
        customerPage.submitData_WithNullCompany(1);
    }

    @Test
    public void testAddNewCustomer_searchInTable(){
        loginPage = new LoginPage();
        dashboardPage = loginPage.loginCRM();
        customerPage = dashboardPage.clickMenuCustomer();
        customerPage.verifyNavigateToCustomerPage();
        int berofeTotal = customerPage.getCustomersTotal();
        customerPage.clickButtonAddNewCustomer();
        customerPage.submitDataForNewCustomer(1);

        //search and check customer name in table
        customerPage.searchAndCheckCustomerInTable(1);
        customerPage.clickFirstItemCustomer();

        //verify data of new customer in profile page
        customerPage.verifyNavigateToCustomerDetailPage();
        customerPage.verifyAddNewCustomerSuccess(1);

        //compare total customer
        customerPage.clickMenuCustomer();
        int afterTotal = customerPage.getCustomersTotal();
        Assert.assertEquals(afterTotal, berofeTotal + 1, "The total customer beforeTotal and afterTotal not match ");

    }

}
