package com.epam.ta.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends AbstractPage {
  private static final String PAGE_URL = "https://www.saucedemo.com/";

  @FindBy(id = "user-name")
  private WebElement usernameInput;

  @FindBy(id = "password")
  private WebElement passwordInput;

  @FindBy(id = "login-button")
  private WebElement loginButton;

  @FindBy(css = "h3[data-test='error']")
  private WebElement errorMessage;

  public LoginPage(WebDriver driver) {
    super(driver);
  }

  @Override
  public LoginPage openPage() {
    driver.get(PAGE_URL);
    return this;
  }

  public LoginPage login(String username, String password) {
    usernameInput.sendKeys(username);
    passwordInput.sendKeys(password);
    loginButton.click();
    return this;
  }

  public String getErrorMessage() {
    return errorMessage.getText();
  }
}