package de.hypoport.twitterwall.twitter;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import twitter4j.TwitterException;

import java.util.List;

import static org.fest.assertions.Assertions.assertThat;


@Test
public class AuthenticatorTest {

  private Authenticator authenticator;

  @BeforeMethod
  public void setup() {
    authenticator = new Authenticator();
    authenticator.setConsumerKey(ladeAusEnvironmentVariablen("consumerKey"));
    authenticator.setConsumerSecret(ladeAusEnvironmentVariablen("consumerSecret"));
  }

  private String ladeAusEnvironmentVariablen(String envName) {
    String value = System.getenv(envName);
    if (value == null || value.isEmpty()) {
      throw new IllegalStateException("Das BearerToken muss als env-var '" + envName + "' gesetzt sein!");
    }
    return value;
  }

  @Test
  public void simple_Suche_mit_Bearer_token_auth() throws TwitterException {

    List html5 = authenticator.sucheTweets("html5");

    assertThat(html5).isNotEmpty();
  }
}
