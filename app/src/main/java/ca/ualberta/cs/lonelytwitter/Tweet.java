package ca.ualberta.cs.lonelytwitter;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by watts1 on 9/13/16.
 *
 * This is the main class Tweet which holds
 * a String message and Date date attributes.
 *
 * @author Kevin
 */
public abstract class Tweet  implements Comparable<Tweet>, Serializable{
    private String message;
    private Date date;

    /**
     * Instantiates a new Tweet with the given String message and
     * current Date.
     *
     * @param message the message is the given String for the tweet.
     */
    public Tweet(String message){
        this.message = message;
        this.date = new Date();
    }

    /**
     * Instantiates a new Tweet with the given String message and
     * given Date.
     *
     * @param message the message is the given String for the tweet.
     * @param date    the date is the given Date for the tweet.
     */
    public Tweet(String message, Date date){
        this.message = message;
        this.date = date;
    }


    /**
     * Is important boolean. Checks if the Tweet is important.
     *
     * @return the boolean
     */
    public abstract Boolean isImportant();


    /**
     * Sets the message attribute of a Tweet.
     *
     * @param message the message is the given message for the Tweet.
     * @throws TweetTooLongException the tweet too long exception
     */
    public void setMessage(String message) throws TweetTooLongException {
        if (message.length() > 140) {
            //Do something
            throw new TweetTooLongException();
        }
        this.message = message;
    }

    /**
     * Sets the date attribute of a Tweet.
     *
     * @param date the date is the given date for the Tweet.
     */
    public void setDate(Date date) {
        this.date = date;
    }

    /**
     * Gets message attribute of a Tweet.
     *
     * @return the message is the given message for the Tweet.
     */
    public String getMessage() {
        return message;
    }

    /**
     * Gets date attribute of a Tweet.
     *
     * @return the date is the given date for the Tweet.
     */
    public Date getDate() {
        return date;
    }

    /**
     * Converts the date and message attribute of a tweet to a one line String.
     * @return String which is the "date | message"
     */
    @Override
    public String toString(){
        return  date.toString() + " | " + message;
    }

    /**
     * Returns a compareTo of the tweet and of the given param
     * @param tweet is the Tweet in which it will be compared to
     * @return int 0 (equal), 1 (greater than), or -1 (less than) based on compared dates.
     */
    public int compareTo(Tweet tweet) {
        return this.date.compareTo(tweet.date);
    }
}
