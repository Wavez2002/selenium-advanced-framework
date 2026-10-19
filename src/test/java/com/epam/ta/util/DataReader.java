package com.epam.ta.util;

import java.io.InputStream;
import java.util.Properties;

public class DataReader {
  private static Properties properties = new Properties();

  static {
    String env = System.getProperty("env", "qa");
    try (InputStream input = DataReader.class.getClassLoader().getResourceAsStream(env + ".properties")) {
      if (input != null) {
        properties.load(input);
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public static String getProperty(String key) {
    return properties.getProperty(key);
  }
}