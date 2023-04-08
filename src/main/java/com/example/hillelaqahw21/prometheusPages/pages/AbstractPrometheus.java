package com.example.hillelaqahw21.prometheusPages.pages;

import org.openqa.selenium.WebDriver;

public abstract class AbstractPrometheus {

    protected WebDriver driver;

    public AbstractPrometheus(WebDriver driver) {

        this.driver = driver;
    }
}