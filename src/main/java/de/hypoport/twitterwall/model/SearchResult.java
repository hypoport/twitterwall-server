package de.hypoport.twitterwall.model;

import twitter4j.Status;

import java.util.List;

public class SearchResult {

  private String sinceId;
  private String maxId;
  private int count;
  private double completedIn;
  private String query;
  private List<Tweet> tweets;

  public String getSinceId() {
    return sinceId;
  }

  public void setSinceId(String sinceId) {
    this.sinceId = sinceId;
  }

  public String getMaxId() {
    return maxId;
  }

  public void setMaxId(String maxId) {
    this.maxId = maxId;
  }

  public int getCount() {
    return count;
  }

  public void setCount(int count) {
    this.count = count;
  }

  public double getCompletedIn() {
    return completedIn;
  }

  public void setCompletedIn(double completedIn) {
    this.completedIn = completedIn;
  }

  public String getQuery() {
    return query;
  }

  public void setQuery(String query) {
    this.query = query;
  }

  public List<Tweet> getTweets() {
    return tweets;
  }

  public void setTweets(List<Tweet> tweets) {
    this.tweets = tweets;
  }
}
