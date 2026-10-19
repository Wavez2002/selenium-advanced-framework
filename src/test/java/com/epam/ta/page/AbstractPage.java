package com.epam.ta.page;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public abstract class AbstractPage {
  protected WebDriver driver;
  protected WebDriverWait wait;
  protected final int WAIT_TIMEOUT_SECONDS = 10;

  protected AbstractPage(WebDriver driver) {
    this.driver = driver;
    this.wait = new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIMEOUT_SECONDS));
    PageFactory.initElements(driver, this);
  }

  protected abstract AbstractPage openPage();

  protected void highlightElement(WebElement element) {
    try {
      JavascriptExecutor js = (JavascriptExecutor) driver;
      js.executeScript("arguments[0].style.border='3px solid red'", element);
    } catch (Exception e) {
      // Ignore if element is not interactable via JS
    }
  }
}