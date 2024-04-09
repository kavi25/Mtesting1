package com.qa.stepdef;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ChromeStepDef {

    public AndroidDriver driver = SharedDriverContext.getDriver();
    public WebDriverWait wait = new WebDriverWait((WebDriver) driver, Duration.ofMillis(5000)); // Use Duration.ofMillis to specify the timeout duration

    // Your other code...

    @AndroidFindBy(xpath  = "//android.widget.EditText[@resource-id=\"com.android.chrome:id/search_box_text\"]")
    public WebElement googlesearch;

    @AndroidFindBy(xpath = "//android.view.View[@content-desc=\"ItProBit www.itprobit.com\"]")
    public WebElement Itprobitlink;

    @AndroidFindBy(className = "android.widget.EditText")
    public WebElement searchbox;

    @AndroidFindBy(xpath = "//android.view.View[@content-desc=\"More filters\"]")
    public WebElement restaurantFilterBtn;

    @AndroidFindBy(xpath = "//android.widget.CompoundButton[@content-desc=\"Open now\"]")
    public WebElement restaurantOpenNow;

    @AndroidFindBy(xpath = "//android.support.v7.widget.RecyclerView[@resource-id=\"com.google.android.apps.maps:id/search_list_layout\"]/android.widget.RelativeLayout[1]")
    public WebElement openNowRestaurant;
    @AndroidFindBy(xpath = "//android.view.View[@content-desc=\"Apply\"]")
    public WebElement applyFilter;

    @AndroidFindBy(accessibility = "Clear")
    public WebElement clearFilter;

    @AndroidFindBy(id = "com.google.android.apps.maps:id/search_omnibox_text_box")
    public WebElement searchBox;

    @AndroidFindBy(id = "com.google.android.apps.maps:id/search_omnibox_edit_text")
    public WebElement searchBoxEdit;

    @AndroidFindBy(accessibility = "Marina Beach")
    public WebElement marinaBeach;

    @AndroidFindBy(accessibility = "List view")
    public WebElement listView;

    @AndroidFindBy(xpath = "//android.widget.Button[@content-desc=\"Directions to Marina Beach\"]")
    public WebElement directionsToBeach;

    @AndroidFindBy(xpath = "//android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.TextView[2]")
    public WebElement distanceToBeach;

    @AndroidFindBy(xpath = "//android.support.v7.widget.RecyclerView[@resource-id=\"com.google.android.apps.maps:id/search_list_layout\"]/android.widget.RelativeLayout[1]/android.widget.LinearLayout[1]")
    public WebElement openedRestaurant;
    @AndroidFindBy(xpath = "//android.widget.FrameLayout[@resource-id=\"com.google.android.apps.maps:id/start_section\"]")
    public WebElement backtorestaurantopen;
    @AndroidFindBy(accessibility = "Dine-in")
    public WebElement dineIn;

    public ChromeStepDef() {
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }


    @Given("Open Google Chrome")
    public void openGoogleChrome(){
    wait.until(ExpectedConditions.visibilityOf(googlesearch));

}


    @Then("Search for Itprobit")
    public void searchForItprobit() {
        wait.until(ExpectedConditions.visibilityOf(googlesearch));
        googlesearch.click();
        searchbox.sendKeys("Itprobit");
        driver.pressKey(new KeyEvent(AndroidKey.ENTER));
        wait.until(ExpectedConditions.visibilityOf(Itprobitlink));
    }

    @Then("Click on Itprobit")
    public void clickOnItprobit() throws InterruptedException {
        Thread.sleep(10000);
        wait.until(ExpectedConditions.visibilityOf(Itprobitlink));
        Itprobitlink.click();
        Thread.sleep(90000);
    }
}

