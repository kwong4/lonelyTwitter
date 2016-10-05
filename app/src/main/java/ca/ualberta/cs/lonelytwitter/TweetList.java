package ca.ualberta.cs.lonelytwitter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by Wookiez on 9/27/2016.
 *
 * This is a TweetList class which has a List containing
 * Tweets.
 *
 * @author Kevin
 * @see Tweet
 *
 */
public class TweetList {
    /**
     * A List of tweets that holds the tweets.
     */
    List<Tweet> tweets = new ArrayList<Tweet>();

    /**
     * To add a Tweet into tweets attribute.
     *
     * @param tweet the Tweet which is to be added to the TweetList.
     */
    public void add(Tweet tweet) {
        tweets.add(tweet);
    }

    /**
     * Gets the Tweet from the tweets attribute.
     *
     * @param i the index of the corresponding tweet you wish to get.
     * @return the Tweet from TweetList tweets attribute of the given index.
     */
    public Tweet getTweet(int i) {
        return tweets.get(i);
    }

    /**
     * Deletes the Tweet from the tweets attribute.
     *
     * @param a the Tweet instance in which you wish to remove from
     *          the TweetList tweets attribute.
     */
    public void delete(Tweet a) {
        tweets.remove(a);
    }

    /**
     * Add tweet to the tweets attribute.
     *
     * @param tweet the Tweet instance in which you wish to add to
     *              the TweetList tweets attribute.
     */
    public void addTweet(Tweet tweet) {
        if (tweets.contains(tweet)) {
            throw new IllegalArgumentException("Duplicate Tweet being added.");
        }
        tweets.add(tweet);
    }

    /**
     * Gets the tweets attribute from the TweetList.
     *
     * @return the tweets attribute from the TweetList.
     */
    public List<Tweet> getTweets() {
        ArrayList<Tweet> temptweets = new ArrayList<Tweet>(tweets);
        Collections.sort(temptweets, new Comparator<Tweet>() {
            public int compare(Tweet o1, Tweet o2) {
                return o1.getDate().compareTo(o2.getDate());
            }
        });
        return temptweets;
    }

    /**
     * Checks if the given tweet is in the TweetList.
     *
     * @param tweet the Tweet to be check if inside the TweetList.
     * @return the boolean return if the Tweet is in the TweetList.
     */
    public boolean hasTweet(Tweet tweet) {
        return tweets.contains(tweet);
    }

    /**
     * Remove the given tweet from the TweetList.
     *
     * @param tweet the Tweet which will be removed from TweetList.
     */
    public void removeTweet(Tweet tweet) {
        tweets.remove(tweet);
    }

    /**
     * Gets the Count of the Tweets in TweetList.
     *
     * @return an int of the number of Tweets in the TweetList.
     */
    public int getCount() {
        return tweets.size();
    }

}
