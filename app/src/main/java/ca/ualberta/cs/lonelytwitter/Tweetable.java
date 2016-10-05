package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

/**
 * Created by watts1 on 9/13/16.
 *
 * This is an interface Tweetable which
 * has the functions getMessage which returns a String
 * and getDate which returns a Date.
 *
 * @author Kevin
 */
public interface Tweetable {
    /**
     * Gets the message attribute of the Tweet.
     *
     * @return the message of the Tweet.
     */
    public String getMessage();

    /**
     * Gets date attribute of the Tweet.
     *
     * @return the date of the Tweet
     */
    public Date getDate();
}
