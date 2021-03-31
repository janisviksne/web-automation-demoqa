package com.testing.pageObjects.pages;

import org.openqa.selenium.By;

import net.thucydides.core.annotations.DefaultUrl;

@DefaultUrl("/")
public class HomePage extends BasePage {
  // Locators ----------------------------------------------------------------------------------------------------------
  public static By BODY = css("body");
  public static By TOP_LOGO = css("a[href*='demoqa.com']");
  public static By BANNER = css("img[alt='New Live Session']");
  public static By ELEMENTS = text("Elements");
  public static By FORMS = text("Forms");
  public static By ALERTS_FRAME_AND_WINDOWS = text("Alerts, Frame & Windows");
  public static By WIDGETS = text("Widgets");
  public static By INTERACTIONS = text("Interactions");
  public static By BOOK_STORE_APPLICATION = text("Book Store Application");
  // Common elements ---------------------------------------------------------------------------------------------------
  // These elements are found in multiple pages, therefore we are defining them in a parent HomePage (parent class)
  public static By FIRST_NAME_FIELD = css("input[id='firstName']");
  public static By LAST_NAME_FIELD = css("input[id='lastName']");
  public static By EMAIL_FIELD = css("input[id=userEmail]");
  public static By SUBMIT_BUTTON = id("submit");
  public static By CURRENT_ADDRESS_FIELD = css("textarea[id='currentAddress']");
  public static By YEAR_PICKER = css("[class*='react-datepicker__year']");
  public static By MONTH_PICKER = css("select.react-datepicker__month-select");
  public static By CURRENT_MONTH_DATES = xpath("//div[(contains(@class, 'react-datepicker__day--')) and not(contains(@class, 'outside'))]");
  // Public methods ----------------------------------------------------------------------------------------------------
  public void waitForPageToLoad() {
    getElement(BANNER).waitUntilPresent();
    logWeAreOnPage();
  }

  public void click(String elementName){
    if(elementName.contains("_OPTION")) scrollIntoView(elementName);
    super.click(elementName);
    if(elementName.contains("_OPTION")) scrollIntoView(TOP_LOGO);
  }
}
