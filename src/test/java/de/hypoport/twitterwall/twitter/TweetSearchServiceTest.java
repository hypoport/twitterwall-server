package de.hypoport.twitterwall.twitter;

import com.google.common.base.Optional;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import twitter4j.Query;
import twitter4j.QueryResult;
import twitter4j.Status;
import twitter4j.TwitterException;

import java.util.List;

import static org.fest.assertions.Assertions.assertThat;


@Test
public class TweetSearchServiceTest {

  private TweetSearchService tweetSearchService;

  @BeforeMethod
  public void setup() {
    tweetSearchService = new TweetSearchService();
  }

  @Test (enabled = false)
  public void simple_Suche_mit_ConsumerKey_und_ConsumerSecret_auth() throws TwitterException {

    QueryResult queryResult = tweetSearchService.searchTweets(new Query("html5"));

    assertThat(queryResult).isNotNull();
    assertThat(queryResult.getTweets()).isNotEmpty();
  }
}
