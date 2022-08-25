package config;

import org.aeonbits.owner.Config;

@Config.Sources({
        "classpath:${host}.properties"
})

public interface HostConfig extends Config {

    @Key("baseUrl")
    @DefaultValue("https://www.t1-consulting.ru")
    String getBaseUrl();

    @Key("remoteUrl")
    String getRemoteUrl();

    @Key ("browser")
    @DefaultValue("chrome")
    String getBrowser();

    @Key("browserSize")
    @DefaultValue("1920x1080")
    String getBrowserSize();

    @Key("browserVersion")
    @DefaultValue("100.0")
    String getBrowserVersion();
}
