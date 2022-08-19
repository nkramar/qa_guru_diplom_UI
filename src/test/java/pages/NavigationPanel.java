package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;


public class NavigationPanel {

  public SelenideElement navigationPanelHeader = $(".header");
  public final String navigationPanelHeaderTexts = "О компании Услуги\n" +
          "Продукты\n" + "Контакты\n" + "+7 495 981-92-92\n" + "Обратная связь";



  public void checkNavigationPanelHeaderTexts(String value) {
    navigationPanelHeader.shouldHave(exactText(value));
  }

  public void clickOnNavigationPanelElements(String value) {
    navigationPanelHeader.$(byText(value)).click();
  }
}
