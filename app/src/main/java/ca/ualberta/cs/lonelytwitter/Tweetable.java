package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

/**
 * Created by kwong4 on 9/13/16.
 */

//Often interfaces will have -able at the end which contains
//We can use interface to get certain functionalities
public interface Tweetable {
    public String getMessage();
    public Date getDate();

    public Boolean isImportant();
}
