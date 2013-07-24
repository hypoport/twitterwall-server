package de.hypoport.twitterwall.twitter;

import twitter4j.*;
import twitter4j.conf.ConfigurationBuilder;

import java.util.List;

public class Authenticator {

  private String consumerKey;
  private String consumerSecret;

  public List sucheTweets(String searchQuery) throws TwitterException {
    ConfigurationBuilder builder = new ConfigurationBuilder();
    builder.setUseSSL(true);
    builder.setApplicationOnlyAuthEnabled(true);
    Twitter twitter = new TwitterFactory(builder.build()).getInstance();
    twitter.setOAuthConsumer(consumerKey, consumerSecret);
    twitter.getOAuth2Token();

    Query query = new Query(searchQuery);
    QueryResult result = twitter.search(query);

    return result.getTweets();
  }

  public void setConsumerKey(String consumerKey) {
    this.consumerKey = consumerKey;
  }

  public void setConsumerSecret(String consumerSecret) {
    this.consumerSecret = consumerSecret;
  }
}
