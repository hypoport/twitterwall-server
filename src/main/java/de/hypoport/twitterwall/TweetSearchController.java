package de.hypoport.twitterwall;


import com.google.common.base.Optional;
import de.hypoport.twitterwall.twitter.TweetSearchService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import twitter4j.Status;
import twitter4j.TwitterException;

import javax.inject.Inject;
import java.util.List;

import static com.google.common.base.Optional.fromNullable;
import static org.springframework.web.bind.annotation.RequestMethod.GET;

@Controller
public class TweetSearchController {

  @Inject
  TweetSearchService searchService;

  @RequestMapping(value = "/search", method = GET, produces = {"application/json", "text/plain"})
  public
  @ResponseBody
  List<Status> search(@RequestParam(required = true, value = "q") String query,
                      @RequestParam(required = false, value = "since_id") Long sinceId,
                      @RequestParam(required = false, value = "since") String since) throws TwitterException {
    return searchService.searchTweets(query, fromNullable(since), fromNullable(sinceId));
  }

  @ExceptionHandler(Exception.class)
  @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
  String handleException(TwitterException twex) {
    return twex.getErrorMessage();
  }
}
