package de.hypoport.twitterwall.twitter;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import twitter4j.Query;

import static org.fest.assertions.Assertions.assertThat;

public class QueryEnricherTest {

  private static final String SEARCHTERM = "searchterm";

  private QueryEnricher enricher;

  @BeforeMethod
  public void setUp() throws Exception {
    enricher = new QueryEnricher();
    enricher.setQuery(SEARCHTERM);
  }

  @Test
  public void enrich_a_single_term_with_additionally_hashtagged_term() {
    Query query = enricher.toQuery();

    assertThat(query.getQuery()).contains(SEARCHTERM);
    assertThat(query.getQuery()).contains(" OR #" + SEARCHTERM);
  }

  @Test
  public void enrich_a_single_term_with_given_users() {
    enricher.setFromUsers("foo", "bar");

    Query query = enricher.toQuery();

    assertThat(query.getQuery()).contains(" OR from:foo");
    assertThat(query.getQuery()).contains(" OR from:bar");
  }
}
