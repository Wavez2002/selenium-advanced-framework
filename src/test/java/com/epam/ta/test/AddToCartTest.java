package com.epam.ta.test;

import com.epam.ta.page.InventoryPage;
import com.epam.ta.page.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AddToCartTest extends BaseTest {

  @Test
  public void testAddBackpackToCart() {
    LoginPage loginPage = new LoginPage(driver);
    loginPage.openPage()
        .login("standard_user", "secret_sauce");

    InventoryPage inventoryPage = new InventoryPage(driver);
    inventoryPage.addBackpackToCart();

    Assert.assertEquals(inventoryPage.getCartBadgeText(), "1", "Cart badge should display '1' item!");
  }
}