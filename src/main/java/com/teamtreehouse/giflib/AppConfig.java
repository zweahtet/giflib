package com.teamtreehouse.giflib;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

@EnableAutoConfiguration
@ComponentScan // the Spring framework doesn't automatically scan your packages for controllers
// so we need to instruct the framework to scan the current package for controllers
public class AppConfig {

  public static void main(String[] args) {
    SpringApplication.run(AppConfig.class, args);
  }
}
