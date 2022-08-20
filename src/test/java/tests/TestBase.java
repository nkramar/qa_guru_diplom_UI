package tests;


import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import config.LaunchConfig;
import helpers.AllureAttachments;
import io.qameta.allure.selenide.AllureSelenide;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.remote.DesiredCapabilities;
import pages.NavigationPanel;
import static com.codeborne.selenide.Selenide.closeWebDriver;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;
import static org.openqa.selenium.logging.LogType.BROWSER;


public class TestBase {

  NavigationPanel navigationPanel = new NavigationPanel();

  static LaunchConfig launchConfig = ConfigFactory.create(LaunchConfig.class, System.getProperties());

  static String baseUrl = launchConfig.getBaseUrl();

  public static String getConsoleLogs() {
    return String.join("\n", Selenide.getWebDriverLogs(BROWSER));
  }


  @BeforeAll
  static void configure() {
    System.getProperty("host", "remote");
    Configuration.remote = launchConfig.getRemoteUrl();
    Configuration.browser = launchConfig.getBrowser();
    Configuration.browserSize = launchConfig.getBrowserSize();
    Configuration.browserVersion = launchConfig.getBrowserVersion();
    Configuration.baseUrl = baseUrl;

    SelenideLogger.addListener("Allure Selenide", new AllureSelenide());

    DesiredCapabilities capabilities = new DesiredCapabilities();
    capabilities.setCapability("enableVNC", true);
    capabilities.setCapability("enableVideo", true);
    Configuration.browserCapabilities = capabilities;
  }

  @BeforeEach
  public void openMainPage() {
    step("Открываем главную страницу сайта", () -> open(baseUrl));
  }

  @AfterEach
  void addAttach() {
    AllureAttachments.screenshotAs("Last screenshot");
    AllureAttachments.pageSource();
    AllureAttachments.browserConsoleLogs();
    AllureAttachments.addVideo();

  }

  @AfterAll
  static void close() { closeWebDriver(); }

}

