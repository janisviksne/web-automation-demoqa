package com.testing.pageObjects.pages;

import org.openqa.selenium.By;

import net.thucydides.core.annotations.DefaultUrl;

@DefaultUrl("/accordian")
public class AccordianPage extends WidgetsPage{
  // Locators ----------------------------------------------------------------------------------------------------------
  public static By ACCORDIAN_TITLE;
  // Page contains multiple headings, find correct selector for each of the three sections
  public static By SECTION_ONE_HEADING;
  public static By SECTION_TWO_HEADING;
  public static By SECTION_THREE_HEADING;
  // When user opens each section, by clicking the heading, a content block with text is shown to user
  public static By CONTENT;
  // Public methods ----------------------------------------------------------------------------------------------------
  public void waitForPageToLoad() {
    getElement(ACCORDIAN_TITLE).waitUntilPresent();
    logWeAreOnPage();
  }
}
