package com.testing.pageObjects.pages;

import org.openqa.selenium.By;

import net.thucydides.core.annotations.DefaultUrl;

@DefaultUrl("/forms")
public class FormsPage extends HomePage {
  // Locators ----------------------------------------------------------------------------------------------------------
  public static By PRACTICE_FORM_OPTION = css("div.show #item-0");
  // Public methods ----------------------------------------------------------------------------------------------------
  public void waitForPageToLoad() {
    getElement(FORMS).waitUntilPresent();
    logWeAreOnPage();
  }
}
