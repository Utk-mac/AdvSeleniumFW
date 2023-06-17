package listeners;

import enums.ConfigProperties;
import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;
import utils.ReadPropertiesFile;

public class RetryFailedTest implements IRetryAnalyzer {
    private int count = 0;
    private int retry = 1;
    @Override
    public boolean retry(ITestResult iTestResult) {
        try {
            if (ReadPropertiesFile.getValue(ConfigProperties.RETRYFAILEDTEST).equalsIgnoreCase("yes")) {
                if (count < retry) {
                    count++;
                    return true;
                }
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return false;
    }
}
