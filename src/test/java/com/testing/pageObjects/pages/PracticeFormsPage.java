package com.testing.pageObjects.pages;

import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import io.cucumber.datatable.DataTable;
import net.serenitybdd.core.pages.ListOfWebElementFacades;
import net.thucydides.core.annotations.DefaultUrl;

@DefaultUrl("/automation-practice-form")
public class PracticeFormsPage extends FormsPage{
  // Locators ----------------------------------------------------------------------------------------------------------
  public static By MOBILE_NUMBER_FIELD = css("input[id='userNumber']");
  public static By SUBJECT_FIELD = css("input[id='subjectsInput']");
  public static By MALE_RADIO_BUTTON = css("input[id='gender-radio-1']");
  public static By FEMALE_RADIO_BUTTON = css("input[id='gender-radio-2']");
  public static By OTHER_RADIO_BUTTON= css("input[id='gender-radio-3']");
  public static By SPORTS_CHECKBOX = css("input[id='hobbies-checkbox-1']");
  public static By READING_CHECKBOX = css("input[id='hobbies-checkbox-2']");
  public static By MUSIC_CHECKBOX = css("input[id='hobbies-checkbox-3']");
  public static By STATE_FIELD = css("div[id='state']");;
  public static By CITY_FIELD = css("div[id='city']");;
  public static By SUBJECTS_MENU= css("div[id='subjectsContainer']");
  // After user clicks submit button, a dialog box containing rows with information is shown to user,
  // find selector for rows only without the first "Title" row. Should be around total of 10.
  public static By TABLE_ROW = css("tbody tr");
  public static By DATE_OF_BIRTH = css("input[id='dateOfBirthInput']");
  public static By UPLOAD_PICTURE = css("input[id='uploadPicture']");
  // Public methods ----------------------------------------------------------------------------------------------------
  public void waitForPageToLoad() {
    getElement(FORMS).waitUntilPresent();
    logWeAreOnPage();
  }

  public void setElementValueTo(String elementName, String value) {
    switch(elementName){
      case "STATE_FIELD":
      case "CITY_FIELD":
        scrollIntoView(elementName);
        getElement(elementName).click();
        getElement(text(value)).click();
        break;
      case "SUBJECT_FIELD":
        getElement(elementName).click();
        getElement(elementName).sendKeys(value);
        getElement(elementName).sendKeys(Keys.ENTER);
        break;
      case "YEAR_FIELD":
        getElement(YEAR_PICKER).click();
        scrollIntoView(text(value));
        getElement(text(value)).click();
        break;
      case "MONTH_FIELD":
        getElement(MONTH_PICKER).click();
        scrollIntoView(text(value));
        getElement(text(value)).click();
        break;
      case "DATE_FIELD":
        int date = Integer.valueOf(value);

        getElements(CURRENT_MONTH_DATES).get(date - 1).click();
        break;
      case "UPLOAD_PICTURE":
        String currentDir = System.getProperty("user.dir");

        getElement(UPLOAD_PICTURE).sendKeys(currentDir + value);
        break;
      default:
        super.setElementValueTo(elementName, value);
    }
  }

  public Boolean validateSubmittionForm(DataTable data){
    ListOfWebElementFacades elements = getElements(TABLE_ROW);
    String value;

    for (Map<String, String> map : dataToMap(data)) {      
      for (String key : map.keySet()) {
        info("Validating: " + snakify(key));

        value = "";
        switch(snakify(key)){
          case "FIRST_NAME":
          case "LAST_NAME":
            value = elements.get(0).getText();
            break;
          case "EMAIL":
            value = elements.get(1).getText();
            break;
          case "MOBILE_NUMBER":
            value = elements.get(3).getText();
            break;
          case "SUBJECT":
            value = elements.get(5).getText();
            break;
          case "CURRENT_ADDRESS":
            value = elements.get(8).getText();
            break;
          case "STATE":
          case "CITY":
            value = elements.get(9).getText();
            break;
          case "GENDER":
            value = elements.get(2).getText();
            break;
          case "HOBBIES":
            value = elements.get(6).getText();
            break;
          case "DATE_OF_BIRTH":
            value = elements.get(4).getText();
            break;
          case "PICTURE":
            value = elements.get(7).getText();
            break;
          default:
            info("The given key is undefined: " + key);
            return false;
        }

        if(!value.contains(map.get(key))){
          info("Validation failed - expected \"" + value + "\" to contain \"" + map.get(key) + "\"");
          return false;
        }
      }
    }
    return true;
  }
}
