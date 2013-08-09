package de.hypoport.twitterwall;


import de.hypoport.twitterwall.twitter.TweetSearchService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
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
  List<String> search(@RequestParam(required = true, value = "q") String query) throws TwitterException {

    List<String> strings = searchService.searchTweets(query);

    return strings;
  }

  @ExceptionHandler(TwitterException.class)
  void handleException(TwitterException tex) {


  }


}
