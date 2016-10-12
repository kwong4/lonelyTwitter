package ca.ualberta.cs.lonelytwitter;

import android.app.Activity;
import android.test.ActivityInstrumentationTestCase2;
import android.util.Log;
import android.widget.EditText;
import android.widget.ListView;

import com.robotium.solo.Solo;

import junit.framework.TestCase;

/**
 * Created by wz on 14/09/15.
 *
 * Used to run the tests on LonelyTwitterActivity.
 *
 * @author Kevin
 */
public class LonelyTwitterActivityTest extends ActivityInstrumentationTestCase2<LonelyTwitterActivity> {

    private Solo solo;
    /**
     * Instantiates a new Lonely twitter activity test.
     */
    public LonelyTwitterActivityTest() {
        super(ca.ualberta.cs.lonelytwitter.LonelyTwitterActivity.class);
    }

    /**
     * Test start.
     *
     * @throws Exception the exception
     */
    public void testStart() throws Exception {
        Activity activity = getActivity();
    }

    public void setUp() throws Exception{
        Log.d("TAG1", "setUp()");
        solo = new Solo(getInstrumentation(),getActivity());
    }

    public void testTweet(){
        solo.assertCurrentActivity("Wrong Activity", LonelyTwitterActivity.class);

        solo.enterText((EditText) solo.getView(R.id.body), "Test Tweet!");
        solo.clickOnButton("Save");

        solo.clearEditText((EditText) solo.getView(R.id.body));
        assertTrue(solo.waitForText("Test Tweet!"));

        solo.clickOnButton("Clear");
        assertFalse(solo.waitForText("Test Tweet!"));
    }

    public void testClickTweetList(){
        LonelyTwitterActivity activity = (LonelyTwitterActivity) solo.getCurrentActivity();
        solo.assertCurrentActivity("Wrong Activity", LonelyTwitterActivity.class);
        solo.clickOnButton("Clear");

        solo.enterText((EditText) solo.getView(R.id.body), "Test Tweet!");
        solo.clickOnButton("Save");
        solo.waitForText("Test Tweet!");

        solo.enterText((EditText) solo.getView(R.id.body), "Test Tweet2!");
        solo.clickOnButton("Save");
        solo.waitForText("Test Tweet2!");

        final ListView oldTweetsList = activity.getOldTweetsList();
        Tweet tweet = (Tweet) oldTweetsList.getItemAtPosition(0);
        assertEquals("Test Tweet!", tweet.getMessage());

        //Not too sure why, but this is list #2 instead of index of 1.
        solo.clickInList(2);

        solo.assertCurrentActivity("Wrong Activity", EditTweetActivity.class);

        //Lab Exercise Code
        EditTweetActivity activity2 = (EditTweetActivity) solo.getCurrentActivity();
        solo.waitForText("Test Tweet2!");
        final ListView clickedTweetslist = activity2.getClicked_TweetsList();
        Tweet clicked_tweet = (Tweet) clickedTweetslist.getItemAtPosition(0);
        assertEquals("Test Tweet2!", clicked_tweet.getMessage());

        assertTrue(solo.waitForText("New Activity"));

        solo.goBack();

        solo.assertCurrentActivity("Wrong Activity", LonelyTwitterActivity.class);
        solo.clickOnButton("Clear");
    }

    @Override
    public void tearDown() throws Exception{
        solo.finishOpenedActivities();
    }
}