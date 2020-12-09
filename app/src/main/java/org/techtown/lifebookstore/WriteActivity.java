package org.techtown.lifebookstore;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import io.realm.Realm;


public class WriteActivity extends AppCompatActivity {
    EditText setTitle;
    EditText writeDiary;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_write);

        Realm realm = Realm.getDefaultInstance();
        setTitle=findViewById(R.id.setTitle);
        writeDiary=findViewById(R.id.writeDiary);
    }

    //작성뷰 to 메인뷰
    public void backtoMain(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    public void writeBook(){
        Book newBook = new Book();
        String newTitle = setTitle.getText().toString();
        newTitle=newTitle.replace("'", "''");
        newBook.setTitle(newTitle);
        String content=writeDiary.getText().toString();
        content=content.replace("'", "''");
        newBook.setContent(content);

        //backtoMain();
    }


//    public void addHashtags()


}