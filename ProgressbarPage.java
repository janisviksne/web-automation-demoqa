package com.testing.pageObjects.pages;

import java.util.Map;

import org.openqa.selenium.By;

import io.cucumber.datatable.DataTable;
import net.thucydides.core.annotations.DefaultUrl;

@DefaultUrl("/progress-bar")
public class ProgressbarPage extends WidgetsPage{
  // Locators ----------------------------------------------------------------------------------------------------------
  public static By PROGRESS_BAR_TITLE;
  public static By START_STOP_BUTTON;
  public static By PROGRESS_BAR;
  // Public methods ----------------------------------------------------------------------------------------------------
  public void waitForPageToLoad() {
    getElement(PROGRESS_BAR_TITLE).waitUntilPresent();
    logWeAreOnPage();
  }

  public void setElementValueTo(String elementName, String value){
    switch(elementName){
      case "PROGRESS_BAR":
        getElement(START_STOP_BUTTON).click();

        // The expected value to reach
        int expectedValue = Integer.valueOf(value);
        int currentBarValue = 0;

        // TODO: Implement a logic that would stop the progress bar when the required value is reached
        currentBarValue = Integer.valueOf(getElement(PROGRESS_BAR).getAttribute("aria-valuenow"));

        break;
      default:
        super.setElementValueTo(elementName, value);
    }
  }

  public Boolean validateProgressBar(DataTable data){
    for (Map<String, String> map : dataToMap(data)) {
      for (String key : map.keySet()) {
        if(snakify(key).equals("VALUE") && getElement(PROGRESS_BAR).getAttribute("aria-valuenow").equals(map.get(key))) return true;
      } 
    }
    return false;
  }
}
