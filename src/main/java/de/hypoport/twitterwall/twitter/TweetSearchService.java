package de.hypoport.twitterwall.twitter;

import org.springframework.stereotype.Component;
import twitter4j.*;
import twitter4j.conf.Configuration;
import twitter4j.conf.ConfigurationBuilder;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@Component
public class TweetSearchService {

  Logger logger = Logger.getLogger(TweetSearchService.class.getName());

  private static final String consumerKey = System.getProperty("consumerKey", System.getenv("consumerKey"));
  private static final String consumerSecret = System.getProperty("consumerSecret", System.getenv("consumerSecret"));
  private Twitter twitter;

  public List<Status> searchTweets(String searchText) throws TwitterException {
    try {
      return doSearch(searchText);
    } catch (TwitterException e) {
      logger.log(Level.SEVERE, e.getMessage());
      twitter = null;
    }
    return doSearch(searchText);
  }

  private List<Status> doSearch(String searchText) throws TwitterException {
    QueryResult searchResult = getTwitter().search(new Query(searchText));
    return searchResult.getTweets();
  }

  private Twitter getTwitter() throws TwitterException {
    if(twitter == null) {
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
