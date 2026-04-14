package com.nhuquynh.pages;

import com.nhuquynh.keywords.WebUI;
import org.openqa.selenium.By;

public class BasePage {

    private By menuDashboard = By.xpath("//span[normalize-space()='Dashboard']");
    private By menuCustomers = By.xpath("//span[normalize-space()='Customers']");
    private By menuTasks = By.xpath("//span[normalize-space()='Tasks']");
    private By menuProjects = By.xpath("//span[normalize-space()='Projects']");
    private By iconProfile = By.xpath("//li[@class='icon header-user-profile']");

    public CustomerPage clickMenuCustomer(){
        WebUI.waitForElementVisible(menuCustomers);
        WebUI.clickElement(menuCustomers);
        return new CustomerPage();
    }

    public ProjectPage clickMenuProject(){
        WebUI.waitForElementVisible(menuProjects);
        WebUI.clickElement(menuProjects);
        return new ProjectPage();
    }

    public TaskPage clickMenuTask(){
        WebUI.waitForElementVisible(menuTasks);
        WebUI.clickElement(menuTasks);
        return new TaskPage();
    }
}
