package driverBase;

import org.openqa.selenium.WebDriver;

public final class DriverFactory {

    private DriverFactory(){}

    private DriverFactory driverFactoryInstance = new DriverFactory();
    public DriverFactory getDriverFactoryInstance() {
        return driverFactoryInstance;
    }

    public static WebDriver getDriver() {
        return driverThreadLocal.get() ;
    }

    public static void setDriver(WebDriver driverParam){
        driverThreadLocal.set(driverParam);
    }

    public static void unloadDriver(){
        driverThreadLocal.remove();

    }

    private void setDriverFactoryInstance(DriverFactory driverFactoryInstance) {
        this.driverFactoryInstance = driverFactoryInstance;
    }

    static ThreadLocal<WebDriver> driverThreadLocal = new ThreadLocal<>();

}
