package de.hypoport.twitterwall.mapper;

import de.hypoport.twitterwall.model.SearchResult;
import org.testng.annotations.Test;
import twitter4j.QueryResult;
import twitter4j.Status;
import twitter4j.User;

import java.util.Date;
import java.util.List;

import static com.google.common.collect.Lists.newArrayList;
import static org.fest.assertions.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ResultMapperTest {

  ResultMapper mapper = new ResultMapper();

  @Test
  public void mapping() throws Exception {
    QueryResult queryResult = createQueryResult();
    List<Status> tweets = newArrayList(createStatus());
    when(queryResult.getTweets()).thenReturn(tweets);

    // when
    SearchResult result = mapper.map(queryResult);

    // then
    assertThat(result).isNotNull();
    assertThat(result.getMaxId()).isEqualTo("9999999");
    assertThat(result.getCount()).isEqualTo(123);
    assertThat(result.getSinceId()).isEqualTo("55555");

    assertThat(result.getTweets()).hasSize(1);
    assertThat(result.getTweets().get(0).getId()).isEqualTo("44444444");
    assertThat(result.getTweets().get(0).getUser()).isNotNull();
    de.hypoport.twitterwall.model.User user = result.getTweets().get(0).getUser();
    assertThat(user.getName()).isEqualTo("Bozan");
    assertThat(user.getId()).isEqualTo(123123l);
  }

  private QueryResult createQueryResult() {
    QueryResult queryResult = mock(QueryResult.class);
    when(queryResult.getMaxId()).thenReturn(9999999l);
    when(queryResult.getCount()).thenReturn(123);
    when(queryResult.getSinceId()).thenReturn(55555l);
    return queryResult;
  }

  private Status createStatus() {
    Status status = mock(Status.class);
    when(status.getText()).thenReturn("Das ist ein Testtweet");
    when(status.getId()).thenReturn(44444444l);
    when(status.getCreatedAt()).thenReturn(new Date());
    User user = createUser();
    when(status.getUser()).thenReturn(user);
    return status;
  }

  private User createUser() {
    User user = mock(User.class);
    when(user.getName()).thenReturn("Bozan");
    when(user.getId()).thenReturn(123123l);
    return user;
  }
}
