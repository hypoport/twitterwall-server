package de.hypoport.twitterwall.twitter;

import de.hypoport.twitterwall.config.TwitterConfiguration;
import org.springframework.stereotype.Component;
import twitter4j.*;
import twitter4j.auth.AccessToken;
import twitter4j.conf.Configuration;
import twitter4j.conf.ConfigurationBuilder;

import javax.inject.Inject;
import java.util.logging.Level;
import java.util.logging.Logger;

@Component
public class TweetSearchServiceImpl implements TweetSearchService {

  static Logger logger = Logger.getLogger(TweetSearchServiceImpl.class.getCanonicalName());

  @Inject
  TwitterConfiguration twitterConfiguration;

  @Inject
  TwitterMock twitterMock;

  @Override
  public QueryResult searchTweets(AccessToken accessToken, String queryString, String since, Long sinceId) throws TwitterException {

    logger.log(Level.FINE, "RAW SEARCH QUERY = '" + queryString + "'");

    QueryEnricher queryEnricher = new QueryEnricher().setQuery(queryString).setSince(since).setSinceId(sinceId);
    queryEnricher.setFromUsers(twitterConfiguration.getDefaultUsersForSearchQuery());

    Query query = queryEnricher.toQuery();
    logger.info("SEARCH QUERY = '" + query.getQuery() + "'");

    if (accessToken != null && twitterConfiguration.isFullyConfigured()) {
      Twitter twitter = new TwitterFactory(twitterConfiguration.configure()).getInstance(accessToken);
      return twitter.search(query);
    } else {
      logger.info("No ACCESS_TOKEN found, will return Mock data now ;-)");
    }
    return twitterMock.searchTweets(query);
  }

}
