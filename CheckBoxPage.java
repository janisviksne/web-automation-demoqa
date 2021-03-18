package com.testing.pageObjects.pages;

import java.util.Map;

import org.openqa.selenium.By;

import io.cucumber.datatable.DataTable;
import net.thucydides.core.annotations.DefaultUrl;

@DefaultUrl("/checkbox")
public class CheckBoxPage extends ElementsPage {
  // Locators ----------------------------------------------------------------------------------------------------------

  // The button that looks like "Pluss sign"
  public static By EXPAND_BUTTON = css("button[aria-label='Expand all']");
  // Self explanatory
  public static By CHECK_BOX_TITLE = text("Check Box");
  // Find selector for each checkbox
  public static By COMMANDS = text("Commands");
  public static By ANGULAR = text("Angular");
  public static By CLASSIFIED = text("Classified");
  public static By EXCEL_FILE = text("Excel File.doc");
  // After user selects different options, a string is shown to user containing ALL the selected options.
  public static By RESULT = id("result");
  // Public methods ----------------------------------------------------------------------------------------------------
  public void waitForPageToLoad() {
    getElement(CHECK_BOX_TITLE).waitUntilPresent();
    logWeAreOnPage();
  }

  public Boolean validateSelectedResults(DataTable data){
    for (Map<String, String> map : dataToMap(data)) {
      info("Validating item: " + map.get("Item"));
      if(!getElement(RESULT).getText().contains(map.get("Item"))) return false;
    }
    return true;
  }
}
