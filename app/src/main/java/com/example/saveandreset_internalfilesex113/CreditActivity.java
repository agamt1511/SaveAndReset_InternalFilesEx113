package com.example.saveandreset_internalfilesex113;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

/**
 * @author Agam Toledano
 * @version 1.0
 * @since 08/11/2021
 * Short description - Practice (Internal Files) - Saves data.
 */
public class CreditActivity extends AppCompatActivity {
    TextView ctext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_credit);

        ctext = (TextView) findViewById(R.id.ctext);
        ctext.setText("Credits:\n\n\n"+ "Created by Agam T");
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
        if (title.equals("Homepage")) {
            finish();
        }
        return super.onOptionsItemSelected(item);
    }
}