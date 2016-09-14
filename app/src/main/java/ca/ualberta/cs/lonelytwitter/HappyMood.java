package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

/**
 * Created by kwong4 on 9/13/16.
 */
public class HappyMood extends Mood {

    public HappyMood() {
        super();
    }

    public HappyMood(Date date){
        super(date);
    }

    public String currentMood() {
        return "Happy";
    }
}
