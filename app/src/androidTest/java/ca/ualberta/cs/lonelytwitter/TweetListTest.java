package ca.ualberta.cs.lonelytwitter;

import android.test.ActivityInstrumentationTestCase2;

import java.util.Date;
import java.util.IllegalFormatException;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Created by Wookiez on 9/27/2016.
 */
public class TweetListTest extends ActivityInstrumentationTestCase2<LonelyTwitterActivity> {
    public TweetListTest() {
        super (LonelyTwitterActivity.class);
    }
    public void testAddTweet() {
        TweetList list = new TweetList();

        Tweet tweet = new NormalTweet("Hello!");
        list.add(tweet);
        assertTrue(list.hasTweet(tweet));
    }

    public void testHasTweet() {
        TweetList list = new TweetList();

        Tweet tweet = new NormalTweet("Hello!");

        assertFalse(list.hasTweet(tweet));
        list.add(tweet);
        assertTrue(list.hasTweet(tweet));
    }

    public void testGetTweet() {
        TweetList list = new TweetList();

        Tweet a = new NormalTweet("Hello!");
        Tweet b = new NormalTweet("Hi!");

        list.add(a);
        list.add(b);

        assertEquals(list.getTweet(0), a);
        assertEquals(list.getTweet(1), b);
    }

    public void testDeleteTweet() {
        TweetList list = new TweetList();

        Tweet a = new NormalTweet("Hello!");

        list.add(a);
        assertTrue(list.hasTweet(a));

        list.delete(a);
        assertFalse(list.hasTweet(a));
    }

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

    public void testgetCount() {
        TweetList list = new TweetList();

        Tweet a = new NormalTweet("Hello!");
        Tweet b = new NormalTweet("Hi!");
        list.addTweet(a);
        list.addTweet(b);
        assertEquals(list.getCount(), 2);
    }
}
