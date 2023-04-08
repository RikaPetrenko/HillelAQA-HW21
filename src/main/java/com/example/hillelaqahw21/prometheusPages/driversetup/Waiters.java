package com.example.hillelaqahw21.prometheusPages.driversetup;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Waiters {
    private static final int TIME_OUT = 10;

    private Waiters() {
    }

    public static WebElement waitUntilElementIsVisible(WebDriver driver, By selector) {
        return new WebDriverWait(driver, Duration.ofSeconds(TIME_OUT))
                .until(ExpectedConditions.visibilityOf(driver.findElement(selector)));
    }

    public static WebElement waitUntilElementIsClickable(WebDriver driver, By selector) {
        return new WebDriverWait(driver, Duration.ofSeconds(TIME_OUT))
                .until(ExpectedConditions.elementToBeClickable(driver.findElement(selector)));
    }

    public static WebElement waitUntilElementIsClickableFluent(WebDriver driver, By selector) {
        return new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(TIME_OUT))
                .pollingEvery(Duration.ofMillis(500))
                .ignoring(NoSuchElementException.class)
                .until(ExpectedConditions.elementToBeClickable(selector));
    }
}