package de.hypoport.twitterwall.twitter;

import org.springframework.stereotype.Component;
import twitter4j.*;
import twitter4j.conf.Configuration;
import twitter4j.conf.ConfigurationBuilder;

import java.util.logging.Level;
import java.util.logging.Logger;

@Component
public class TweetSearchService {

  Logger logger = Logger.getLogger(TweetSearchService.class.getName());

  private static final String consumerKey = System.getProperty("consumerKey", System.getenv("consumerKey"));
  private static final String consumerSecret = System.getProperty("consumerSecret", System.getenv("consumerSecret"));
  private Twitter twitter;

  public QueryResult searchTweets(Query query) throws TwitterException {
    try {
      return doSearch(query);
    } catch (TwitterException e) {
      logger.log(Level.SEVERE, e.getMessage());
      twitter = null;
    }
    return doSearch(query);
  }

  private QueryResult doSearch(Query query) throws TwitterException {
    return getTwitter().search(query);
  }

  private Twitter getTwitter() throws TwitterException {
    if (twitter == null) {
      twitter = new TwitterFactory(configure()).getInstance();
      twitter.getOAuth2Token();
    }
    return twitter;
  }

  private Configuration configure() {
    ConfigurationBuilder builder = new ConfigurationBuilder();
    builder.setUseSSL(true);
    builder.setJSONStoreEnabled(true);
    builder.setOAuthConsumerKey(consumerKey);
    builder.setOAuthConsumerSecret(consumerSecret);
//    useProxy(builder);
    builder.setApplicationOnlyAuthEnabled(true);
    return builder.build();
  }

  private void useProxy(ConfigurationBuilder builder) {
    builder.setHttpProxyHost("localhost");
    builder.setHttpProxyPort(3128);
  }
}
