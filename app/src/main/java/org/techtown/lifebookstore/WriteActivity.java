package org.techtown.lifebookstore;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Button;
import io.realm.Realm;
import io.realm.RealmObject;


public class WriteActivity extends AppCompatActivity {
    EditText editTitle;
    EditText editContent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_write);

        Realm realm = Realm.getDefaultInstance();
        editTitle=findViewById(R.id.editTitle);
        editContent=findViewById(R.id.editContent);
    }

    //작성뷰 to 메인뷰
    public void backtoMain(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    public void writeBook(){
        Book newBook = new Book();
        String newTitle = editTitle.getText().toString();
        newTitle=newTitle.replace("'", "''");
        newBook.setTitle(newTitle);
        String content=editContent.getText().toString();
        content=content.replace("'", "''");
        newBook.setContent(content);

        //backtoMain();
    }


//    public void addHashtags()


}