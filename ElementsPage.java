package com.testing.pageObjects.pages;

import org.openqa.selenium.By;

import net.thucydides.core.annotations.DefaultUrl;

@DefaultUrl("/elements")
public class ElementsPage extends HomePage {
  // Locators ----------------------------------------------------------------------------------------------------------
  public static By TEXT_BOX_OPTION = css("div.show #item-0");
  public static By CHECK_BOX_OPTION = css("div.show #item-1");
  public static By RADIO_BUTTON_OPTION = css("div.show #item-2");
  public static By WEB_TABLES_OPTION = css("div.show #item-3");
  public static By BUTTONS_OPTION = css("div.show #item-4");
  public static By LINKS_OPTION = css("div.show #item-5");
  public static By BROKEN_LINKS_OPTION = css("div.show #item-6");
  public static By UPLOAD_AND_DOWNLOAD_OPTION = css("div.show #item-7");
  public static By DYNAMIC_PROPERTIES_OPTION = css("div.show #item-8");
  // Public methods ----------------------------------------------------------------------------------------------------
  public void waitForPageToLoad() {
    getElement(ELEMENTS).waitUntilPresent();
    logWeAreOnPage();
  }
}
