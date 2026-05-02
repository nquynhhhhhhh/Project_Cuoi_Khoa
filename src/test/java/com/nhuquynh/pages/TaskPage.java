package com.nhuquynh.pages;

import com.nhuquynh.common.BasePage;
import com.nhuquynh.keywords.WebUI;
import org.openqa.selenium.By;

public class TaskPage extends BasePage {
    //PROJECT PAGE (ADD TASK)
    private By buttonAddTaskOnProjectPage = By.xpath("//a[normalize-space()='New Task']");
    private By overviewProjectNumber = By.xpath("//div[contains(@class,'project-overview-id')]/dd");

    //TASK PAGE
    private By headerTaskPage = By.xpath("//span[normalize-space()='Tasks Summary']");
    private By buttonAddNewTask = By.xpath("//a[normalize-space()='New Task']");
    private By inputSearchTask = By.xpath("//div[@id='tasks_filter']//input");
    private By itemTaskNumberFirst = By.xpath("//tbody/tr[1]/td[1]/a");
    private By itemTaskNumberCheck(String taskNumber) {
        By xpathTaskNumber = By.xpath("//tbody//tr//a[normalize-space()='" + taskNumber + "']");
        return xpathTaskNumber;
    }
    private By buttonEdit(String taskName) {
        By xpathButtonEdit = By.xpath("//a[text()='" + taskName + "']/ancestor::tr//a[contains(text(),'Edit')]");
        return xpathButtonEdit;
    }
    private By buttonDelete(String taskName) {
        By xpathButtonDelete = By.xpath("//a[text()='" + taskName + "']/ancestor::tr//a[contains(text(),'Delete')]");
        return xpathButtonDelete;
    }
    //ADD TASK
    private By inputPublic = By.xpath("//input[@id='task_is_public'");
    private By checkboxVisibleToCustomer = By.xpath("//label[normalize-space()='Visible to customer']");
    private By attachFiles = By.xpath("//a[normalize-space()='Attach Files']");
    private By inputFiles = By.xpath("//input[@name='attachments");
    private By inputSubject = By.xpath("//div[@role='document']//input[@id='name']");
    private By inputHourlyRate = By.xpath("//input[@id='hourly_rate']");
    private By inputStartDate = By.xpath("//input[@id='startdate']");
    private By inputDueDate = By.xpath("//input[@id='duedate']");
    private By dropdownPriority = By.xpath("//button[@data-id='priority']");
    private By itemPriority(String itemPriority) {
        By xpathPriority = By.xpath("//button[@data-id='priority']//following-sibling::div//li//span[normalize-space()='" + itemPriority + "']");
        return xpathPriority;
    }
    private By dropdownRepeatEvery = By.xpath("//button[@data-id='repeat_every']");
    private By itemRepeatEvery(String itemTimes) {
        By xpathRepeat = By.xpath("//button[@data-id='repeat_every']//following-sibling::div//li//span[normalize-space()='" + itemTimes + "']");
        return xpathRepeat;
    }
    private By dropdownRelatedTo = By.xpath("//button[@data-id='rel_type']");
    private By itemRelatesTo(String itemRelatedTo) {
        By xpathRelatedTo = By.xpath("//button[@data-id='rel_type']/following-sibling::div//li//span[normalize-space()='"+ itemRelatedTo +"']");
        return xpathRelatedTo;
    }
    private By dropdownProject = By.xpath("//button[@data-id='rel_id']");
    private By inputSearchProject = By.xpath("//button[@data-id='rel_id']/following-sibling::div//input");
    private By dropdownAssignees = By.xpath("//button[@data-id='assignees']");
    private By itemAssignees(String itemAssignees){
        By xpathAssignees = By.xpath("//button[@data-id='assignees']/following-sibling::div//li//span[normalize-space()='"+ itemAssignees +"']");
        return xpathAssignees;
    }
    private By dropdowmFollower = By.xpath("//button[@data-id='followers[]']");
    private By itemFollower(String itemFollower){
        By xpathFollower = By.xpath("//button[@data-id='followers[]']/following-sibling::div//li//span[normalize-space()='"+ itemFollower +"']");
        return xpathFollower;
    }
    private By inputTags = By.xpath("//input[@placeholder='Tag']");
    private By textareaTaskDescription = By.xpath("//div[@class='form-group no-mbot']//textarea[@id='description']");
    private By buttonSave = By.xpath("//div[@role='document']//button[normalize-space()='Save']");


//===========================HÀM XỬ LÝ==================================
    public void clickAddTask() {
        WebUI.clickElement(buttonAddNewTask);
    }

    //Add Task từ trang Project


}




