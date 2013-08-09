package de.hypoport.twitterwall;


import de.hypoport.twitterwall.twitter.TweetSearchService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import twitter4j.Status;
import twitter4j.TwitterException;

import javax.inject.Inject;
import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@Controller
public class TweetSearchController {

  @Inject
  TweetSearchService searchService;

  @RequestMapping(value = "/search", method = GET, produces = {"application/json", "text/plain"})
  public
  @ResponseBody
  List<Status> search(@RequestParam(required = true, value = "q") String query) throws TwitterException {
    return searchService.searchTweets(query);
  }

  @ExceptionHandler(Exception.class)
  @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
  String handleException(TwitterException twex) {
    return twex.getErrorMessage();
  }
}
