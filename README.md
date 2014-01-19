# Twitterwall-Server

## Twitter OAuth configuration

This server needs an OAuth 'consumerKey' and 'consumerSecret' to authenticate against Twitter.
In order to provide these credentials, you can set environment variables or JVM system properties.

```Shell
$> gradle -Dtwitter4j.oauth.consumerKey=aabbccddeeffaabbccddee -Dtwitter4j.oauth.consumerSecret=aabbccddeeffaabbccddee11aabbccddeeddff2233 war jeyttyRunWar
```

Or

```Shell
$> export twitter4j.oauth.consumerKey=aabbccddeeffaabbccddee
$> export twitter4j.oauth.consumerSecret=aabbccddeeffaabbccddee11aabbccddeeddff2233
$> gradle war jettyRunWar
```

## Development

### Requirements

* Java JDK 1.7 (or newer)
* Gradle 1.9 (or newer)

### Building

````$> gradle war````

### Run development server

````$> gradle jettyRunWar````


## Continuous Integration

[![Build Status](https://travis-ci.org/hypoport/twitterwall-server.png?branch=master)](https://travis-ci.org/hypoport/twitterwall-server)
