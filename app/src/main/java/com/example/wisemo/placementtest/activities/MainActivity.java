package com.example.wisemo.placementtest.activities;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.example.wisemo.placementtest.R;
import com.example.wisemo.placementtest.adapters.QuestionPagerAdapter;
import com.example.wisemo.placementtest.data.Question;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ViewPager mainViewPager;
    private PagerAdapter mainPagerAdapter;
    private List<Question> getData;

    private int score;
    private String userName;
    private String userPhone;
    private String userMail;

    private static final String TAG = "MyActivity";

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        outState.putInt("UserScore", score);
        super.onSaveInstanceState(outState);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Bundle dataBundle = getIntent().getExtras();
        if(dataBundle != null){
            userName = dataBundle.getString("NAME");
            userPhone = dataBundle.getString("PHONE");
            userMail = dataBundle.getString("MAIL");
        }

        getData = dataSource();
        mainViewPager = findViewById(R.id.viewPager);
        mainPagerAdapter = new QuestionPagerAdapter(MainActivity.this, getData);
        mainViewPager.setAdapter(mainPagerAdapter);

        invalidateOptionsMenu();
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        score = savedInstanceState.getInt("UserScore");
        super.onRestoreInstanceState(savedInstanceState);
    }

    public void onAnswerClick(View view) {

        int position = mainViewPager.getCurrentItem();
        if (Arrays.asList(getData.get(position).isFirstIsRight()).contains(true)
                || Arrays.asList(getData.get(position).isSecondIsRight()).contains(true)
                || Arrays.asList(getData.get(position).isThirdIsRight()).contains(true)
                || Arrays.asList(getData.get(position).isFourthIsRight()).contains(true)) {
            view.setBackgroundColor(Color.parseColor("#303F9F"));
            score = ++ score;
            Log.d(TAG, "The score now is " + score);
        }
        int lastPage = 5;

        mainViewPager.setCurrentItem(mainViewPager.getCurrentItem() + 1, true);
        int currentItem = mainViewPager.getCurrentItem();
        Log.d(TAG, "CURRENT ITEM IS " + currentItem);

        if (mainViewPager.getCurrentItem() == lastPage) {
            Intent intent = new Intent(MainActivity.this, WritingActivity.class);
            // Save what user entered in the Edit Text Views in 2 keys to be called in the MainActivity class.
//            intent.putExtra("NAME", userName);
//            intent.putExtra("PHONE", userPhone);
//            intent.putExtra("MAIL", userMail);
//            intent.putExtra("SCORE", score);
            Log.d(TAG, "User Name is " + userName);
            Log.d(TAG, "User Phone is " + userPhone);
            Log.d(TAG, "User Email is " + userMail);
            Log.d(TAG, "The score now is " + score);

            // Start the MainActivity class.
            startActivity(intent);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.next_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_next_question:
//                // Advance to the next step in the wizard. If there is no next step, setCurrentItem
//                // will do nothing.
//                mainViewPager.setCurrentItem(mainViewPager.getCurrentItem() + 1, true);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        // Confirmation AlertDialog builder when user press home button
        AlertDialog.Builder leaveDialog = new AlertDialog.Builder(MainActivity.this);
        // Setting Dialog Title.
        leaveDialog.setTitle("WARNING");
        // Setting Dialog Message,
        // "I used the Activity.this.getString() method to avoid showing numbers instead of the string resources.
        leaveDialog.setMessage
                (MainActivity.this.getString(R.string.leave_app_msg));
        // Setting Icon to Dialog.
        leaveDialog.setIcon(R.drawable.en_icon);
        // Setting Positive "Yes" Btn.
        leaveDialog.setPositiveButton(R.string.yes,
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        // TO DO will reset all scores values to Zero.
                        finish();
                        // Congratulations dialog toast.
                        Toast.makeText(getApplicationContext(),
                                R.string.see_you_soon, Toast.LENGTH_LONG)
                                .show();
                    }
                })
                // Setting Negative "No" Btn.
                .setNegativeButton(R.string.no,
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                            }
                        });
        // Showing Alert Dialog.
        leaveDialog.show();
    }

    private static List<Question> dataSource() {

        List<Question> questions = new ArrayList<>();

        questions.add(new Question("Q-1", "A01", true, "A02", "A03", "A04"));
        questions.add(new Question("Q-2", "A01", "A02", true, "A03", "A04"));
        questions.add(new Question("Q-3", "A01", "A02", "A03", true, "A04"));
        questions.add(new Question("Q-4", "A01", "A02", "A03", "A04", true));
        questions.add(new Question("Q-5", "A01", true, "A02", "A03", "A04"));
        questions.add(new Question("Q-6", "A01", "A02", "A03", true, "A04"));

        return questions;
    }

}
