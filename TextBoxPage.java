package com.testing.pageObjects.pages;

import java.util.Map;

import org.openqa.selenium.By;

import io.cucumber.datatable.DataTable;
import net.thucydides.core.annotations.DefaultUrl;

@DefaultUrl("/text-box")
public class TextBoxPage extends ElementsPage {
  // Locators ----------------------------------------------------------------------------------------------------------

  // Title of page
  public static By TEXT_BOX_TITLE = text("Text Box");
  // Field that requires user to input Full name
  public static By FULL_NAME_FIELD = id("userName");
  // Field that requires user to input Permatent address
  public static By PERMANENT_ADDRESS_FIELD = xpath("//textarea[@id='permanentAddress']");

  // After user clicks submit button, multiple paragraphs appear with the previously given information
  public static By NAME = css("p#name");
  public static By EMAIL = css("p#email");
  public static By CURRENT_ADDRESS = css("p#currentAddress");
  public static By PERMANENT_ADDRESS = css("p#permanentAddress");
  // Public methods ----------------------------------------------------------------------------------------------------
  public void waitForPageToLoad() {
    getElement(TEXT_BOX_TITLE).waitUntilPresent();
    logWeAreOnPage();
  }

  public Boolean validateTextBoxResults(DataTable data){
    for (Map<String, String> map : dataToMap(data)) {
      for (String key : map.keySet()) {
        info("The element: " + snakify(key) + " should contain " + map.get(key));

        if(getElement(snakify(key)).getText().contains(map.get(key)) == false) return false;
      }
    }
    return true;
  }
}
