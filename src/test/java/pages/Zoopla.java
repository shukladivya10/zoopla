package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Zoopla {
  WebDriver driver;
  public Zoopla(WebDriver driver) {
	  this.driver=driver;
	  PageFactory.initElements(driver, Zoopla.class);
  }
  @FindBy(id = "search")
  WebElement search;
  
  @FindBy(id = "filterBy")
  WebElement filterBy;
  
 public void enterSearchCity(String cityName){
	 search.sendKeys(cityName);
 }
 public void selectFilter(){
	 filterBy.isDisplayed();
 }
  
}
