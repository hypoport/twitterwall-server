package de.hypoport.twitterwall.twitter.mock;

import twitter4j.Query;
import twitter4j.QueryResult;
import twitter4j.RateLimitStatus;
import twitter4j.Status;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import static de.hypoport.twitterwall.twitter.mock.MockToolbox.MOCK_ID;
import static de.hypoport.twitterwall.twitter.mock.MockToolbox.RANDOM;
import static de.hypoport.twitterwall.twitter.mock.StatusMockFactory.createRandomStatus;
import static java.lang.Math.max;
import static java.lang.Math.min;

public class QueryResultMock implements QueryResult, Serializable {

  private final Query query;
  private final List<Status> tweets;

  public QueryResultMock(Query query) {
    this.query = query;
    this.tweets = createRandomStatuses();
  }

  private List<Status> createRandomStatuses() {
    List<Status> result = new ArrayList<>();
    for (int i = 0, len = (7 + RANDOM.nextInt(7)); i < len; i++) {
      StatusMock statusMock = createRandomStatus();
      statusMock.setUser(UserMockFactory.createRandomUser());
      statusMock.setId(MOCK_ID.getAndIncrement());
      result.add(statusMock);
    }
    return result;
  }

  @Override
  public long getSinceId() {
    long sinceId = query.getSinceId();
    for (Status tweet : tweets) {
      sinceId = min(sinceId, tweet.getId());
    }
    return sinceId;
  }

  @Override
  public long getMaxId() {
    long maxId = 0;
    for (Status tweet : tweets) {
      maxId = max(maxId, tweet.getId());
    }
    return maxId;
  }

  @Override
  public String getRefreshUrl() {
    return null;
  }

  @Override
  public String getRefreshURL() {
    return null;
  }

  @Override
  public int getCount() {
    return tweets.size();
  }

  @Override
  public double getCompletedIn() {
    return 0.022;
  }

  @Override
  public String getQuery() {
    return query.getQuery();
  }

  @Override
  public List<Status> getTweets() {
    return tweets;
  }

  @Override
  public Query nextQuery() {
    return null;
  }

  @Override
  public boolean hasNext() {
    return false;
  }

  @Override
  public RateLimitStatus getRateLimitStatus() {
    return null;
  }

  @Override
  public int getAccessLevel() {
    return 0;
  }

}
