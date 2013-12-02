package de.hypoport.twitterwall.twitter.mock;

import java.util.Random;
import java.util.concurrent.atomic.AtomicLong;

public class MockToolbox {

  public static final AtomicLong MOCK_ID = new AtomicLong(System.currentTimeMillis());

  public final static Random RANDOM = new Random();

  static {
    RANDOM.setSeed(System.currentTimeMillis());
  }

}
