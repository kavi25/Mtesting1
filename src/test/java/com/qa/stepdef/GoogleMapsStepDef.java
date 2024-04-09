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
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

import java.time.Duration;

public class GoogleMapsStepDef {

    public AndroidDriver driver = SharedDriverContext.getDriver();
    public WebDriverWait wait = new WebDriverWait((WebDriver) driver, Duration.ofMillis(5000)); // Use Duration.ofMillis to specify the timeout duration

    // Your other code...

    @AndroidFindBy(accessibility = "android.widget.EditText")
    public WebElement restaurantNearMe;

    @AndroidFindBy(id = "com.google.android.apps.maps:id/mylocation_button")
    public WebElement mylocationBtn;

    @AndroidFindBy(id = "com.google.android.apps.maps:id/search_list_layout")
    public WebElement restaurantSearchList;

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

    public GoogleMapsStepDef() {
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }



    @Then("Search for Nearby Restaurants")
    public void searchForNearbyRestaurants() {
        restaurantNearMe.click();
    }

    @Then("Open only opened restaurants nearby")
    public void openOnlyOpenedRestaurantsNearby() throws InterruptedException {

        Thread.sleep(20000);
        wait.until(ExpectedConditions.visibilityOf(openNowRestaurant));
        openNowRestaurant.click();
    }

    @And("Click back to restaurant open")
    public void confirmItIsOpen() throws InterruptedException{
        Thread.sleep(20000);
        wait.until(ExpectedConditions.visibilityOf(backtorestaurantopen));
        backtorestaurantopen.click();
    }

    @And("Get back to Map view")
    public void getBackToMapView() {
        wait.until(ExpectedConditions.visibilityOf(clearFilter));
        clearFilter.click();
        wait.until(ExpectedConditions.visibilityOf(mylocationBtn));
        mylocationBtn.click();
    }

    @Given("Search for Marina Beach")
    public void searchForMarinaBeach() {
        wait.until(ExpectedConditions.visibilityOf(searchBox));
        searchBox.click();
        searchBoxEdit.sendKeys("Marina Beach");
        driver.pressKey(new KeyEvent(AndroidKey.ENTER));
        wait.until(ExpectedConditions.visibilityOf(marinaBeach));
    }

    @And("Get Directions")
    public void getDirections() {
        wait.until(ExpectedConditions.visibilityOf(directionsToBeach));
        directionsToBeach.click();
    }

    @And("Get the Distance")
    public void getDistance() {
        wait.until(ExpectedConditions.visibilityOf(distanceToBeach));
        Assert.assertEquals("Shortest distance to Beach is available", "(4.8 km)", distanceToBeach.getText());
    }

    @And("Click on view list")
    public void clickOnViewList() {
        listView.click();

    }

    @And("Sees dine in restaurant only")
    public void seesOpenedRestaurantOnly()  throws InterruptedException{
        Thread.sleep(20000);
        wait.until(ExpectedConditions.visibilityOf(openedRestaurant));
    }

    @And("Click on dine in")
    public void clickOnDineIn() {
        dineIn.click();
    }

    @Given("Open Google Maps")
    public void OpenGoogleMaps(){
    wait.until(ExpectedConditions.visibilityOf(restaurantNearMe));

}

}
