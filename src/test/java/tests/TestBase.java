package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import config.HostConfig;
import helpers.AllureAttachments;
import io.qameta.allure.selenide.AllureSelenide;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.remote.DesiredCapabilities;
import pages.MainPage;
import pages.NavigationPanel;
import static com.codeborne.selenide.Selenide.closeWebDriver;
import static org.openqa.selenium.logging.LogType.BROWSER;

public class TestBase {

  NavigationPanel navigationPanel = new NavigationPanel();
  MainPage mainPage = new MainPage();
  static HostConfig hostConfig = ConfigFactory.create(HostConfig.class, System.getProperties());
  static String baseUrl = hostConfig.getBaseUrl();

  @BeforeAll
  static void configure() {
    Configuration.browser = hostConfig.getBrowser();
    Configuration.browserSize = hostConfig.getBrowserSize();
    Configuration.browserVersion = hostConfig.getBrowserVersion();
    Configuration.baseUrl = baseUrl;

    if (!System.getProperty("remoteUrl", "false").isEmpty()) {
      setRemoteWebdriver();
    }
    SelenideLogger.addListener("Allure Selenide", new AllureSelenide());
  }

  @AfterEach
  void addAttach() {
    AllureAttachments.screenshotAs("Last screenshot");
    AllureAttachments.pageSource();
    AllureAttachments.browserConsoleLogs();
    AllureAttachments.addVideo();
  }

  @AfterAll
  static void close() {
    closeWebDriver();
  }

  static void setRemoteWebdriver() {
    DesiredCapabilities capabilities = new DesiredCapabilities();
    capabilities.setCapability("enableVNC", true);
    capabilities.setCapability("enableVideo", true);
    Configuration.browserCapabilities = capabilities;
    Configuration.remote = hostConfig.getRemoteUrl();
  }

  public static String getConsoleLogs() {
    return String.join("\n", Selenide.getWebDriverLogs(BROWSER));
  }
}