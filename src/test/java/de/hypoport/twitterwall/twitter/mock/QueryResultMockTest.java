package de.hypoport.twitterwall.twitter.mock;

import org.codehaus.jackson.map.ObjectMapper;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import twitter4j.Query;

import java.io.IOException;
import java.io.StringWriter;

public class QueryResultMockTest {

  private Query query;
  private QueryResultMock queryResult;

  @BeforeMethod
  public void setUp() throws Exception {
    query = new Query("test");
    queryResult = new QueryResultMock(query);
  }

  @Test
  public void JacksonMapper_is_able_to_serialize_mock_result() throws IOException {
    ObjectMapper mapper = new ObjectMapper(); // can reuse, share globally
    StringWriter writer = new StringWriter();

    //when
    mapper.writeValue(writer, queryResult);

    // then
    // no exception expected
  }

}
