package com.testing.pageObjects.pages;

import org.openqa.selenium.By;

import net.thucydides.core.annotations.DefaultUrl;

@DefaultUrl("/alertsWindows")
public class AlertsFrameAndWindowsPage extends HomePage{
  // Locators ----------------------------------------------------------------------------------------------------------
  public static By BROWSER_WINDOWS_OPTION = css("div.show #item-0");
  public static By ALERTS_OPTION = css("div.show #item-1");
  public static By FRAMES_OPTION = css("div.show #item-2");
  public static By NESTED_FRAMES_OPTION = css("div.show #item-3");
  public static By MODAL_DIALOGS_OPTION = css("div.show #item-4");
  // Public methods ----------------------------------------------------------------------------------------------------
  public void waitForPageToLoad() {
    getElement(ALERTS_FRAME_AND_WINDOWS).waitUntilPresent();
    logWeAreOnPage();
  }
}
