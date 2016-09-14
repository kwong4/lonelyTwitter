package ca.ualberta.cs.lonelytwitter;

/**
 * Created by kwong4 on 9/13/16.
 */

//Can't extends or inherit multiple classes. So we are going to implement it
public class NormalTweet extends Tweet implements Tweetable{

    public NormalTweet(String message) {
        super(message);
    }

    @Override
    public Boolean isImportant() {
        return Boolean.FALSE;
    }
}
