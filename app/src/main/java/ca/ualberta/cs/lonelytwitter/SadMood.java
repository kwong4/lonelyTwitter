package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

/**
 * Created by kwong4 on 9/13/16.
 */
public class SadMood extends Mood {

    public SadMood() {
        super();
    }

    public SadMood(Date date) {
        super(date);
    }

    public String currentMood() {
        return "Sad";
    }
}
