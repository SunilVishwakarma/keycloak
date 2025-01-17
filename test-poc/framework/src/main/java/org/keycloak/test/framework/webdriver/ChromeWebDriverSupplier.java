package org.keycloak.test.framework.webdriver;

import org.keycloak.test.framework.injection.InstanceWrapper;
import org.keycloak.test.framework.injection.LifeCycle;
import org.keycloak.test.framework.injection.Registry;
import org.keycloak.test.framework.injection.Supplier;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ChromeWebDriverSupplier implements Supplier<WebDriver, TestWebDriver> {

    @Override
    public Class<TestWebDriver> getAnnotationClass() {
        return TestWebDriver.class;
    }

    @Override
    public Class<WebDriver> getValueType() {
        return WebDriver.class;
    }

    @Override
    public InstanceWrapper<WebDriver, TestWebDriver> getValue(Registry registry, TestWebDriver annotation) {
        final var driver = new ChromeDriver();
        return new InstanceWrapper<>(this, annotation, driver);
    }

    @Override
    public LifeCycle getLifeCycle() {
        return LifeCycle.GLOBAL;
    }

    @Override
    public boolean compatible(InstanceWrapper<WebDriver, TestWebDriver> a, InstanceWrapper<WebDriver, TestWebDriver> b) {
        return true;
    }

    @Override
    public void close(WebDriver instance) {
        instance.quit();
    }
}
