package com.nhuquynh.pages;

import com.nhuquynh.common.BasePage;
import com.nhuquynh.drivers.DriverManager;
import com.nhuquynh.helpers.ExcelHelper;
import com.nhuquynh.keywords.WebUI;
import com.nhuquynh.utils.LogUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class ProjectPage extends BasePage {
    CustomerPage customerPage;
//Project Page
    private By inputSearchProject = By.xpath("//div[@id='projects_filter']//input");
    private By buttonSearch = By.xpath("//span[@class='input-group-addon']");
    private By headerProjectPage = By.xpath("//span[normalize-space()='Projects Summary']");
    private By totalProjectInProgress = By.xpath("//span[normalize-space()='In Progress']/preceding-sibling::span");
    private By buttonAddNewProject = By.xpath("//a[normalize-space()='New Project']");
    private By itemProjectCheck(String projectNumber, String projectName) {
        By xpathProject = By.xpath("//tr[.//a[text()='"+ projectNumber +"'] and .//a[text()='"+ projectName +"']]");
        return xpathProject;
    }
    private By itemOnTable(String projectName) {
        By rowItem = By.xpath("(//tbody//tr//a[normalize-space()='" + projectName + "'])/ancestor::tr");
        return rowItem;
    }
    private By itemProjectNumberCheck = By.xpath("//tbody/tr[1]/td[1]/a");
    private By itemProjectNumberCheck(String projectNumber) {
        By xpathProjectNumber = By.xpath("//tbody//tr//a[normalize-space()='" + projectNumber + "']");
        return xpathProjectNumber;
    }
    private By itemProjectNameCheck(String projectName) {
        By xpathProjectName = By.xpath("//tbody//tr//a[normalize-space()='" + projectName + "']");
        return xpathProjectName;
    }
    private By buttonEdit(String projectName) {
        By xpathButtonEdit = By.xpath("(//table[@id='projects']//tr//a[normalize-space()='" + projectName + "'])/following-sibling::div//a[normalize-space()='Edit']");
        return xpathButtonEdit;
    }
    private By buttonDelete = By.xpath("//tbody/tr[1]//a[contains(text(),'Delete')]");

//ADD NEW PROJECT
    private By titleAddNewProject = By.xpath("//a[normalize-space()='Project']/preceding::h4");
    private By inputProjectName = By.xpath("//input[@id='name']");
    private By dropdownCustomer = By.xpath("//button[@data-id='clientid']");
    private By inputSearchCustomerProject = By.xpath("//button[@data-id='clientid']/following-sibling::div//input[@type='search']");
    private By itemCustomer(String customerName) {
        By xpathCustomer = By.xpath("//button[@data-id='clientid']/following-sibling::div//span[normalize-space()='" + customerName + "']");
        return xpathCustomer;
    }
    private By checkboxCalculateProgress = By.xpath("//input[@id='progress_from_tasks']");
    private By scrollProgress = By.xpath("//input[@name='progress']/following-sibling::div/span");
    private By dropdowmBillingType = By.xpath("//button[@data-id='billing_type']");
    private By itemBillingType(String billingType) {
        By xpathBillingType = By.xpath("//button[@data-id='billing_type']/following-sibling::div//span[@class='text' and contains(., '" + billingType + "')]");
        return xpathBillingType;
    }
    private By dropdownStatus = By.xpath("//button[@data-id='status']");
    private By itemStatus(String status) {
        By xpathStatus = By.xpath("//div[@id='bs-select-2']//span[normalize-space()='" + status + "']");
        return xpathStatus;
    }
    private By inputEstimatedHours = By.xpath("//input[@id='estimated_hours']");
    private By dropdownMember = By.xpath("//button[@data-id='project_members[]']");
    private By buttonDeselectAll = By.xpath("//button[@data-id='project_members[]']/following-sibling::div//button[normalize-space()='Deselect All']");
    private By buttonSelectAll = By.xpath("//button[@data-id='project_members[]']/following-sibling::div//button[normalize-space()='Select All']");
    private By itemMember(String member) {
        By xpathMember = By.xpath("//button[contains(@data-id,'project_members')]/following-sibling::div/descendant::span[normalize-space()='" + member + "']");
        return xpathMember;
    }
    private By inputStartDate = By.xpath("//input[@id='start_date']");
    private By inputDeadline = By.xpath("//input[@id='deadline']");
    private By inputTags = By.xpath("//input[@id='tags']/following-sibling::ul/li[@class='tagit-new']/input");
    private By iconCloseTag = By.xpath("//span[@class='text-icon']");
    private By inputDescription = By.xpath("//body[@id='tinymce']");
    private By checkboxSendProjectCreateEmail = By.xpath("//input[@id='send_created_email']");
    private By buttonSaveProject = By.xpath("//button[normalize-space()='Save']");
//OVERVIEW PROJECT
    private By titleProject = By.xpath("//button[@data-id='project_top']");
    private By overviewProjectNumber = By.xpath("//div[contains(@class,'project-overview-id')]/dd");
    private By tabOverview = By.xpath("//a[normalize-space()='Overview']");
    private By overviewCustomer(String customerName) {
        String xpathCustomer = "//div[contains(@class,'project-overview-customer')]/dd[contains(.,'"+ customerName +"')]";
        return By.xpath(xpathCustomer);
    }
    private By overviewBillingType(String billingType) {
        String xpathBillingType = "//div[contains(@class,'project-overview-billing')]/dd[contains(.,'"+ billingType +"')]";
        return By.xpath(xpathBillingType);
    }
    private By overviewStatus(String status) {
        String xpathStatus = "//div[contains(@class,'project-overview-status')]/dd[contains(.,'"+ status +"')]";
        return By.xpath(xpathStatus);
    }
    private By overviewStartDate(String startDate) {
        String xpathStartDate = "//div[contains(@class,'project-overview-start-date')]/dd[contains(.,'"+ startDate +"')]";
        return By.xpath(xpathStartDate);
    }
    private By overviewDeadline(String deadline) {
        String xpathDeadline = "//div[contains(@class,'project-overview-deadline')]/dd[contains(.,'"+ deadline +"')]";
        return By.xpath(xpathDeadline);
    }
    private By overviewEstimatedHours(String estimatedHours) {
        String xpathEstimatedHours = "//div[contains(@class,'project-overview-estimated-hours')]/dd[contains(.,'"+ estimatedHours +"')]";
        return By.xpath(xpathEstimatedHours);
    }
    private By overviewTags(String tags) {
        //Loại bỏ xuống dòng và các khoảng trắng thừa ở giữa/đầu/cuối
        // \\s+ đại diện cho khoảng trắng, xuống dòng, tab...
        String cleanTags = tags.replaceAll("\\s+", " ").trim();
        String xpathTags = "//div[contains(@class,'project-overview-tags')]//dd//input[contains(@value,'"+ cleanTags +"')]";
        return By.xpath(xpathTags);
    }
    private By overviewInputTags = By.xpath("//div[contains(@class,'project-overview-tags')]//dd//input[contains(@value,'']");
    private By overviewDescription(String description) {
        String xpathDescription = "//div[contains(@class,'project-overview-description ')]//p[contains(.,'"+ description +"')]";
        return By.xpath(xpathDescription);
    }


    //========================HÀM CHUNG===============================
    public void verifyNavigateToProjectPage(){
        Assert.assertTrue(WebUI.checkElementExist(headerProjectPage),"The Project header page not dissplay.");
        Assert.assertEquals(WebUI.getElementText(headerProjectPage),"Projects Summary", "The Project header page not match");
    }

    public void clickButtonAddNewProject(){
        WebUI.clickElement(buttonAddNewProject);
    }
    
    public void submitDataForNewProject(int row) {
        ExcelHelper excelHelper = new ExcelHelper();
        excelHelper.setExcelFile("src/test/resources/dataTest/dataProjectCuoiKhoa.xlsx","Project");
        WebUI.waitForPageLoaded();

        WebUI.setText(inputProjectName, excelHelper.getCellData("Project_Name",row));
        WebUI.clickElement(dropdownCustomer);
        WebUI.setText(inputSearchCustomerProject, excelHelper.getCellData("Customer",row));
        WebUI.sleep(1);
        WebUI.clickElement(itemCustomer(excelHelper.getCellData("Customer",row)));
        WebUI.clickElement(dropdowmBillingType);
        WebUI.clickElement(itemBillingType(excelHelper.getCellData("Billing_Type",row)));
        WebUI.clickElement(dropdownStatus);
        WebUI.clickElement(itemStatus(excelHelper.getCellData("Status",row)));
        WebUI.sleep(1);
        JavascriptExecutor js = (JavascriptExecutor) DriverManager.getDriver();
        WebElement element = DriverManager.getDriver().findElement(inputEstimatedHours);
        js.executeScript("arguments[0].scrollIntoView(true);", element);
        WebUI.setText(inputEstimatedHours, excelHelper.getCellData("Estimated_Hours",row));
        WebUI.clickElement(dropdownMember);
        WebUI.clickElement(buttonDeselectAll);
        WebUI.clickElement(buttonSelectAll);
        WebUI.clickElement(dropdownMember);
        WebUI.clickElement(inputStartDate);
        WebUI.sleep(1);
        WebUI.clearText(inputStartDate);
        WebUI.setText(inputStartDate,excelHelper.getCellData("Start_Date",row));
        WebUI.sleep(1);
        WebUI.clickElement(inputDeadline);
        WebUI.clearText(inputDeadline);
        WebUI.setText(inputDeadline,excelHelper.getCellData("Deadline",row));
        WebUI.setText(inputTags, excelHelper.getCellData("Tags",row));
        WebUI.sleep(3);
        WebUI.setTextOnFrameDescription(inputDescription, excelHelper.getCellData("Description",row));
        WebUI.sleep(1);
        WebUI.clickElement(buttonSaveProject);
    }

    public void searchProject(int row) {
        ExcelHelper excelHelper = new ExcelHelper();
        excelHelper.setExcelFile("src/test/resources/dataTest/dataProjectCuoiKhoa.xlsx", "Project");
        WebUI.waitForPageLoaded();

        //Search và check item đầu tiên có đúng project mình muốn edit kh
        WebUI.setText(inputSearchProject, excelHelper.getCellData("Project_Number", row));
        WebUI.clickElement(buttonSearch);
        WebUI.waitForElementVisible(itemProjectNumberCheck);
        String numberOnTable = WebUI.getElementText(itemProjectNumberCheck);
        String numberFromExcel = excelHelper.getCellData("Project_Number", row);
        WebUI.assertEquals(numberOnTable, numberFromExcel, "The project not match");

        WebUI.waitForElementVisible(itemProjectNameCheck(excelHelper.getCellData("Project_Number", row)));
        WebUI.hoverElement(itemProjectNumberCheck(excelHelper.getCellData("Project_Number", row)));
        WebUI.clickElement(buttonEdit(excelHelper.getCellData("Project_Number", row)));
    }

    public void editProject(int row){
        ExcelHelper excelHelper = new ExcelHelper();
        excelHelper.setExcelFile("src/test/resources/dataTest/dataProjectCuoiKhoa.xlsx", "Project");
        WebUI.waitForPageLoaded();

        WebUI.setText(inputProjectName, excelHelper.getCellData("Project_Name",row));
        WebUI.clickElement(dropdownCustomer);
        WebUI.setText(inputSearchCustomerProject, excelHelper.getCellData("Customer",row));
        WebUI.sleep(1);
        WebUI.clickElement(itemCustomer(excelHelper.getCellData("Customer",row)));
        WebUI.clickElement(dropdownStatus);
        WebUI.clickElement(itemStatus(excelHelper.getCellData("Status",row)));
        WebUI.sleep(1);
        JavascriptExecutor js = (JavascriptExecutor) DriverManager.getDriver();
        WebElement element = DriverManager.getDriver().findElement(inputEstimatedHours);
        js.executeScript("arguments[0].scrollIntoView(true);", element);
        WebUI.clearText(inputEstimatedHours);
        WebUI.setText(inputEstimatedHours, excelHelper.getCellData("Estimated_Hours",row));
//        WebUI.clickElement(dropdownMember);
//        WebUI.clickElement(buttonDeselectAll);
//        WebUI.clickElement(buttonSelectAll);
//        WebUI.clickElement(dropdownMember);
//        WebUI.clickElement(inputStartDate);
//        WebUI.sleep(1);
//        WebUI.clearText(inputStartDate);
//        WebUI.setText(inputStartDate,excelHelper.getCellData("Start_Date",row));
//        WebUI.sleep(1);
//        WebUI.clickElement(inputDeadline);
//        WebUI.clearText(inputDeadline);
//        WebUI.setText(inputDeadline,excelHelper.getCellData("Deadline",row));
        WebUI.clickElement(iconCloseTag);
        WebUI.setText(inputTags, excelHelper.getCellData("Tags",row));
        WebUI.sleep(2);
        WebUI.setTextOnFrameDescription(inputDescription, excelHelper.getCellData("Description",row));
        WebUI.sleep(1);
        WebUI.clickElement(buttonSaveProject);
    }


    public void verifyProjectProfile(int row){
        ExcelHelper excelHelper = new ExcelHelper();
        excelHelper.setExcelFile("src/test/resources/dataTest/dataProjectCuoiKhoa.xlsx","Project");

        WebUI.waitForPageLoaded();
        String projectNumber = WebUI.getElementText(overviewProjectNumber);
        LogUtils.info(projectNumber);
        excelHelper.setCellData(projectNumber,"Project_Number",row);
        LogUtils.info(WebUI.getWebElement(titleProject));
        WebUI.assertEquals(DriverManager.getDriver().findElement(overviewCustomer(excelHelper.getCellData("Customer",row))).getText(),excelHelper.getCellData("Customer",row),"The Customer not match");

    }




}
