package org.techtown.lifebookstore;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextClock;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void add_category(View view) {
        LinearLayout View = (LinearLayout)findViewById(R.id.categories);
        Button button = new Button(this);
        View.addView(button);
    }

    public void movetoSearch(View view) {
        Intent intent = new Intent(this, SearchActivity.class);
        startActivity(intent);
    }

    public void movetoWrite(View view) {
        Intent intent = new Intent(this, WriteActivity.class);
        startActivity(intent);
    }

}
