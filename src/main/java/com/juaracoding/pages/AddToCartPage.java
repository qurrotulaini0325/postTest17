package com.juaracoding.pages;

import com.juaracoding.drivers.DriverSingleton;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class AddToCartPage {
    private WebDriver driver;
    JavascriptExecutor js;


    public AddToCartPage(){
        this.driver = DriverSingleton.getDriver();
        PageFactory.initElements(driver, this);
        this.js = (JavascriptExecutor) driver;
    }

    @FindBy(linkText = "Orders")
    WebElement clickOrder;

    @FindBy(linkText = "Browse products")
    WebElement clickBrowse;

    @FindBy(linkText = "BLACK CROSS BACK MAXI DRESS")
    WebElement product;

    @FindBy(id = "pa_color")
    WebElement color;

    @FindBy(id= "pa_size")
    WebElement size;

    @FindBy(xpath = "//button[normalize-space()='Add to cart']")
    WebElement btnAdd;

    @FindBy(className = "woocommerce-message")
    WebElement txtCart;

    public void cart(){
        clickOrder.click();
        clickBrowse.click();
        product.click();
        js.executeScript("window.scrollBy(0,500)");
        Select selectColor = new Select(color);
        selectColor.selectByValue("black");
        Select selectSize = new Select(size);
        selectSize.selectByValue("medium");
        btnAdd.click();

    }

    public String cartTxt(){
        return txtCart.getText();
    }

}
