package org.techtown.lifebookstore;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import io.realm.Realm;

public class ViewActivity extends AppCompatActivity {
    Realm realm;
    int bookId;

    Book book = realm.where(Book.class).equalTo("id", bookId).findFirst();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view);

        TextView txtTitle = (TextView)findViewById(R.id.txtTitle);
        TextView txtContent = (TextView)findViewById(R.id.txtContent);
        TextView txtCategory = (TextView)findViewById(R.id.txtCategory);
        TextView txtDate = (TextView)findViewById(R.id.txtDate);
        TextView txtPlace = (TextView)findViewById(R.id.txtPlace);

        txtTitle.setText(book.getTitle());
        txtContent.setText(book.getContent());
        txtCategory.setText(book.getCategory());
        txtDate.setText(book.getDate());
        txtPlace.setText(book.getPlace()+"에서");
    }

    //상세보기뷰 to 메인뷰
    public void backtoMain(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

}