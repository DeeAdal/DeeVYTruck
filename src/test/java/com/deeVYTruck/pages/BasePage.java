package com.deeVYTruck.pages;

import com.deeVYTruck.Utilis.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BasePage {
        public BasePage(){
    PageFactory.initElements(Driver.getDriver(),this);
}

@FindBy(xpath = "//input[@id='prependedInput']")
public WebElement userName;

@FindBy(xpath = "//input[@id='prependedInput2']")
public WebElement passWord;

@FindBy (id="_submit")
public WebElement logInBtn;

@FindBy (xpath = "//div[@id='progressbar']//h3")
    public WebElement loadingBar;


    @FindBy(xpath = "//ul[contains(@class,'nav-multilevel')]/li")
    public WebElement mainModules;

}
