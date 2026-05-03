package com.nhuquynh.pages;

import com.nhuquynh.common.BasePage;
import com.nhuquynh.keywords.WebUI;
import org.openqa.selenium.By;
import org.testng.Assert;

public class DashboardPage extends BasePage {
    private By titleInvoicesAwaitingPayment = By.xpath("//span[normalize-space()='Invoices Awaiting Payment']");
    private By totalInvoicesAwaitingPayment = By.xpath("(//span[normalize-space()='Invoices Awaiting Payment']/parent::div)/following-sibling::span");

    private By titleConvertedLeads = By.xpath("//span[normalize-space()='Converted Leads']");
    private By totalConvertedLeads = By.xpath("(//span[normalize-space()='Converted Leads']/parent::div)/following-sibling::span");

    public void verifyInvoicesAwaitingPayment(String total) {
        Assert.assertEquals(WebUI.getElementText(titleInvoicesAwaitingPayment), "The Invoices Awaiting Payment", "The Invoices Awaiting Payment title not match");
        Assert.assertTrue(WebUI.isElementDisplayed(totalInvoicesAwaitingPayment), "The Invoices Awaiting Payment total label not match");
        Assert.assertEquals(WebUI.getElementText(totalInvoicesAwaitingPayment), total, "The Invoices Awaiting Payment total not match");
    }

    public void verifyConvertedLeads(String total) {
        Assert.assertEquals(WebUI.getElementText(titleInvoicesAwaitingPayment), "", "The Converted Leads title not match");
        Assert.assertTrue(WebUI.isElementDisplayed(totalConvertedLeads), "The Converted Leads total label not match");
        Assert.assertEquals(WebUI.getElementText(totalConvertedLeads), total, "The Converted Leads total not match");

    }

}
