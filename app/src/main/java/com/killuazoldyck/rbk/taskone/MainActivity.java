package com.killuazoldyck.rbk.taskone;

import android.content.ComponentName;
import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class MainActivity extends ActionBarActivity {
    Button button;
    TextView textView;
    private int count = 0;
    private String tag_index = "index";
    private String count1 = Integer.toString(count);
    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = (Button) findViewById(R.id.button);
        textView = (TextView) findViewById(R.id.Textview);
        returninfo();
        count = Integer.parseInt(count1);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                count++;
                count1 = Integer.toString(count);
                saveinfo();
                returninfo();
            }
        });
    }

    public void saveinfo() {
    SharedPreferences sharedPref = MainActivity.this.getPreferences(Context.MODE_PRIVATE);
    SharedPreferences.Editor editor = sharedPref.edit();
    editor.putString("Count",count1);
    editor.apply();

    }
    public void returninfo() {
    SharedPreferences sharedPref = getPreferences(Context.MODE_PRIVATE);
    count1 = sharedPref.getString("Count","0");
    textView.setText("This is the counter \nYou have pressed the buton " + count1 + " times");
    }
    @Override
    protected void onSaveInstanceState(Bundle savedInstanceState)
    {
    savedInstanceState.putInt(tag_index,count);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
