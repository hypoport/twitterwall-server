package de.hypoport.twitterwall.twitter;

import de.hypoport.twitterwall.config.TwitterConfiguration;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import twitter4j.QueryResult;
import twitter4j.TwitterException;
import twitter4j.auth.AccessToken;

import java.util.logging.Logger;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class TweetSearchServiceImplTest {

  private TweetSearchServiceImpl tweetSearchService;

  @BeforeMethod
  public void setup() {
    TweetSearchServiceImpl.logger = mock(Logger.class);

    tweetSearchService = new TweetSearchServiceImpl();
    tweetSearchService.twitterConfiguration = mock(TwitterConfiguration.class);
    tweetSearchService.twitterMock = mock(TwitterMock.class);
  }

  @Test()
  public void simple_search_without_AccessToken_uses_the_TwitterMock() throws TwitterException {

    QueryResult queryResult = tweetSearchService.searchTweets(null, "html5", null, null);

    verify(tweetSearchService.twitterMock).searchTweets(any(twitter4j.Query.class));
  }
}
