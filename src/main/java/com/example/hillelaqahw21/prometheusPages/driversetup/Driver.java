package com.example.hillelaqahw21.prometheusPages.driversetup;

import org.openqa.selenium.WebDriver;

    public abstract class Driver {

        protected WebDriver driver;

        public Driver(WebDriver driver) {
            this.driver = driver;
        }
    }

