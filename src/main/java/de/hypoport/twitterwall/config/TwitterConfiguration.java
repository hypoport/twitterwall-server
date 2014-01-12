package de.hypoport.twitterwall.config;

import org.springframework.stereotype.Component;

import java.util.logging.Level;
import java.util.logging.Logger;

@Component
public class TwitterConfiguration {

  static Logger logger = Logger.getLogger(TwitterConfiguration.class.getCanonicalName());

  private String[] defaultUsersForSearch;
  private String consumerKey;
  private String consumerSecret;

  public TwitterConfiguration() {
    this.consumerKey = System.getProperty("consumerKey", System.getenv("consumerKey"));
    this.consumerSecret = System.getProperty("consumerSecret", System.getenv("consumerSecret"));
    this.defaultUsersForSearch = new String[]{};
  }

  public boolean isFullyConfigured() {
    boolean fullyConfigured = consumerKey != null && consumerSecret != null && !consumerKey.isEmpty() && !consumerSecret.isEmpty();
    if (!fullyConfigured) {
      logger.log(Level.WARNING, "No configuration for Twitter found.\n" +
          "The search service is disabled and will only return mock data!\n" +
          "Please provide 'consumerKey' and 'consumerSecret' variables as environment variable OR as system property.");
    } else {
      logger.info("Found Twitter access tokes (consumerKey and consumerSecret).");
    }
    return fullyConfigured;
  }

  public String getConsumerKey() {
    return consumerKey;
  }

  public String getConsumerSecret() {
    return consumerSecret;
  }

  public String[] getDefaultUsersForSearchQuery() {
    return defaultUsersForSearch;
  }
}
