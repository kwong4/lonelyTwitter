package ca.ualberta.cs.lonelytwitter;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class EditTweetActivity extends Activity {

    private ListView clicked_TweetsList;
    private ArrayList<Tweet> tweetList = new ArrayList<Tweet>();
    private ArrayAdapter<Tweet> adapter;

    public ListView getClicked_TweetsList(){
        return clicked_TweetsList;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_tweet);
        clicked_TweetsList = (ListView) findViewById(R.id.listView);
        Intent intent = getIntent();
        Tweet clicked_tweet = (Tweet) intent.getSerializableExtra("Tweet");
        adapter = new ArrayAdapter<Tweet>(this,
                R.layout.list_item, tweetList);
        clicked_TweetsList.setAdapter(adapter);
        tweetList.add(clicked_tweet);
    }

//    @Override
//    protected void onStart() {
//        super.onStart();
//
//    }
}
