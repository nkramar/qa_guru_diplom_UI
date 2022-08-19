package tests;


import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import config.Project;
import helpers.AllureAttachments;
import helpers.DriverSettings;
import helpers.DriverUtils;
import io.qameta.allure.junit5.AllureJunit5;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import pages.NavigationPanel;

import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;


@ExtendWith({AllureJunit5.class})
public class TestBase {

  NavigationPanel navigationPanel = new NavigationPanel();

  @BeforeAll
  static void beforeAll() {
    DriverSettings.configure();
    SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
  }

  @BeforeEach
  public void openMainPage() {
    step("Открываем главную страницу сайта", () -> open(Configuration.baseUrl));
  }

  @AfterEach
  public void afterEach() {
    String sessionId = DriverUtils.getSessionId();

    AllureAttachments.addScreenshotAs("Last screenshot");
    AllureAttachments.addPageSource();

    AllureAttachments.addBrowserConsoleLogs();


    if (Project.isVideoOn()) {
      AllureAttachments.addVideo(sessionId);
    }
  }

  @AfterAll
  public static void afterAll(){ Selenide.closeWebDriver();
  }
}
