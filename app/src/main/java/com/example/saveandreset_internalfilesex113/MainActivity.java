package com.example.saveandreset_internalfilesex113;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * @author Agam Toledano
 * @version 1.0
 * @since 08/11/2021
 * Short description - Practice (Internal Files) - Saves data.
 */

public class MainActivity extends AppCompatActivity {
    EditText et;
    TextView tv;
    String base, textAdd, line;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et = (EditText) findViewById(R.id.et);
        tv = (TextView) findViewById(R.id.tv);

        base = "";
        textAdd = "";
        Read();
    }

    /**
     *Internal Files - Read:
     * Short description - Read data and presents it.
     * <p>
     */
    private void Read() {
        try {
            FileInputStream fis = openFileInput("text.txt");
            InputStreamReader isr = new InputStreamReader(fis);
            BufferedReader br = new BufferedReader(isr);
            StringBuilder sb = new StringBuilder();
            line = br.readLine();
            while (line != null) {
                sb.append(line);
                line = br.readLine();
            }
            base = sb.toString();
            tv.setText(base);
            isr.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     *Internal Files - Read:
     * Short description - Edit&Save data + presents it.
     * <p>
     */
    public void EditAndSave() {
        try {
            textAdd = et.getText().toString();
            FileOutputStream fos = openFileOutput("text.txt", MODE_PRIVATE);
            OutputStreamWriter osw = new OutputStreamWriter(fos);
            BufferedWriter bw = new BufferedWriter(osw);
            base += textAdd;
            bw.write(base);
            bw.close();
            tv.setText(base);
            et.setText("");
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Button:
     * Short description - Saves data and presents it.
     * <p>
     *
     * @param view
     */
    public void save(View view) {
        EditAndSave();
    }

    /**
     * Button:
     * Short description - Resets the text and presents it.
     * <p>
     *
     * @param view
     */
    public void reset(View view) {
        base = "";
        textAdd = "";
        et.setText(base);
        EditAndSave();
    }

    /**
     * Button:
     * Short description - Exits the app.
     * <p>
     *
     * @param view
     */
    public void exit(View view) {
        finish();
    }

    /**
     * onPause:
     * Short description - Saves data and exits the app.
     * <p>
     */
    @Override
    protected void onPause() {
        EditAndSave();
        super.onPause();
    }

    /**
     * OptionMenu:
     * Short description - Creation of OptionMenu.
     * @param menu
     * @return super.onCreateOptionsMenu(menu)
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    /**
     * OptionMenu:
     * Short description - Activating the OptionMenu.
     * @param item
     * @return super.onOptionsItemSelected(item)
     */
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        String title = item.getTitle().toString();
        if (title.equals("Credit")) {
            Intent si = new Intent(this, CreditActivity.class);
            startActivity(si);
        }
        return super.onOptionsItemSelected(item);
    }
}