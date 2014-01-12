package de.hypoport.twitterwall.twitter;

import twitter4j.Query;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class QueryEnricher {

  private String[] fromUsers;
  private String query;
  private String since;
  private Long sinceId;

  public Query toQuery() {
    List<String> terms = new ArrayList<>();
    for (String t : query.split("\\s")) {
      if (!t.isEmpty()) {
        terms.add(t);
        if (!t.startsWith("#")) terms.add("#" + t);
      }
    }

    if (fromUsers != null) {
      for (String user : fromUsers) {
        terms.add("from:" + user);
      }
    }

    Query q = new Query(stringifyORs(terms));
    if (since != null) q.setSince(since);
    if (sinceId != null) q.setSinceId(sinceId);
    return q;
  }

  private String stringifyORs(Collection<String> terms) {
    StringBuilder sb = new StringBuilder();
    for (String term : terms) {
      if (sb.length() > 0) sb.append(" OR ");
      sb.append(term);
    }
    return sb.toString();
  }

  public void setFromUsers(String... users) {
    this.fromUsers = users;
  }

  public String getQuery() {
    return query;
  }

  public QueryEnricher setQuery(String query) {
    this.query = query;
    return this;
  }

  public String getSince() {
    return since;
  }

  public QueryEnricher setSince(String since) {
    this.since = since;
    return this;
  }

  public Long getSinceId() {
    return sinceId;
  }

  public QueryEnricher setSinceId(Long sinceId) {
    this.sinceId = sinceId;
    return this;
  }

}
