package com.epam.ta.test;

import com.epam.ta.page.InventoryPage;
import com.epam.ta.page.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

  @Test
  public void testSuccessfulLogin() {
    LoginPage loginPage = new LoginPage(driver);
    loginPage.openPage()
        .login("standard_user", "secret_sauce");

    InventoryPage inventoryPage = new InventoryPage(driver);
    Assert.assertEquals(inventoryPage.getPageTitle(), "Products", "User should be redirected to Inventory Page!");
  }
}