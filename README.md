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

You can grab these credentials for your own from Twitter's dev site https://dev.twitter.com.
Create a new Twitter application there and follow these steps:

1. Name -> provide a simple name
2. Description -> obvious ;-)
3. Website -> put in some valid site there (can also be a blog or something)
4. Application Type -> Read only
5. Callback URL -> http://example.com  (important: don't leave this field empty! The callback URL actually used is overwritten at runtime)
6. Allow this application to be used to Sign in with Twitter -> Check
7. done.

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
