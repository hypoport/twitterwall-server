package de.hypoport.twitterwall.twitter;

import twitter4j.Query;
import twitter4j.QueryResult;
import twitter4j.TwitterException;
import twitter4j.auth.AccessToken;

public interface TweetSearchService {

  QueryResult searchTweets(AccessToken accessToken, String queryString, String since, Long sinceId) throws TwitterException;

}
