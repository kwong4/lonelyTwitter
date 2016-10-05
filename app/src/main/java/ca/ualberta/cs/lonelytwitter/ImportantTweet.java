package ca.ualberta.cs.lonelytwitter;

/**
 * Created by watts1 on 9/13/16.
 *
 * This is a subclass of Tweet. It is an ImportantTweet class
 * which is has an extended functionality of being important.
 * @author Kevin
 * @see Tweet
 */
public class ImportantTweet extends Tweet {

    /**
     * Instantiates a new Important tweet.
     *
     * @param message this parameter is the given string for the tweet. If it is set to empty
     *                string then it will be replaced by an empty string.
     */
    public ImportantTweet(String message){
        super(message);
    }

    /**
     * This function checks if the Tweet is important or not. It is.
     * @return Boolean.TRUE
     */
    @Override
    public Boolean isImportant(){
        return Boolean.TRUE;
    }

}
