package ca.ualberta.cs.lonelytwitter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by Wookiez on 9/27/2016.
 */
public class TweetList {
    List<Tweet> tweets = new ArrayList<Tweet>();
    public void add(Tweet tweet) {
        tweets.add(tweet);
    }

    public Tweet getTweet(int i) {
        return tweets.get(i);
    }

    public void delete(Tweet a) {
        tweets.remove(a);
    }

    public void addTweet(Tweet tweet) {
        if (tweets.contains(tweet)) {
            throw new IllegalArgumentException("Duplicate Tweet being added.");
        }
        tweets.add(tweet);
    }

    public List<Tweet> getTweets() {
        ArrayList<Tweet> temptweets = new ArrayList<Tweet>(tweets);
        Collections.sort(temptweets, new Comparator<Tweet>() {
            public int compare(Tweet o1, Tweet o2) {
                return o1.getDate().compareTo(o2.getDate());
            }
        });
        return temptweets;
    }

    public boolean hasTweet(Tweet tweet) {
        return tweets.contains(tweet);
    }

    public void removeTweet(Tweet tweet) {
        tweets.remove(tweet);
    }

    public int getCount() {
        return tweets.size();
    }

}
