package com.testing.pageObjects.pages;

import org.openqa.selenium.By;

import net.thucydides.core.annotations.DefaultUrl;

@DefaultUrl("/menu")
public class MenuPage extends WidgetsPage {
  // Locators ----------------------------------------------------------------------------------------------------------
  public static By MENU_TITLE;
  public static By MAIN_ITEM_1;
  public static By MAIN_ITEM_2;
  public static By MAIN_ITEM_3;
  // Might be necessary to use a xpath selector
  public static By SUB_SUB_LIST;
  public static By SUB_SUB_ITEM_1;
  public static By SUB_SUB_ITEM_2;
  // Public methods ----------------------------------------------------------------------------------------------------
  public void waitForPageToLoad() {
    getElement(MENU_TITLE).waitUntilPresent();
    logWeAreOnPage();
  }
}
