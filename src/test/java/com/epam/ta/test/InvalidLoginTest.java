package com.epam.ta.test;

import com.epam.ta.page.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class InvalidLoginTest extends BaseTest {

  @Test
  public void testLockedOutUserLogin() {
    LoginPage loginPage = new LoginPage(driver);
    loginPage.openPage()
        .login("locked_out_user", "secret_sauce");

    String actualErrorMessage = loginPage.getErrorMessage();
    Assert.assertTrue(actualErrorMessage.contains("Epic sadface: Sorry, this user has been locked out."),
        "Error message should alert that user is locked out!");
  }
}