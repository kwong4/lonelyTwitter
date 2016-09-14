package ca.ualberta.cs.lonelytwitter;

/**
 * Created by kwong4 on 9/13/16.
 */
public class ImportantTweet extends Tweet {

    //Super calls constructor from
    public ImportantTweet(String message) {
        super(message);
    }

    //Overriding parent's class
    //Don't actually need the @Override - just a notification.

    @Override
    public Boolean isImportant() {
        return Boolean.TRUE;
    }
}
