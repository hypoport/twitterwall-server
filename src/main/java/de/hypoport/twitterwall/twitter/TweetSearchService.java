package de.hypoport.twitterwall.twitter;

import twitter4j.Query;
import twitter4j.QueryResult;
import twitter4j.TwitterException;

public interface TweetSearchService {

  QueryResult searchTweets(String queryString, String since, Long sinceId) throws TwitterException;

}
