package com.testing.pageObjects.pages;

import org.openqa.selenium.By;

import net.thucydides.core.annotations.DefaultUrl;

@DefaultUrl("/menu")
public class MenuPage extends WidgetsPage {
  // Locators ----------------------------------------------------------------------------------------------------------
  public static By MENU_TITLE = text("Menu");
  public static By MAIN_ITEM_1 = text("Main Item 1");
  public static By MAIN_ITEM_2= text("Main Item 2");
  public static By MAIN_ITEM_3= text("Main Item 3");
  // Might be necessary to use a xpath selector
  public static By SUB_SUB_LIST= xpath("//a[contains(., 'SUB SUB LIST')]");
  public static By SUB_SUB_ITEM_1 = xpath("//a[contains(., 'Sub Sub Item 1')]");
  public static By SUB_SUB_ITEM_2= xpath("//a[contains(., 'Sub Sub Item 2')]");
  // Public methods ----------------------------------------------------------------------------------------------------
  public void waitForPageToLoad() {
    getElement(MENU_TITLE).waitUntilPresent();
    logWeAreOnPage();
  }
}
