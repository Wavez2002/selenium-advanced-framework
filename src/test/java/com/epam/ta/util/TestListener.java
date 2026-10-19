package com.epam.ta.util;

import com.epam.ta.driver.DriverSingleton;
import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TestListener implements ITestListener {
  private static final Logger logger = LogManager.getLogger(TestListener.class);

  @Override
  public void onTestFailure(ITestResult result) {
    saveScreenshot(result.getName());
  }

  private void saveScreenshot(String methodName) {
    File screenFile = ((TakesScreenshot) DriverSingleton.getDriver()).getScreenshotAs(OutputType.FILE);
    String timeStamp = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss").format(new Date());
    String filePath = "target/screenshots/" + methodName + "_" + timeStamp + ".png";
    try {
      FileUtils.copyFile(screenFile, new File(filePath));
      logger.error("Screenshot saved at: " + filePath);
    } catch (Exception e) {
      logger.error("Failed to save screenshot: " + e.getMessage());
    }
  }
}