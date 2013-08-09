package de.hypoport.twitterwall.twitter;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import twitter4j.TwitterException;

import java.util.List;

import static org.fest.assertions.Assertions.assertThat;


@Test
public class TweetSearchServiceTest {

  private TweetSearchService tweetSearchService;

  @BeforeMethod
  public void setup() {
    tweetSearchService = new TweetSearchService();
//    tweetSearchService.setConsumerKey(ladeAusEnvironmentVariablen("consumerKey"));
//    tweetSearchService.setConsumerSecret(ladeAusEnvironmentVariablen("consumerSecret"));
  }

  private String ladeAusEnvironmentVariablen(String envName) {
    String value = System.getenv(envName);
    if (value == null || value.isEmpty()) {
      throw new IllegalStateException("Das BearerToken muss als env-var '" + envName + "' gesetzt sein!");
    }
    return value;
  }

  @Test (enabled = false)
  public void simple_Suche_mit_ConsumerKey_und_ConsumerSecret_auth() throws TwitterException {

    List<String> tweets = tweetSearchService.searchTweets("html5");

    assertThat(tweets).isNotEmpty();
  }
}
