package de.hypoport.twitterwall;

import de.hypoport.twitterwall.config.TwitterConfiguration;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.auth.AccessToken;
import twitter4j.auth.RequestToken;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@Controller
public class AuthHttpController {

  public static final String DO_TWITTER_SIGN_IN = "/doTwitterSignIn";
  public static final String DO_TWITTER_CALLBACK = "/doTwitterCallback";

  @Inject
  TwitterConfiguration configuration;

  @RequestMapping(value = DO_TWITTER_SIGN_IN, method = GET)
  @ResponseBody
  public RedirectView doTwitterSignIn(HttpServletRequest request) throws TwitterException {

    Twitter twitter = new TwitterFactory().getInstance();

    String requestUrl = request.getRequestURL().toString();
    String callbackURL = requestUrl.substring(0, requestUrl.indexOf(DO_TWITTER_SIGN_IN)) + DO_TWITTER_CALLBACK;

    RequestToken requestToken = twitter.getOAuthRequestToken(callbackURL);
    new SessionVisitor(request.getSession()).saveRequestToken(requestToken.getToken());

    String url = requestToken.getAuthenticationURL();
    RedirectView redirectView = new RedirectView(url.toString());
    return redirectView;
  }

  @RequestMapping(value = DO_TWITTER_CALLBACK, method = GET)
  @ResponseBody
  public Object doTwitterCallback(@RequestParam(value = "oauth_token", required = false) String oauth_token,
                                  @RequestParam(value = "oauth_verifier", required = true) String oauth_verifier,
                                  HttpServletRequest request) throws TwitterException {

    SessionVisitor sessionVisitor = new SessionVisitor(request.getSession());
    if (sessionVisitor.hasRequestToken()) {
      Twitter twitter = new TwitterFactory().getInstance();
      RequestToken requestToken = new RequestToken(sessionVisitor.loadRequestToken(), "");
      AccessToken accessToken = twitter.getOAuthAccessToken(requestToken, oauth_verifier);
      sessionVisitor.saveAccessToken(accessToken.getToken());
      sessionVisitor.saveAccessTokenSecret(accessToken.getTokenSecret());
    }

    RedirectView redirectView = new RedirectView("/");
    return redirectView;
  }

  @ExceptionHandler(TwitterException.class)
  @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
  RedirectView handleTwitterException(TwitterException e) throws UnsupportedEncodingException {
    return new RedirectView("error.html#" + URLEncoder.encode(e.getMessage(), "ASCII"));
  }

  @ExceptionHandler(Exception.class)
  @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
  String handleException(Exception e) {
    return e.getMessage();
  }

}
