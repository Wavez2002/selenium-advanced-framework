package com.epam.ta.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class InventoryPage extends AbstractPage {
  private static final String PAGE_URL = "https://www.saucedemo.com/inventory.html";

  @FindBy(className = "title")
  private WebElement pageTitle;

  @FindBy(id = "add-to-cart-sauce-labs-backpack")
  private WebElement addToCartButton;

  @FindBy(className = "shopping_cart_badge")
  private WebElement cartBadge;

  public InventoryPage(WebDriver driver) {
    super(driver);
  }

  @Override
  public InventoryPage openPage() {
    driver.get(PAGE_URL);
    return this;
  }

  public String getPageTitle() {
    wait.until(ExpectedConditions.visibilityOf(pageTitle));
    return pageTitle.getText();
  }

  public InventoryPage addBackpackToCart() {
    wait.until(ExpectedConditions.elementToBeClickable(addToCartButton)).click();
    return this;
  }

  public String getCartBadgeText() {
    wait.until(ExpectedConditions.visibilityOf(cartBadge));
    return cartBadge.getText();
  }
}