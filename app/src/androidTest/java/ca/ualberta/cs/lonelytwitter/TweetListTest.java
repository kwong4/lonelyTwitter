package ca.ualberta.cs.lonelytwitter;

import android.test.ActivityInstrumentationTestCase2;

import java.util.Date;
import java.util.IllegalFormatException;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Created by Wookiez on 9/27/2016.
 *
 * Test cases for TweetLists.
 *
 * @author Kevin
 */
public class TweetListTest extends ActivityInstrumentationTestCase2<LonelyTwitterActivity> {
    /**
     * Instantiates a new Tweet list test.
     */
    public TweetListTest() {
        super (LonelyTwitterActivity.class);
    }

    /**
     * Test add tweet.
     * Adds a Tweet item into a TweetList and checks if it is there.
     */
    public void testAddTweet() {
        TweetList list = new TweetList();

        Tweet tweet = new NormalTweet("Hello!");
        list.add(tweet);
        assertTrue(list.hasTweet(tweet));
    }

    /**
     * Test has tweet.
     * Checks if a Tweet is in an empty TweetList and
     * adds a Tweet item into the TweetList and checks if it is there.
     */
    public void testHasTweet() {
        TweetList list = new TweetList();

        Tweet tweet = new NormalTweet("Hello!");

        assertFalse(list.hasTweet(tweet));
        list.add(tweet);
        assertTrue(list.hasTweet(tweet));
    }

    /**
     * Test get tweet.
     * Adds two Tweets to a TweetList, then compares the two tweets
     * by retrieving them from the TweetList.
     */
    public void testGetTweet() {
        TweetList list = new TweetList();

        Tweet a = new NormalTweet("Hello!");
        Tweet b = new NormalTweet("Hi!");

        list.add(a);
        list.add(b);

        assertEquals(list.getTweet(0), a);
        assertEquals(list.getTweet(1), b);
    }

    /**
     * Test delete tweet.
     * Adds a Tweet to a TweetList checks if it is there,
     * then deletes and checks if it is there.
     */
    public void testDeleteTweet() {
        TweetList list = new TweetList();

        Tweet a = new NormalTweet("Hello!");

        list.add(a);
        assertTrue(list.hasTweet(a));

        list.delete(a);
        assertFalse(list.hasTweet(a));
    }

    /**
     * Test add tweet 2.
     * Checks if adding the same Tweets to a TweetList will
     * throw a IllegalArgumentException.
     */
    public void testAddTweet2() {
        TweetList list = new TweetList();
        Tweet a = new NormalTweet("Hello!");
        try {
            list.addTweet(a);
            list.addTweet(a);
            fail();
        }
        catch (IllegalArgumentException e) {
        }
    }

    /**
     * Test get tweets.
     * Make two TweetLists, adds to both of them two Tweets in
     * different orders and checks if the getTweets returns
     * them in a sorted order by date.
     */
    public void testgetTweets() {
        TweetList list = new TweetList();
        TweetList list2 = new TweetList();

        Tweet a = new NormalTweet("Hello!");
        Tweet b = new NormalTweet("Hi!");
        a.setDate(new Date(1));
        list.addTweet(a);
        list.addTweet(b);
        list2.addTweet(b);
        list2.addTweet(a);
        List<Tweet> sortedlist = list.getTweets();
        List<Tweet> sortedlist2 = list2.getTweets();

        for (int i = 0; i < (sortedlist.size() - 1); i++) {
            assertTrue(sortedlist.get(i).getDate().compareTo(sortedlist.get(i + 1).getDate()) < 0);
        }
        for (int i = 0; i < (sortedlist2.size() - 1); i++) {
            assertTrue(sortedlist2.get(i).getDate().compareTo(sortedlist2.get(i + 1).getDate()) < 0);
        }
    }

    /**
     * Testhas tweet.
     * Creates a TweetList and 3 different Tweets.
     * Then adds 2 different Tweets and checks if
     * they are present.
     */
    public void testhasTweet() {
        TweetList list = new TweetList();

        Tweet a = new NormalTweet("Hello!");
        Tweet b = new NormalTweet("Hi!");
        Tweet c = new NormalTweet("Hi2!");
        list.addTweet(a);
        list.addTweet(b);
        assertEquals(list.hasTweet(c), false);
        assertEquals(list.hasTweet(a), true);
    }

    /**
     * Testremove tweet.
     * Creates a Tweetlist, adds two different Tweets, removes
     * a Tweet and checks the count and if it is there.
     */
    public void testremoveTweet() {
        TweetList list = new TweetList();

        Tweet a = new NormalTweet("Hello!");
        Tweet b = new NormalTweet("Hi!");
        list.addTweet(a);
        list.addTweet(b);
        list.removeTweet(a);
        assertEquals(list.getCount(), 1);
        assertEquals(list.hasTweet(a), false);
    }

    /**
     * Testget count.
     * Creates a TweetList, adds two different Tweets
     * and checks if the count returned is 2.
     */
    public void testgetCount() {
        TweetList list = new TweetList();

        Tweet a = new NormalTweet("Hello!");
        Tweet b = new NormalTweet("Hi!");
        list.addTweet(a);
        list.addTweet(b);
        assertEquals(list.getCount(), 2);
    }
}
