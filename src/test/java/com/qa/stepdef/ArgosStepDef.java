package com.qa.stepdef;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ArgosStepDef {

    private AndroidDriver driver = SharedDriverContext.getDriver();
    private WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(5000)); // Use Duration.ofMillis to specify the timeout duration
    private Scenario scenario;

    @AndroidFindBy(xpath = "//android.widget.EditText[@resource-id=\"com.android.chrome:id/search_box_text\"]")
    private WebElement googleSearch;

    @AndroidFindBy(xpath = "//android.view.View[@content-desc=\"ItProBit www.itprobit.com\"]")
    private WebElement itProBitLink;

    @AndroidFindBy(className = "android.widget.EditText")
    private WebElement searchBox;

    @AndroidFindBy(xpath = "//android.view.View[@content-desc=\"More filters\"]")
    private WebElement restaurantFilterBtn;

    @AndroidFindBy(xpath = "//android.widget.CompoundButton[@content-desc=\"Open now\"]")
    private WebElement restaurantOpenNow;

    @AndroidFindBy(xpath = "//android.support.v7.widget.RecyclerView[@resource-id=\"com.google.android.apps.maps:id/search_list_layout\"]/android.widget.RelativeLayout[1]")
    private WebElement openNowRestaurant;

    @AndroidFindBy(xpath = "//android.view.View[@content-desc=\"Apply\"]")
    private WebElement applyFilter;

    @AndroidFindBy(id = "com.homeretailgroup.argos.android:id/textinput_error")
    private WebElement errorMessage;


    @AndroidFindBy(id = "com.homeretailgroup.argos.android:id/nav_drawer_menu_item_from_header_sign_out")
    private WebElement signout;

    @AndroidFindBy(xpath = "//android.widget.Button[@text=\"Sign In\"]")
    private WebElement signinBtn;

    @AndroidFindBy(id = "com.homeretailgroup.argos.android:id/signin_password")
    private WebElement passwordField;

    @AndroidFindBy(id = "com.homeretailgroup.argos.android:id/signin_email_address")
    private WebElement usernameField;

    @AndroidFindBy(id = "com.homeretailgroup.argos.android:id/nav_drawer_menu_item_from_header_sign_in")
    private WebElement signinOption;

    @AndroidFindBy(id = "com.homeretailgroup.argos.android:id/nav_drawer_header_user_email")
    private WebElement signinOrLogin;

    @AndroidFindBy(accessibility = "Burger menu icon")
    private WebElement menuIcon;

    @AndroidFindBy(id = "com.homeretailgroup.argos.android:id/toolbar\n")
    private WebElement argosToolbar;





    public ArgosStepDef() {
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @Given("Open Argos app")
    public void openArgosApp() {
// Add code to open the Argos app
    }

    @And("Click menu")
    public void clickMenu() throws InterruptedException {
        Thread.sleep(10000);
        menuIcon.click();
    }



    @And("Click on Signin or login")
    public void clickOnSigninOrLogin() {
        signinOrLogin.click();
    }

    @And("click signin")
    public void clickSignin() {
        signinOption.click();
    }

    @And("click on signin button")
    public void clickOnSigninButton() {
        signinBtn.click();
    }

    @And("click on signout")
    public void clickOnSignout() {
        signout.click();
    }

    @And("enter the username {string}")
    public void enterTheUsername(String username) {
        wait.until(ExpectedConditions.visibilityOf(usernameField));
        usernameField.click();
        usernameField.sendKeys(username);
    }

    @And("enter the password {string}")
    public void enterThePassword(String password) {
        wait.until(ExpectedConditions.visibilityOf(passwordField));
        passwordField.click();
        passwordField.sendKeys(password);
    }

    @And("invalid username error message is displayed")
    public String invalidUsernameErrorMessageIsDisplayed() {
        String message = errorMessage.getText();
        System.out.println("Error message: " + message);
        scenario.attach(message.getBytes(), "text/plain", "Error_Message");
        return message;
    }

    @And("invalid password error message is displayed")
    public String invalidPasswordErrorMessageIsDisplayed() {
        String message = errorMessage.getText();
        System.out.println("Error message: " + message);
        scenario.attach(message.getBytes(), "text/plain", "Error_Message");
        return message;
    }
}
