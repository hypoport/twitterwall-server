package de.hypoport.twitterwall.twitter;

import de.hypoport.twitterwall.twitter.mock.QueryResultMock;
import org.springframework.stereotype.Component;
import twitter4j.Query;
import twitter4j.QueryResult;
import twitter4j.TwitterException;

@Component
class TwitterMock {

  public QueryResult searchTweets(Query query) throws TwitterException {
    return new QueryResultMock(query);
  }

}
