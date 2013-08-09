package de.hypoport.twitterwall.twitter;

import org.springframework.stereotype.Component;
import twitter4j.*;
import twitter4j.conf.Configuration;
import twitter4j.conf.ConfigurationBuilder;
import twitter4j.conf.PropertyConfiguration;
import twitter4j.json.DataObjectFactory;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

@Component
public class TweetSearchService {

  private static final String consumerKey = System.getProperty("consumerKey");
  private static final String consumerSecret = System.getProperty("consumerSecret");

  public List<String> searchTweets(String searchQuery) throws TwitterException {
    Twitter twitter = new TwitterFactory(configure()).getInstance();
//    twitter.setOAuthConsumer(consumerKey, consumerSecret);
    twitter.getOAuth2Token();

    Query query = new Query(searchQuery);
    QueryResult searchResult = twitter.search(query);
    List<Status> tweetList = searchResult.getTweets();

    return convertToJsonStringList(tweetList);
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

  private List<String> convertToJsonStringList(List<Status> tweetList) {
    List<String> result = new ArrayList<String>(tweetList.size());
    for (Status tweet : tweetList) {
      result.add(DataObjectFactory.getRawJSON(tweet));
    }
    return result;
  }

  private void useProxy(ConfigurationBuilder builder) {
    builder.setHttpProxyHost("localhost");
    builder.setHttpProxyPort(3128);
  }
}
