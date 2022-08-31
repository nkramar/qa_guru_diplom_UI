package tests;

import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byLinkText;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;
import static org.assertj.core.api.Assertions.assertThat;


public class T1ConsultingTests extends TestBase {


  @Test
  @Tag("smoke")
  @Owner("nkramar")
  @Feature("Титульное название страницы")
  @Story("Веб адрес страницы")
  @DisplayName("Проверка титульного названия страницы ")
  void checkTitleTest() {
    step("Проверить, что титульное название страницы содержит текст '«Т1 Консалтинг»'", () -> {
      String expectedTitle = "«Т1 Консалтинг»";
      String actualTitle = title();
      assertThat(actualTitle).isEqualTo(expectedTitle);
    });
  }

  @Test
  @Owner("nkramar")
  @Feature("Навигационная панель")
  @Story("Видимость текстовых элементов в навигационной панели")
  @DisplayName("Проверка видимости элементов в навигационной панели")
  void checkAvailabilityOfHeaderElementsTest() {
    step("Проверить, что в навигационной панели отображаются текстовые элементы",
            () -> navigationPanel.checkNavigationPanelHeaderTexts(navigationPanel.navigationPanelHeaderTexts));
  }

  @Test
  @Owner("nkramar")
  @Feature("Логи консоли")
  @Story("Ошибки в логе консоли при работе сайта")
  @DisplayName("Проверка лога консоли страницы на наличие ошибок")
  void consoleShouldNotHaveErrorsTest() {
    step("Проверить, что лог консоли не содержит текст: 'SEVERE'", () -> {
      String consoleLogs = getConsoleLogs();
      String errorText = "SEVERE";
      assertThat(consoleLogs).doesNotContain(errorText);
    });
  }


  private static Stream<Arguments> checkPageHeader() {
    return Stream.of(
            Arguments.of("О компании", "О компании"),
            Arguments.of("Услуги", "Услуги"),
            Arguments.of("Продукты", "Продукты"),
            Arguments.of("Контакты", "Контакты"));
  }

  @Owner("nkramar")
  @Feature("Навигационная панель")
  @Story("Кликабельность элементов навигационной панели")
  @MethodSource("checkPageHeader")
  @ParameterizedTest(name = "Проверка кликабельности элемента страницы: {0}")
  void checkHeaderTextOnMainPages(String menuItem, String pageHeaderText) {
    step("Кликаем по элементу навигационной панели", ()
            -> navigationPanel.clickOnNavigationPanelElements(menuItem));

    step("Проверяем заголовок открывшейся страницы", () -> {
      $(".content h1").shouldHave(text(pageHeaderText));
    });
  }

  @Owner("nkramar")
  @Feature("Страница 'Услуги'")
  @Story("Навигация по страницам с услугами")
  @CsvSource(value = {
          "Фронт, Фронт",
          "Миддл, Миддл",
          "Бэк, Бэк",
          "Импортозамещение, Импортозамещение",
          "Цифровые решения, Цифровые решения",
          "Аналитика, Аналитика",
          "BigData,BigData"
  })
  @ParameterizedTest(name = "Переход на страницу c услугой: {0}")
  void checkHeaderTextOnServicesPages(String menuItem, String pageHeader) {
    step("Наводим мышку на элемент навигационной панели 'Услуги'", ()
            -> navigationPanel.hoverNavigationPanelElement("Услуги"));

    step("Кликаем нанужный элемент в сплывающем меню", ()
            -> $(byLinkText(menuItem)).click());

    step("Проверяем заголовок открывшейся страницы", ()
            -> { $(".content h1").shouldHave(text(pageHeader));
    });

  }
}


