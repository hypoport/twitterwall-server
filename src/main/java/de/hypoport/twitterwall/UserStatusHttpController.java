package de.hypoport.twitterwall;

import de.hypoport.twitterwall.config.TwitterConfiguration;
import de.hypoport.twitterwall.mapper.ResultMapper;
import de.hypoport.twitterwall.model.*;
import de.hypoport.twitterwall.twitter.TweetSearchService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import twitter4j.*;
import twitter4j.User;
import twitter4j.auth.AccessToken;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@Controller
public class UserStatusHttpController {

  @Inject
  TwitterConfiguration twitterConfiguration;

  @Inject
  ResultMapper resultMapper;

  @RequestMapping(value = "/showUser", method = GET, produces = "application/json;charset=utf-8")
  @ResponseBody
  public de.hypoport.twitterwall.model.User showUser(HttpServletRequest request) throws TwitterException{
    SessionVisitor sessionVisitor = new SessionVisitor(request.getSession());
    AccessToken accessToken = null;
    if (sessionVisitor.hasAccessToken()) {
      accessToken = new AccessToken(sessionVisitor.loadAccessToken(), sessionVisitor.getAccessTokenSecret());
      Twitter twitter = new TwitterFactory(twitterConfiguration.configure()).getInstance(accessToken);

      long twitterId = twitter.getId();
      User twitterUser = twitter.users().showUser(twitterId);
      return resultMapper.map(twitterUser);
    }
    return new de.hypoport.twitterwall.model.User();
  }

  @ExceptionHandler(Exception.class)
  @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
  String handleException(Exception e) {
    return e.getMessage();
  }
}
