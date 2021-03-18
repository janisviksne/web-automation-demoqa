package com.testing.pageObjects.pages;

import org.openqa.selenium.By;

import net.thucydides.core.annotations.DefaultUrl;

@DefaultUrl("/tabs")
public class TabsPage extends WidgetsPage {
  // Locators ----------------------------------------------------------------------------------------------------------
  public static By TABS_TITLE;
  public static By CONTENT;
  public static By WHAT_TAB;
  public static By ORIGIN_TAB;
  public static By USE_TAB;
  public static By MORE_TAB;
  // Public methods ----------------------------------------------------------------------------------------------------
  public void waitForPageToLoad() {
    getElement(TABS_TITLE).waitUntilPresent();
    logWeAreOnPage();
  }
}
