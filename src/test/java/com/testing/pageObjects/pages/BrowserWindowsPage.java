package com.testing.pageObjects.pages;

import org.openqa.selenium.By;

import net.thucydides.core.annotations.DefaultUrl;

@DefaultUrl("/browser-windows")
public class BrowserWindowsPage extends AlertsFrameAndWindowsPage {
  // Locators ----------------------------------------------------------------------------------------------------------
  public static By BROWSER_WINDOWS_TITLE;
  public static By NEW_TAB_BUTTON;
  public static By NEW_WINDOW_BUTTON;
  // When a new tab or window is opened, it contains a heading.
  public static By HEADING;
  // Public methods ----------------------------------------------------------------------------------------------------
  public void waitForPageToLoad() {
    getElement(BROWSER_WINDOWS_TITLE).waitUntilPresent();
    logWeAreOnPage();
  }
}