package de.hypoport.twitterwall.twitter.mock;

import twitter4j.RateLimitStatus;
import twitter4j.Status;
import twitter4j.URLEntity;
import twitter4j.User;

import java.io.Serializable;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Date;

class UserMock implements User, Serializable {

  private final long id;
  private final String name;
  private final String screenName;
  private final String location;
  private final String description;
  private final String profileImageUrlHttps;
  private final String url;
  private final int followersCount;

  public UserMock(long id, String name, String screenName, String location, String description, String profileImageUrlHttps, String url, int followersCount) {
    this.id = id;
    this.name = name + " (Mock)";
    this.screenName = screenName;
    this.location = location;
    this.description = description;
    this.profileImageUrlHttps = profileImageUrlHttps;
    this.url = url;
    this.followersCount = followersCount;
  }

  @Override
  public long getId() {
    return id;
  }

  @Override
  public String getName() {
    return name;
  }

  @Override
  public String getScreenName() {
    return screenName;
  }

  @Override
  public String getLocation() {
    return location;
  }

  @Override
  public String getDescription() {
    return description;
  }

  @Override
  public boolean isContributorsEnabled() {
    return false;
  }

  @Override
  public String getProfileImageURL() {
    return null;
  }

  @Override
  public String getBiggerProfileImageURL() {
    return null;
  }

  @Override
  public String getMiniProfileImageURL() {
    return null;
  }

  @Override
  public String getOriginalProfileImageURL() {
    return null;
  }

  @Override
  public URL getProfileImageUrlHttps() {
    try {
      return new URL(profileImageUrlHttps);
    } catch (MalformedURLException e) {
      return null;
    }
  }

  @Override
  public String getProfileImageURLHttps() {
    return profileImageUrlHttps;
  }

  @Override
  public String getBiggerProfileImageURLHttps() {
    return null;
  }

  @Override
  public String getMiniProfileImageURLHttps() {
    return null;
  }

  @Override
  public String getOriginalProfileImageURLHttps() {
    return null;
  }

  @Override
  public String getURL() {
    return url;
  }

  @Override
  public boolean isProtected() {
    return false;
  }

  @Override
  public int getFollowersCount() {
    return followersCount;
  }

  @Override
  public Status getStatus() {
    return null;
  }

  @Override
  public String getProfileBackgroundColor() {
    return null;
  }

  @Override
  public String getProfileTextColor() {
    return null;
  }

  @Override
  public String getProfileLinkColor() {
    return null;
  }

  @Override
  public String getProfileSidebarFillColor() {
    return null;
  }

  @Override
  public String getProfileSidebarBorderColor() {
    return null;
  }

  @Override
  public boolean isProfileUseBackgroundImage() {
    return false;
  }

  @Override
  public boolean isShowAllInlineMedia() {
    return false;
  }

  @Override
  public int getFriendsCount() {
    return 0;
  }

  @Override
  public Date getCreatedAt() {
    return null;
  }

  @Override
  public int getFavouritesCount() {
    return 0;
  }

  @Override
  public int getUtcOffset() {
    return 0;
  }

  @Override
  public String getTimeZone() {
    return null;
  }

  @Override
  public String getProfileBackgroundImageUrl() {
    return null;
  }

  @Override
  public String getProfileBackgroundImageURL() {
    return null;
  }

  @Override
  public String getProfileBackgroundImageUrlHttps() {
    return null;
  }

  @Override
  public String getProfileBannerURL() {
    return null;
  }

  @Override
  public String getProfileBannerRetinaURL() {
    return null;
  }

  @Override
  public String getProfileBannerIPadURL() {
    return null;
  }

  @Override
  public String getProfileBannerIPadRetinaURL() {
    return null;
  }

  @Override
  public String getProfileBannerMobileURL() {
    return null;
  }

  @Override
  public String getProfileBannerMobileRetinaURL() {
    return null;
  }

  @Override
  public boolean isProfileBackgroundTiled() {
    return false;
  }

  @Override
  public String getLang() {
    return null;
  }

  @Override
  public int getStatusesCount() {
    return 0;
  }

  @Override
  public boolean isGeoEnabled() {
    return false;
  }

  @Override
  public boolean isVerified() {
    return false;
  }

  @Override
  public boolean isTranslator() {
    return false;
  }

  @Override
  public int getListedCount() {
    return 0;
  }

  @Override
  public boolean isFollowRequestSent() {
    return false;
  }

  @Override
  public URLEntity[] getDescriptionURLEntities() {
    return new URLEntity[0];
  }

  @Override
  public URLEntity getURLEntity() {
    return null;
  }

  @Override
  public int compareTo(User o) {
    return 0;
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
