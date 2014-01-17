package de.hypoport.twitterwall.mapper;

import com.google.common.base.Function;
import de.hypoport.twitterwall.model.SearchResult;
import de.hypoport.twitterwall.model.Tweet;
import org.springframework.stereotype.Component;
import twitter4j.AccountSettings;
import twitter4j.QueryResult;
import twitter4j.Status;
import twitter4j.User;

import java.util.List;

import static com.google.common.collect.Lists.transform;
import static java.lang.String.valueOf;

@Component
public class ResultMapper {
  public SearchResult map(QueryResult queryResult) {
    SearchResult searchResult = new SearchResult();
    searchResult.setCompletedIn(queryResult.getCompletedIn());
    searchResult.setCount(queryResult.getCount());
    searchResult.setMaxId(valueOf(queryResult.getMaxId()));
    searchResult.setQuery(queryResult.getQuery());
    searchResult.setSinceId(valueOf(queryResult.getSinceId()));
    List<Status> tweets = queryResult.getTweets();
    searchResult.setTweets(map(tweets));
    return searchResult;
  }

  private List<Tweet> map(List<Status> tweets) {
    return transform(tweets, new Function<Status, Tweet>() {
      @Override
      public Tweet apply(Status input) {
        Tweet tweet = new Tweet();
        tweet.setCreatedAt(input.getCreatedAt());
        tweet.setId(valueOf(input.getId()));
        tweet.setSource(input.getSource());
        tweet.setText(input.getText());
        tweet.setUser(map(input.getUser()));
        return tweet;
      }
    });
  }

  public de.hypoport.twitterwall.model.User map(User twitterUser) {
    de.hypoport.twitterwall.model.User user = new de.hypoport.twitterwall.model.User();
    user.setDescription(twitterUser.getDescription());
    user.setFollowersCount(twitterUser.getFollowersCount());
    user.setId(twitterUser.getId());
    user.setLocation(twitterUser.getLocation());
    user.setName(twitterUser.getName());
    user.setScreenName(twitterUser.getScreenName());
    user.setProfileImageUrlHttps(twitterUser.getProfileImageURLHttps());
    user.setUrl(twitterUser.getURL());
    return user;
  }

}
