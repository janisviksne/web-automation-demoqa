package com.testing.pageObjects.pages;


import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import io.cucumber.datatable.DataTable;
import net.thucydides.core.annotations.DefaultUrl;

@DefaultUrl("/slider")
public class SliderPage extends WidgetsPage {
  // Locators ----------------------------------------------------------------------------------------------------------
  public static By SLIDER_TITLE;
  // Slider ball/ or sldier itself
  public static By SLIDER_BALL;
  public static By SLIDER_VALUE;
  // Public methods ----------------------------------------------------------------------------------------------------
  public void waitForPageToLoad() {
    getElement(SLIDER_TITLE).waitUntilPresent();
    logWeAreOnPage();
  }

  public void setElementValueTo(String elementName, String value) {
    switch(elementName){
      case "SLIDER_BALL":
        int sliderValue = 0;
        // Converting the required value given in parameter to integer
        int intOfValue = Integer.valueOf(value);

        // TODO: Implement a logic that would move the slider to the left (Keys.LEFT) or right (Keys.RIGHT),
        // based on it's current possition, and the value given in the parameter.
  
        // sliderValue - current value of slider ball
        sliderValue = Integer.valueOf(getElement(SLIDER_BALL).getValue());

        break;
      default:
        super.setElementValueTo(elementName, value);
    }
  }

  public Boolean validateSliderValue(DataTable data){
    for (Map<String, String> map : dataToMap(data)) {
      for (String key : map.keySet()) {
        if(snakify(key).equals("VALUE") && getElement(SLIDER_VALUE).getValue().equals(map.get(key))) return true;
      } 
    }
    return false;
  }
}
