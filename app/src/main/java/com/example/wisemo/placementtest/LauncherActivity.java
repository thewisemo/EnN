package com.example.wisemo.placementtest;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LauncherActivity extends AppCompatActivity {

    String name, phone, eMail;

    EditText tName, tPhone, tMail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_launcher);

        tName = findViewById(R.id.editText_name);
        tPhone = findViewById(R.id.editText_cell);
        tMail = findViewById(R.id.editText_email);

        name = tName.getText().toString().trim();
        phone = tPhone.toString().trim();
        eMail = tMail.getText().toString().trim();

        tMail.setOnEditorActionListener(new EditText.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView textView, int actionId, KeyEvent keyEvent) {
                // Here the user reached the last input needed
                if (actionId == EditorInfo.IME_ACTION_DONE){
                    // calling invalidateOptionsMenu(); to check whether to show START or NO
                    invalidateOptionsMenu();
                    // To hide the keyboard after pressing done
                    InputMethodManager imm = (InputMethodManager) getSystemService(
                            Context.INPUT_METHOD_SERVICE);
                    assert imm != null;
                    imm.hideSoftInputFromWindow(tMail.getApplicationWindowToken(), 0);
                    openMain();
                    return true;
                }
                return false;
            }
        });
    }

    public void openMain(){
        // Initialize an intent to pass user data to MainActivity.
        Intent intent = new Intent(LauncherActivity.this, MainActivity.class);
        // Save what user entered in the Edit Text Views in 2 keys to be called in the MainActivity class.
        intent.putExtra("NAME", name);
        intent.putExtra("PHONE", phone);
        intent.putExtra("MAIL", eMail);
        // Start the MainActivity class.
        startActivity(intent);
    }

    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {

        if(tName.getText().toString().isEmpty() && tMail.getText().toString().isEmpty() && tPhone.getText().toString().isEmpty()){
            menu.getItem(0).setEnabled(false);
        }else {
            menu.getItem(0).setEnabled(true);
        }
        return super.onPrepareOptionsMenu(menu);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.start_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        super.onOptionsItemSelected(item);
        switch (item.getItemId()) {
            case R.id.action_start:
                finish();
                break;
        }
        return true;
    }

    @Override
    public void onBackPressed() {
        // Confirmation AlertDialog builder when user press home button
        AlertDialog.Builder leaveDialog = new AlertDialog.Builder(LauncherActivity.this);
        // Setting Dialog Title.
        leaveDialog.setTitle("Hey!");
        // Setting Dialog Message,
        // "I used the Activity.this.getString() method to avoid showing numbers instead of the string resources.
        leaveDialog.setMessage
                (LauncherActivity.this.getString(R.string.leave_app_msg));
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
}
