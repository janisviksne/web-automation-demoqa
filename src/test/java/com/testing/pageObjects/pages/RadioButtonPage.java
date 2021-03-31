package com.testing.pageObjects.pages;

import org.openqa.selenium.By;

import net.thucydides.core.annotations.DefaultUrl;

@DefaultUrl("/radio-button")
public class RadioButtonPage extends ElementsPage {
  // Locators ----------------------------------------------------------------------------------------------------------
  // Find the selectors for all the elements
  public static By RADIO_BUTTON_TITLE = text("Radio Button");
  public static By YES_BUTTON = id("yesRadio");
  public static By NO_BUTTON = id("noRadio");
  public static By IMPRESSIVE_BUTTON = id("impressiveRadio");
  //  After user selects an option, result string is shown.
  public static By SELECTED_RESULT = css("span.text-success");
  // Public methods ----------------------------------------------------------------------------------------------------
  public void waitForPageToLoad() {
    getElement(RADIO_BUTTON_TITLE).waitUntilPresent();
    logWeAreOnPage();
  }
}
