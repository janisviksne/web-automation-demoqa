package com.testing.pageObjects.pages;

import org.openqa.selenium.By;

import net.thucydides.core.annotations.DefaultUrl;

@DefaultUrl("/browser-windows")
public class BrowserWindowsPage extends AlertsFrameAndWindowsPage {
  // Locators ----------------------------------------------------------------------------------------------------------
  public static By BROWSER_WINDOWS_TITLE = text("Browser Windows");
  public static By NEW_TAB_BUTTON = css("button[id='tabButton']");
  public static By NEW_WINDOW_BUTTON = css("button[id='windowButton']");
  // When a new tab or window is opened, it contains a heading.
  public static By HEADING = id("h1[id='sampleHeading']");
  // Public methods ----------------------------------------------------------------------------------------------------
  public void waitForPageToLoad() {
    getElement(BROWSER_WINDOWS_TITLE).waitUntilPresent();
    logWeAreOnPage();
  }
}
