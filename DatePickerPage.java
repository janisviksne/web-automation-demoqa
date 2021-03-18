package com.testing.pageObjects.pages;

import java.util.Map;

import org.openqa.selenium.By;

import io.cucumber.datatable.DataTable;
import net.thucydides.core.annotations.DefaultUrl;

@DefaultUrl("/date-picker")
public class DatePickerPage extends WidgetsPage{
  // Locators ----------------------------------------------------------------------------------------------------------
  public static By DATE_PICKER_TITLE;
  public static By SELECT_DATE;
  public static By SELECT_DATE_AND_TIME;
  public static By MONTH_ALTERNATIVE_PICKER = css("[class*='react-datepicker__month-dropdown']");
  // Public methods ----------------------------------------------------------------------------------------------------
  public void waitForPageToLoad() {
    getElement(DATE_PICKER_TITLE).waitUntilPresent();
    logWeAreOnPage();
  }

  public void setElementValueTo(String elementName, String value) {
    switch(elementName){
      case "YEAR_FIELD":
        getElement(YEAR_PICKER).click();
        scrollIntoView(text(value));
        getElement(text(value)).click();
        break;
      case "MONTH_FIELD":
        if(getElement(MONTH_PICKER).isPresent()){
          getElement(MONTH_PICKER).click();
        } else {
          getElement(MONTH_ALTERNATIVE_PICKER).click();
        }
        scrollIntoView(text(value));
        getElement(text(value)).click();
        break;
      case "TIME_FIELD":
        scrollIntoView(text(value));
        getElement(text(value)).click();
        break;
      case "DATE_FIELD":
        int date = Integer.valueOf(value);

        getElements(CURRENT_MONTH_DATES).get(date - 1).click();
        break;
      default:
        super.setElementValueTo(elementName, value);
    }
  }

  public Boolean validateSelectDateValue(DataTable data){
    for (Map<String, String> map : dataToMap(data)) {
      for (String key : map.keySet()) {
        if(snakify(key).equals("VALUE") && getElement(SELECT_DATE).getValue().equals(map.get(key))) return true;
      } 
    }
    return false;
  }

  public Boolean validateSelectDateAndTimeValue(DataTable data){
    for (Map<String, String> map : dataToMap(data)) {
      for (String key : map.keySet()) {
        if(snakify(key).equals("VALUE") && getElement(SELECT_DATE_AND_TIME).getValue().equals(map.get(key))) return true;
      } 
    }
    return false;
  }
}
