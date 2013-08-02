package de.hypoport.twitterwall.twitter;

import twitter4j.*;
import twitter4j.conf.ConfigurationBuilder;
import twitter4j.json.DataObjectFactory;

import java.util.ArrayList;
import java.util.List;

public class TweetSearchService {

  private String consumerKey;
  private String consumerSecret;

  public List<String> searchTweets(String searchQuery) throws TwitterException {
    ConfigurationBuilder builder = new ConfigurationBuilder();
    builder.setUseSSL(true);
    builder.setJSONStoreEnabled(true);
    useProxy(builder);
    builder.setApplicationOnlyAuthEnabled(true);
    Twitter twitter = new TwitterFactory(builder.build()).getInstance();
    twitter.setOAuthConsumer(consumerKey, consumerSecret);
    twitter.getOAuth2Token();

    Query query = new Query(searchQuery);
    QueryResult searchResult = twitter.search(query);
    List<Status> tweetList = searchResult.getTweets();

    return convertToJsonStringList(tweetList);
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

  public void setConsumerKey(String consumerKey) {
    this.consumerKey = consumerKey;
  }

  public void setConsumerSecret(String consumerSecret) {
    this.consumerSecret = consumerSecret;
  }
}
