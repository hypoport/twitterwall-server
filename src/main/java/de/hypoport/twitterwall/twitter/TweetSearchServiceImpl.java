package de.hypoport.twitterwall.twitter;

import de.hypoport.twitterwall.config.TwitterConfiguration;
import org.springframework.stereotype.Component;
import twitter4j.Query;
import twitter4j.QueryResult;
import twitter4j.TwitterException;

import javax.inject.Inject;
import java.util.logging.Level;
import java.util.logging.Logger;

@Component
public class TweetSearchServiceImpl implements TweetSearchService {

  static Logger logger = Logger.getLogger(TweetSearchServiceImpl.class.getCanonicalName());

  @Inject
  TwitterConfiguration twitterConfiguration;
  @Inject
  TwitterService twitterService;
  @Inject
  TwitterMock twitterMock;

  @Override
  public QueryResult searchTweets(String queryString, String since, Long sinceId) throws TwitterException {

    logger.log(Level.FINE, "RAW SEARCH QUERY = '" + queryString + "'");

    QueryEnricher queryEnricher = new QueryEnricher().setQuery(queryString).setSince(since).setSinceId(sinceId);
    queryEnricher.setFromUsers(twitterConfiguration.getDefaultUsersForSearchQuery());

    Query query = queryEnricher.toQuery();
    logger.info("SEARCH QUERY = '" + query.getQuery() + "'");

    if (twitterConfiguration.isFullyConfigured()) {
      return twitterService.searchTweets(query);
    }
    return twitterMock.searchTweets(query);
  }

}
