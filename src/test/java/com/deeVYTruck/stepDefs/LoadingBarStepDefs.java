package com.deeVYTruck.stepDefs;

import com.deeVYTruck.Utilis.Driver;
import com.deeVYTruck.pages.BasePage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebElement;

public class LoadingBarStepDefs {

    BasePage basePage = new BasePage();
    @Given("url")
    public void url() {
        Driver.getDriver().get("https://qa2.vytrack.com/user/login");
    }
    @When("User puts in userName")
    public void user_puts_in_user_name() {
        basePage.userName.sendKeys("user160");
    }
    @When("User puts in Password")
    public void user_puts_in_password() throws InterruptedException {
        basePage.passWord.sendKeys("UserUser123");
        Thread.sleep(4000);
    }
    @When("User clicks on login Button")
    public void user_clicks_on_login_button() throws InterruptedException {
        basePage.logInBtn.click();
        Thread.sleep(4000);
    }
    @Then("User waits for loading bar")
    public void user_waits_for_loading_bar() throws InterruptedException {
        Thread.sleep(4000);
        String loadingBarText = basePage.loadingBar.getText();
        System.out.println("loadingBar = " + loadingBarText);

      //  WebElement loadingBar = basePage.loadingBar;
        Thread.sleep(4000);
        // Assert.assertTrue(loadingBarText.contains("Loading..."));
        Assert.assertEquals("Loading...", loadingBarText );
      //  Assert.assertTrue(loadingBar.isDisplayed());
    }
    @Then("User on home page with Dashboard WebTitle")
    public void user_on_home_page_with_dashboard_web_title() {
        String title = Driver.getDriver().getTitle();
        Assert.assertEquals("Dashboard", title);
    }


}
