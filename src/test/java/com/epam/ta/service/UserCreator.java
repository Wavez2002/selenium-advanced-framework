package com.epam.ta.service;

import com.epam.ta.model.User;
import com.epam.ta.util.DataReader;

public class UserCreator {
  public static User withCredentialsFromProperty() {
    return new User(DataReader.getProperty("default.username"), DataReader.getProperty("default.password"));
  }

  public static User withEmptyUsername() {
    return new User("", DataReader.getProperty("default.password"));
  }

  public static User withEmptyPassword() {
    return new User(DataReader.getProperty("default.username"), "");
  }
}