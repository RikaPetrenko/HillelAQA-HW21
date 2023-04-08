package com.example.hillelaqahw21.prometheusPages.pages;

import com.example.hillelaqahw21.prometheusPages.driversetup.Waiters;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RegistrationPage extends AbstractPrometheus {

    private static final By FULL_NAME_FIELD = By.xpath("//*[@id='register-name']");
    private static final By USERNAME_FIELD = By.xpath("//*[@id='register-username']");
    private static final By EMAIL_FIELD = By.xpath("//*[@id='register-email']");
    private static final By PHONE_NUMBER_FIELD = By.xpath("//*[@id='register-phone_number']"); //
    private static final By PASSWORD_FIELD = By.xpath("//*[@id='register-password']");
    private static final By CREATE_ACCOUNT_BUTTON = By.xpath("//button[@type='submit']");




    public RegistrationPage(WebDriver driver) {

        super(driver);
    }



    public WebElement getFullName() {

        return Waiters.waitUntilElementIsClickableFluent(driver, FULL_NAME_FIELD);
    }

    public void setFullName(String fullName) {

        getFullName().sendKeys(fullName);
    }




    public WebElement getUserName() {

        return Waiters.waitUntilElementIsClickableFluent(driver, USERNAME_FIELD);
    }

    public void setUserName(String username) {

        getUserName().sendKeys(username);
    }




    public WebElement getEmail() {

        return Waiters.waitUntilElementIsClickableFluent(driver, EMAIL_FIELD);
    }

    public void setEmail(String email) {
        WebElement emailField = getEmail();
        emailField.clear();
        emailField.sendKeys(email);
    }






    public void setPhoneNumber(String phoneNumber) {
        WebElement phoneField = getPhoneNumber();
        phoneField.clear();
        phoneField.sendKeys(phoneNumber);
    }

    public WebElement getPhoneNumber() {

        return Waiters.waitUntilElementIsClickableFluent(driver, PHONE_NUMBER_FIELD);
    }







    public WebElement getPasswordField() {

        return Waiters.waitUntilElementIsClickableFluent(driver, PASSWORD_FIELD);
    }

    public void setPasswordField(String password) {

        getPasswordField().sendKeys(password);
    }

    public String getPasswordErrorText() {
        try {
            WebElement errorElement = driver.findElement(By.xpath("//div[contains(@class, 'error')]"));
            return errorElement.getText();
        } catch (NoSuchElementException ex) {
            return "";
        }
    }




    public WebElement getCreateAccount() {
        return Waiters.waitUntilElementIsClickableFluent(driver, CREATE_ACCOUNT_BUTTON);
    }

    public void clickCreateAccount() {
        getCreateAccount().click();
    }





//    public void register(String fullName, String username, String email, String phoneNumber, String password) {
//
//        driver.findElement(FULL_NAME_FIELD).sendKeys(fullName);
//        driver.findElement(USERNAME_FIELD).sendKeys(username);
//        driver.findElement(EMAIL_FIELD).sendKeys(email);
//        driver.findElement(PHONE_NUMBER_FIELD).sendKeys(phoneNumber);
//        driver.findElement(PASSWORD_FIELD).sendKeys(password);
//        driver.findElement(CREATE_ACCOUNT_BUTTON).click();
//
//
//    }

}

