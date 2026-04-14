package com.nhuquynh.pages;

import com.nhuquynh.keywords.WebUI;
import org.openqa.selenium.By;
import org.testng.Assert;

public class DashboardPage extends BasePage {

    private By totalInvoicesAwaitingPayment = By.xpath("(//span[normalize-space()='Invoices Awaiting Payment']/parent::div)/following-sibling::span");
    private By totalConvertedLeads = By.xpath("(//span[normalize-space()='Converted Leads']/parent::div)/following-sibling::span");
    private By totalProjectInProgress = By.xpath("(//span[normalize-space()='Projects In Progress']/parent::div)/following-sibling::span");
    private By totalTasksNotFinished = By.xpath("(//span[normalize-space()='Tasks Not Finished']/parent::div)/following-sibling::span");


    public void verifyInvoicesAwaitingPayment(String total){
        //lúc nào cũng phải check tồn tại trc
        Assert.assertTrue(WebUI.isElementDisplayed(totalInvoicesAwaitingPayment),"The Invoices Awaiting Payment total label not match");
        Assert.assertEquals(WebUI.getElementText(totalInvoicesAwaitingPayment), total, "The Invoices Awaiting Payment total not match");
    }

    public void verifyProjectInProgress(String total){
        //lúc nào cũng phải check tồn tại trc
        Assert.assertTrue(WebUI.isElementDisplayed(totalTasksNotFinished),"The Invoices Awaiting Payment total label not match");
        Assert.assertEquals(WebUI.getElementText(totalTasksNotFinished), total, "The Invoices Awaiting Payment total not match");
    }




}
