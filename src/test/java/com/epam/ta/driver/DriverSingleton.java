package com.epam.ta.driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverSingleton {
  private static WebDriver driver;

  private DriverSingleton() {}

  public static WebDriver getDriver() {
    if (driver == null) {
      WebDriver rawDriver;
      String browser = System.getProperty("browser", "chrome");
      switch (browser.toLowerCase()) {
        case "firefox":
          WebDriverManager.firefoxdriver().setup();
          rawDriver = new FirefoxDriver();
          break;
        case "chrome":
        default:
          WebDriverManager.chromedriver().setup();
          rawDriver = new ChromeDriver();
          break;
      }
      rawDriver.manage().window().maximize();
      driver = new CustomDriverDecorator(rawDriver);
    }
    return driver;
  }

  public static void closeDriver() {
    if (driver != null) {
      driver.quit();
      driver = null;
    }
  }
}