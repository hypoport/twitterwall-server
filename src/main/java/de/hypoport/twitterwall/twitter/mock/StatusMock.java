package de.hypoport.twitterwall.twitter.mock;

import twitter4j.*;

import java.io.Serializable;
import java.util.Date;

import static de.hypoport.twitterwall.twitter.mock.MockToolbox.MOCK_ID;
import static de.hypoport.twitterwall.twitter.mock.UserMockFactory.createRandomUser;

class StatusMock implements Status, Serializable {

  private long id;
  private final String text;
  private final String source;
  private UserMock user;

  public StatusMock(String text, String source) {
    this.id = MOCK_ID.getAndIncrement();
    this.text = text;
    this.source = source;
    this.user = createRandomUser();
  }

  @Override
  public Date getCreatedAt() {
    return new Date();
  }

  @Override
  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  @Override
  public String getText() {
    return text;
  }

  @Override
  public String getSource() {
    return source;
  }

  @Override
  public boolean isTruncated() {
    return false;
  }

  @Override
  public long getInReplyToStatusId() {
    return 0;
  }

  @Override
  public long getInReplyToUserId() {
    return 0;
  }

  @Override
  public String getInReplyToScreenName() {
    return null;
  }

  @Override
  public GeoLocation getGeoLocation() {
    return null;
  }

  @Override
  public Place getPlace() {
    return null;
  }

  @Override
  public boolean isFavorited() {
    return false;
  }

  @Override
  public boolean isRetweeted() {
    return false;
  }

  @Override
  public int getFavoriteCount() {
    return 0;
  }

  @Override
  public User getUser() {
    return user;
  }

  @Override
  public boolean isRetweet() {
    return false;
  }

  @Override
  public Status getRetweetedStatus() {
    return null;
  }

  @Override
  public long[] getContributors() {
    return new long[0];
  }

  @Override
  public int getRetweetCount() {
    return 0;
  }

  @Override
  public boolean isRetweetedByMe() {
    return false;
  }

  @Override
  public long getCurrentUserRetweetId() {
    return 0;
  }

  @Override
  public boolean isPossiblySensitive() {
    return false;
  }

  @Override
  public String getIsoLanguageCode() {
    return null;
  }

  @Override
  public int compareTo(Status o) {
    return 0;
  }

  @Override
  public UserMentionEntity[] getUserMentionEntities() {
    return new UserMentionEntity[0];
  }

  @Override
  public URLEntity[] getURLEntities() {
    return new URLEntity[0];
  }

  @Override
  public HashtagEntity[] getHashtagEntities() {
    return new HashtagEntity[0];
  }

  @Override
  public MediaEntity[] getMediaEntities() {
    return new MediaEntity[0];
  }

  @Override
  public SymbolEntity[] getSymbolEntities() {
    return new SymbolEntity[0];
  }

  @Override
  public RateLimitStatus getRateLimitStatus() {
    return null;
  }

  @Override
  public int getAccessLevel() {
    return 0;
  }

  public void setUser(UserMock user) {
    this.user = user;
  }
}
