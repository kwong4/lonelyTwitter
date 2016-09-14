package ca.ualberta.cs.lonelytwitter;

import java.util.ArrayList;
import java.util.Date;

/**
 * Created by kwong4 on 9/13/16.
 */
public abstract class Tweet {
    private String message;
    private Date date;
    private ArrayList<Mood> moodlist = new ArrayList<Mood>();

    public Tweet(String message) {
        this.message = message;
    }

    // Polymorphism
    public Tweet(String message, Date date) {
        this.message = message;
        this.date = date;
    }

    //Can't use the above to modify the values of message and date

    //Now we make an abstract parent which forces all children classes to have that method.
    //If you have abstract method - must have abstract main class in title of class
    public abstract Boolean isImportant();

    //You can use the below to set the attributes

    //Add throws so you can let the function knows it is going to handle/throw an exception
    public void setMessage(String message) throws TweetTooLongException {
        if (message.length() > 140) {
            //Do something
            throw new TweetTooLongException();
        }
        this.message = message;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getMessage() {
        return message;
    }

    public Date getDate() {
        return date;
    }

    public void addMood(Mood mood) {
        this.moodlist.add(mood);
    }
}
