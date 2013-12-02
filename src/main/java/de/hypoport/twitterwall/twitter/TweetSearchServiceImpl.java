package de.hypoport.twitterwall.twitter;

import de.hypoport.twitterwall.config.TwitterConfiguration;
import org.springframework.stereotype.Component;
import twitter4j.Query;
import twitter4j.QueryResult;
import twitter4j.TwitterException;

import javax.inject.Inject;

@Component
public class TweetSearchServiceImpl implements TweetSearchService {

  @Inject
  TwitterConfiguration twitterConfiguration;
  @Inject
  TwitterService twitterService;
  @Inject
  TwitterMock twitterMock;

  @Override
  public QueryResult searchTweets(Query query) throws TwitterException {
    if (twitterConfiguration.isFullyConfigured()) {
      return twitterService.searchTweets(query);
    }
    return twitterMock.searchTweets(query);
  }
}
