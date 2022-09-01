package pages;

import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byLinkText;
import static com.codeborne.selenide.Selenide.$;

public class MainPage {
  SelenideElement header = $(".content h1");

  public void clickOnMenuItem(String menuItem) {
    $(byLinkText(menuItem)).click();
  }

  public void checkHeaderText(String headerText){
    header.shouldHave(text(headerText));
  }
}
