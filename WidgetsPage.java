package com.testing.pageObjects.pages;

import org.openqa.selenium.By;

import net.thucydides.core.annotations.DefaultUrl;

@DefaultUrl("/widgets")
public class WidgetsPage extends HomePage{
  // Locators ----------------------------------------------------------------------------------------------------------
  public static By ACCORDIAN_OPTION = css("div.show #item-0");
  public static By AUTO_COMPLETE_OPTION = css("div.show #item-1");
  public static By DATE_PICKER_OPTION = css("div.show #item-2");
  public static By SLIDER_OPTION = css("div.show #item-3");
  public static By PROGRESS_BAR_OPTION = css("div.show #item-4");
  public static By TABS_OPTION = css("div.show #item-5");
  public static By TOOL_TIPS_OPTION = css("div.show #item-6");
  public static By MENU_OPTION = css("div.show #item-7");
  public static By SELECT_MENU_OPTION = css("div.show #item-8");
  // Public methods ----------------------------------------------------------------------------------------------------
  public void waitForPageToLoad() {
    getElement(WIDGETS).waitUntilPresent();
    logWeAreOnPage();
  }
}
