package com.juaracoding;

import com.juaracoding.drivers.DriverSingleton;
import com.juaracoding.pages.AddToCartPage;
import com.juaracoding.pages.LoginPage;
import org.openqa.selenium.WebDriver;

public class MainApp {

    static WebDriver driver;

    public static void main(String[] args) {
        DriverSingleton.getInstance("chrome");
        driver = DriverSingleton.getDriver();
        driver.get("https://shop.demoqa.com");

        LoginPage loginPage = new LoginPage();
        loginPage.login();
        System.out.println("Test Login");
        DriverSingleton.contains(loginPage.loginTxt(), "Hello");

        AddToCartPage addToCartPage = new AddToCartPage();
        addToCartPage.cart();
        DriverSingleton.contains(addToCartPage.cartTxt(),"has been added to your cart");

        driver.quit();
        System.out.println("Quit browser");
    }
}