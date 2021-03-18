package com.testing.pageObjects.pages;

import net.serenitybdd.core.pages.ListOfWebElementFacades;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.annotations.WhenPageOpens;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static javax.swing.JOptionPane.showMessageDialog;
import static org.junit.Assert.fail;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import io.cucumber.datatable.DataTable;

@DefaultUrl("")
public class BasePage extends PageObject {
  public HashMap<String, By> SelectorList;
  public Logger logger;
  // Public methods
  // -------------------------------------------------------------------------------------------------------------------
  public BasePage() {
    SelectorList = new HashMap<String, By>();
    logger = LoggerFactory.getLogger(this.getClass());
    setDriver(this.getDriver());
    addSelectorsToHashMap();
  }

  @WhenPageOpens
  public void waitForPageToLoad() {
   fail("waitForPageToLoad is undefined for " + this.getClass().getSimpleName());
  }

  // Actions With Elements
  // -------------------------------------------------------------------------------------------------------------------
  public WebElementFacade getElement(String elementName) {
    By selector = SelectorList.get(elementName);

    if (selector == null) {
      String[] className = this.getClass().getName().split("\\.");
      fail("On page: " + className[className.length - 1] + ", the given element is undefined: " + elementName);
    }
    return $(selector);
  }

  public WebElementFacade getElement(By selector) {
    return $(selector);
  }

  public ListOfWebElementFacades getElements(By selector) {
    return $$(selector);
  }

  public void scrollIntoView(WebElementFacade element){
    info("Scrolling into view");
    ((JavascriptExecutor) this.getDriver()).executeScript("arguments[0].scrollIntoView(true);", element);
  }

  public void scrollIntoView(String elementName){
    scrollIntoView(getElement(elementName));
  }

  public void scrollIntoView(By selector){
    scrollIntoView(getElement(selector));
  }

  public void clickUsingScript(String elementName){
    ((JavascriptExecutor) this.getDriver()).executeScript("arguments[0].click();", getElement(elementName));
  }

  public void clickUsingScript(By selector){
    ((JavascriptExecutor) this.getDriver()).executeScript("arguments[0].click();", getElement(selector));
  }

  public void click(By selector){
    try {
      getElement(selector).click();
    } catch (org.openqa.selenium.ElementClickInterceptedException exception){
      info("Clicking failed, retrying by using JS");
      clickUsingScript(selector);
    }
  }

  public void click(String elementName){
    info("Clicking: " + elementName);
    try {
      getElement(elementName).click();
    } catch (org.openqa.selenium.ElementClickInterceptedException exception){
      info("Clicking failed, retrying by using JS");
      clickUsingScript(elementName);
    }
  }

  public void doubleClick(String elementName){
    new Actions(this.getDriver()).doubleClick(getElement(elementName)).perform();
  }

  public void rightClick(String elementName){
    new Actions(this.getDriver()).contextClick(getElement(elementName)).perform();
  }

  public void setElementValueTo(String elementName, String value) {
    getElement(elementName).click();
    getElement(elementName).sendKeys(value);
  }

  public void hoverOver(String elementName){
    new Actions(getDriver()).moveToElement(getElement(elementName)).perform();
  }
  // Selector shortcut methods
  // -------------------------------------------------------------------------------------------------------------------
  public static By css(String cssSelector){
    return By.cssSelector(cssSelector);
  }

  public static By xpath(String xpathSelector){
    return By.xpath(xpathSelector);
  }

  public static By id(String idSelector){
    return By.id(idSelector);
  }

  public static By text(String string){
    return xpath("//*[text()='" + string+ "']");
  }

  public static By ariaLabel(String string){
    return css("[aria-label='" + string + "']");
  }
  // Logging & Debugging
  // -------------------------------------------------------------------------------------------------------------------
  public void info(String string){
    logger.info(string);
  }

  public void logWeAreOnPage(){
    info("On page: " + this.getClass().getSimpleName());
  }

  public void logValidationPassed(String item){
    info("Validation for item: " + item + " passed");
  }

  public void logValidationFailed(String item){
    info("Validation for item: " + item + " failed");
  }

  public void debug(String str) {
    showMessageDialog(null, str);
  }
  // Actions with Data
  // -------------------------------------------------------------------------------------------------------------------
  public List<Map<String, String>> dataToMap(DataTable data){
    return (List<Map<String, String>>) data.asMaps();
  }
  // Auxiliary
  // -------------------------------------------------------------------------------------------------------------------
  @SuppressWarnings("unchecked")
  public void addSelectorsToHashMap(){
    Class<? extends PageObject> currentClass = this.getClass();
    Field[] fields;

    while(!currentClass.getSimpleName().contains("PageObject")){
      fields = currentClass.getDeclaredFields();
      for (Field field : fields) {
        if(!field.getType().getTypeName().contains("selenium.By") || SelectorList.containsKey(field.getName())){
          continue;
        }
        try {
          SelectorList.put(field.getName(), (By) currentClass.getDeclaredField(snakify(field.getName())).get(By.class));
        } catch (IllegalArgumentException | IllegalAccessException | NoSuchFieldException | SecurityException e) {
          e.printStackTrace();
        }      
      }
      currentClass = (Class<? extends PageObject>) currentClass.getSuperclass();
    }
  }

  public void switchToNewTab(){
    WebDriver driver = this.getDriver();
    String currHandle = driver.getWindowHandle();
    Set<String> allHandles = driver.getWindowHandles();

    for (String handle : allHandles) {
      if (!handle.contentEquals(currHandle)) {
        driver.switchTo().window(handle);
        break;
      }
    }
  }

  public void switchToOriginalTab(){
    getDriver().switchTo().window(getDriver().getWindowHandles().iterator().next());
  }

  public String alertWindowGetText(){
    return getDriver().switchTo().alert().getText();
  }

  public void alertWindowSendKeys(String str){
    getDriver().switchTo().alert().sendKeys(str);
  }

  public void alertWindowAccept(){
    getDriver().switchTo().alert().accept();
  }

  public void alertWindowDismiss(){
    getDriver().switchTo().alert().dismiss();
  }

  public String snakify(String string){
    return support.StringEditing.snakify(string);
  }

  public void sleep(int seconds){
    try {
      Thread.sleep(seconds * 1000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }
}
