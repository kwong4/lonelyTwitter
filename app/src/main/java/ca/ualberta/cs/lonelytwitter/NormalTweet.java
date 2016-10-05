package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

/**
 * Created by watts1 on 9/13/16.
 *
 * This is a subclass of Tweet. It is an NormalTweet class
 * which is has an extended functionality of not being important.
 *
 * @author Kevin
 * @see Tweet
 */
public class NormalTweet extends Tweet implements Tweetable {

    /**
     * This constructor makes a normalTweet with given String parameter
     * and the current Date.
     *
     * @param message this parameter is the given String for the tweet.
     */
    public NormalTweet(String message){
        super(message);
    }

    /**
     * Instantiates a new Normal tweet.
     *
     * @param message the message is the given String for the tweet.
     * @param date    the date is the given Date for the tweet
     */
    public NormalTweet(String message, Date date) {
        super(message, date);
    }

    /**
     * Checks if the Tweet is important or not. It is not.
     * @return Boolean.FALSE
     */
    @Override
    public Boolean isImportant() {
        return Boolean.FALSE;
    }
}
