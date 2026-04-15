package com.nhuquynh.pages;

import com.nhuquynh.keywords.WebUI;
import org.openqa.selenium.By;
import org.testng.Assert;

public class ProjectPage extends BasePage{
    private By inputSearchProject = By.xpath("//div[@id='projects_filter']//input");
    private By headerProjectPage = By.xpath("//span[normalize-space()='Projects Summary']");
    private By buttonAddNewProject = By.xpath("//a[normalize-space()='New Project']");
    private By titleAddNewProject = By.xpath("//a[normalize-space()='Project']/preceding::h4");
    private By inputProjectName = By.xpath("//input[@id='name']");
    private By dropdownCustomer = By.xpath("//button[@data-id='clientid']");
    private By inputSearchCustomerProject = By.xpath("//button[@data-id='clientid']/following-sibling::div//input[@type='search']");
    private By itemYHL = By.xpath("//button[@data-id='clientid']/following-sibling::div//span[normalize-space()='Công ty YHL 20260414']");
    private By checkboxCalculateProgress = By.xpath("//input[@id='progress_from_tasks']");
    private By scrollProgress = By.xpath("//input[@name='progress']/following-sibling::div/span");
    private By dropdowmBillingType = By.xpath("//button[@data-id='billing_type']");
    private By itemTaskHours = By.xpath("//button[@data-id='billing_type']/following-sibling::div//a[@id='bs-select-1-3']");
    private By dropdownStatus = By.xpath("//button[@data-id='status']");
    private By itemInProgress = By.xpath("//div[@id='bs-select-2']//span[normalize-space()='In Progress']");
    private By inputEstimatedHours = By.xpath("//input[@id='estimated_hours']");
    private By dropdownMember = By.xpath("//button[@data-id='project_members[]']");
    private By buttonSelectAll = By.xpath("//button[@data-id='project_members[]']/following-sibling::div//button[normalize-space()='Select All']");
    private By inputStartDate = By.xpath("//input[@id='start_date']/following-sibling::div[@class='input-group-addon']");
    private By item20260413 = By.xpath("//tr//td[@data-date='13' and @data-month='3' and @data-year='2026']/div"); //tháng 4 nhưng bắt đầu từ 0 => data-month='3'
    private By buttonNextMonth = By.xpath("//div[@class='xdsoft_label xdsoft_year']/following-sibling::button");
    private By item20260513 = By.xpath("//tr//td[@data-date='13' and @data-month='4' and @data-year='2026']/div");
    private By inputDeadline = By.xpath("//input[@id='deadline']");
    private By inputTag = By.xpath("//input[@id='tags']/following-sibling::ul/li[@class='tagit-new']/input");
    private By inputDescription = By.xpath("//body[@id='tinymce']");
    private By checkboxSendProjectCreateEmail = By.xpath("//input[@id='send_created_email']");
    private By buttonSaveProject = By.xpath("//button[normalize-space()='Save']");
    private By buttonProjectName = By.xpath("//button[@title='Xây nhà cùng Vĩnh Tường YHL - CTy Vĩnh Tường YHL 10']");
    private By tabOverview = By.xpath("//a[normalize-space()='Overview']");
    private By progressBarOfProject = By.xpath("//div[@class='progress progress-bar-mini']/preceding-sibling::p/span");
    private By progressBarOfOpenTask = By.xpath("//div[@class='project-overview-open-tasks']");
    private By progressBarOfDateLeft = By.xpath("//div[@class='col-md-6 project-progress-bars project-overview-days-left']//div[@class='panel-body !tw-px-5 !tw-py-4']");
    private By dropdownMenuProjectLoggedTime = By.xpath("//a[@id='dropdownMenuProjectLoggedTime']");
    private By itemThisMonth = By.xpath("//a[normalize-space()='This Month']");
    private By timesheetsChart = By.xpath("//canvas[@id='timesheetsChart']");

    public void verifyNavigateToProjectPage(){
        Assert.assertTrue(WebUI.checkElementExist(headerProjectPage),"The Project header page not dissplay.");
        Assert.assertEquals(WebUI.getElementText(headerProjectPage),"Projects Summary", "The Project header page not match");
    }

    public void clickButtonAddNewProject(){
        WebUI.clickElement(buttonAddNewProject);
    }

    public void submitDataForNewProject(String projectName, String customerName) {
        WebUI.setText(inputProjectName, projectName);
        WebUI.clickElement(dropdownCustomer);
        WebUI.setText(inputSearchCustomerProject,customerName);
        WebUI.clickElement(itemYHL);
        WebUI.sleep(2);
        WebUI.clickElement(dropdowmBillingType);
        WebUI.clickElement(itemTaskHours);
        WebUI.clickElement(dropdownStatus);
        WebUI.clickElement(itemInProgress);
        WebUI.setText(inputEstimatedHours,"25");
        WebUI.clickElement(dropdownMember);
        WebUI.clickElement(buttonSelectAll);
        WebUI.clickElement(dropdownMember);
        WebUI.sleep(2);
        WebUI.setText(inputStartDate,"13-04-2026");
        WebUI.setText(inputDeadline,"13-05-2026");
        WebUI.setText(inputTag,"VinhTuongYHL");
        WebUI.setText(inputTag,",");
        WebUI.setText(inputTag,"ThachCao");
        WebUI.sleep(2);
        WebUI.setTextOnFrameDescription("description_ifr", "tinymce", "Giá cả hợp lý, Chất liệu hợp thời");
        WebUI.sleep(2);





    }
}
