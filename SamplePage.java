package com.testing.pageObjects.pages;

import org.openqa.selenium.By;

import net.thucydides.core.annotations.DefaultUrl;

@DefaultUrl("/sample")
public class SamplePage extends BrowserWindowsPage {
  // Locators ----------------------------------------------------------------------------------------------------------
  public static By SAMPLE_TITLE = text("This is a sample page");
  // Public methods ----------------------------------------------------------------------------------------------------
  public void waitForPageToLoad() {
    getElement(SAMPLE_TITLE).waitUntilPresent();
    logWeAreOnPage();
  }
}
