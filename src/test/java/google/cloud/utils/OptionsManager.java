package google.cloud.utils;

import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;

public class OptionsManager {

    public static ChromeOptions getChromeOptions() {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--ignore-certificate-errors");
        chromeOptions.addArguments("--disable-popup-blocking");
        return chromeOptions;
    }

    public static FirefoxOptions getFirefoxOptions() {
        FirefoxOptions firefoxOptions = new FirefoxOptions();
        FirefoxProfile profile = new FirefoxProfile(); //Во время инициализации FirefoxDriver всегда происходит создание нового профиля браузера, предназначенного для тестирования
        profile.setAcceptUntrustedCertificates(true);
        profile.setAssumeUntrustedCertificateIssuer(false);
        profile.setPreference("geo.enabled", true);
        profile.setPreference("geo.prompt.testing", true);
        profile.setPreference("geo.prompt.testing.allow", true);
        firefoxOptions.setCapability(FirefoxDriver.PROFILE, profile);
        return firefoxOptions;
    }
}

