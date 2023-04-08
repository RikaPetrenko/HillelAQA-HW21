package com.example.hillelaqahw21.prometheusPages;

import com.example.hillelaqahw21.prometheusPages.driversetup.WebDriverFactory;
import com.example.hillelaqahw21.prometheusPages.pages.RegistrationPage;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;


public class RegistrationTest {

    private static WebDriver driver;

    private static RegistrationPage registrationPage;

    @BeforeAll
    public static void init(){
        driver = WebDriverFactory.getDriver("chrome");
        registrationPage = new RegistrationPage(driver);

    }


    @Test
    public void testEmptyPassword() {
        String fullName = "Vale Koval";
        String userName = "alohahha";
        String email = "work.valk+3783@gmail.com";
        String phoneNumber = "0688895519";

        driver.get("https://courses.prometheus.org.ua/register");

        registrationPage.setFullName(fullName);
        registrationPage.setUserName(userName);
        registrationPage.setEmail(email);
        registrationPage.setPhoneNumber(phoneNumber);
        registrationPage.clickCreateAccount();

        String expectedErrorMessage = "Please fill in this field.";
        String actualErrorMessage = registrationPage.getPasswordField().getAttribute("validationMessage");
        Assertions.assertEquals(expectedErrorMessage, actualErrorMessage);
    }


    @Test
    public void testEmptyFullName() {
        String userName = "alohahha";
        String email = "work.valk+3783@gmail.com";
        String phoneNumber = "0688895519";
        String expectedErrorMessage = "Please fill in this field.";

        driver.get("https://courses.prometheus.org.ua/register");

        registrationPage.setUserName(userName);
        registrationPage.setEmail(email);
        registrationPage.setPhoneNumber(phoneNumber);
        registrationPage.clickCreateAccount();

        String actualErrorMessage = registrationPage.getFullName().getAttribute("validationMessage");
        Assertions.assertEquals(expectedErrorMessage, actualErrorMessage);
    }


    @Test
    public void testEmptyUserName() {
        String fullName = "Vale Koval";
        String email = "work.valk+3783@gmail.com";
        String phoneNumber = "0688895519";
        String expectedErrorMessage = "Please fill in this field.";

        driver.get("https://courses.prometheus.org.ua/register");

        registrationPage.setFullName(fullName);
        registrationPage.setEmail(email);
        registrationPage.setPhoneNumber(phoneNumber);
        registrationPage.clickCreateAccount();

        String actualErrorMessage = registrationPage.getUserName().getAttribute("validationMessage");
        Assertions.assertEquals(expectedErrorMessage, actualErrorMessage);
    }

    @Test
    public void testInvalidEmail() {
        String fullName = "Vale Koval";
        String userName = "alohahha";
        String email = "example.com";
        String phoneNumber = "0688895519";
        String expectedErrorMessage = "Please include an '@' in the email address. 'example.com' is missing an '@'.";

        driver.get("https://courses.prometheus.org.ua/register");

        registrationPage.setFullName(fullName);
        registrationPage.setUserName(userName);
        registrationPage.setEmail(email);
        registrationPage.setPhoneNumber(phoneNumber);
        registrationPage.clickCreateAccount();

        String actualErrorMessage = registrationPage.getEmail().getAttribute("validationMessage");
        Assertions.assertEquals(expectedErrorMessage, actualErrorMessage);
    }

    @Test
    public void testSuccessfulRegistration() {
        String fullName = "John Doefinicano";
        String userName = "johndoe123";
        String email = "johndoe123@example.com";
        String phoneNumber = "1234567890";
        String password = "Test1234!";

        driver.get("https://courses.prometheus.org.ua/register");

        registrationPage.setFullName(fullName);
        registrationPage.setUserName(userName);
        registrationPage.setEmail(email);
        registrationPage.setPhoneNumber(phoneNumber);
        registrationPage.setPasswordField(password);
        registrationPage.clickCreateAccount();

        // Assert that the registration was successful by checking that the user is redirected to the home page
        String expectedUrl = "https://courses.prometheus.org.ua/register";
        String actualUrl = driver.getCurrentUrl();
        Assertions.assertEquals(expectedUrl, actualUrl);
    }









    @AfterAll
    public static void tearDown() {

        driver.quit();
    }


}
