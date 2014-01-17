package de.hypoport.twitterwall;

import de.hypoport.twitterwall.mapper.ResultMapper;
import de.hypoport.twitterwall.model.SearchResult;
import de.hypoport.twitterwall.twitter.TweetSearchService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import twitter4j.QueryResult;
import twitter4j.TwitterException;
import twitter4j.auth.AccessToken;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import java.util.logging.Level;
import java.util.logging.Logger;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@Controller
public class TweetSearchHttpController {

  @Inject
  TweetSearchService searchService;

  @Inject
  ResultMapper resultMapper;

  @RequestMapping(value = "/search", method = GET, produces = "application/json;charset=utf-8")
  @ResponseBody
  public SearchResult search(@RequestParam(required = true, value = "q") String search,
                             @RequestParam(required = false, value = "since") String since,
                             @RequestParam(required = false, value = "since_id") Long sinceId,
                             HttpServletRequest request) throws TwitterException, IllegalAccessException {
    SessionVisitor sessionVisitor = new SessionVisitor(request.getSession());
    AccessToken accessToken = null;
    if (sessionVisitor.hasAccessToken()) {
      accessToken = new AccessToken(sessionVisitor.loadAccessToken(), sessionVisitor.getAccessTokenSecret());
    }
    QueryResult queryResult = searchService.searchTweets(accessToken, search, since, sinceId);
    SearchResult searchResult = resultMapper.map(queryResult);
    return searchResult;
  }

  @ExceptionHandler(Exception.class)
  @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
  String handleException(Exception e) {
    return e.getMessage();
  }
}
