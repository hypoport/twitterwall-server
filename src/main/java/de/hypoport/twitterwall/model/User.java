package de.hypoport.twitterwall.model;

public class User {

  private long id;
  private String name;
  private String screenName;
  private String location;
  private String description;
  private String profileImageUrlHttps;
  private String url;
  private int followersCount;

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getScreenName() {
    return screenName;
  }

  public void setScreenName(String screenName) {
    this.screenName = screenName;
  }

  public String getLocation() {
    return location;
  }

  public void setLocation(String location) {
    this.location = location;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public String getProfileImageUrlHttps() {
    return profileImageUrlHttps;
  }

  public void setProfileImageUrlHttps(String profileImageUrlHttps) {
    this.profileImageUrlHttps = profileImageUrlHttps;
  }

  public String getUrl() {
    return url;
  }

  public void setUrl(String url) {
    this.url = url;
  }

  public int getFollowersCount() {
    return followersCount;
  }

  public void setFollowersCount(int followersCount) {
    this.followersCount = followersCount;
  }
}
