package org.techtown.lifebookstore;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import io.realm.Realm;

public class WriteActivity extends AppCompatActivity {
    private Realm realm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_write);

        realm = Realm.getDefaultInstance();
        //showResult();
    }

    //작성뷰 to 메인뷰
    public void backtoMain(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    //작성 및 저장
    public void writeBook(View view){
        EditText setTitle=(EditText)findViewById(R.id.setTitle);
        EditText writeDiary=(EditText)findViewById(R.id.writeDiary);
        EditText setDate = (EditText)findViewById(R.id.setDate);
        EditText setPlace = (EditText)findViewById(R.id.setPlace);

        String title = setTitle.getText().toString();
        title=title.replace("'", "''");
        String content=writeDiary.getText().toString();
        content=content.replace("'", "''");
        String Place = setPlace.getText().toString();
        String Date = setDate.getText().toString();

        realm.beginTransaction();
        Book book = realm.createObject(Book.class);
        book.setContent(content);
        book.setTitle(title);
        book.setDate(Date);
        book.setPlace(Place);
        //book.setIndex();
        realm.commitTransaction();

        Intent intent = new Intent(this, ViewActivity.class);
        startActivity(intent);
    }

  //  public void saveBook


//    public void addHashtags()


}