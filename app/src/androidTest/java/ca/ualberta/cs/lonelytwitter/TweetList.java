package ca.ualberta.cs.lonelytwitter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Wookiez on 9/27/2016.
 */
public class TweetList {
    List<Tweet> tweets = new ArrayList<Tweet>();
    public void add(Tweet tweet) {
        tweets.add(tweet);
    }
    public boolean hasTweet(Tweet tweet) {
        return tweets.contains(tweet);
    }

    public Tweet getTweet(int i) {
        return tweets.get(i);
    }

    public void delete(Tweet a) {
    }
}
