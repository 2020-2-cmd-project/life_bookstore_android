package org.techtown.lifebookstore;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import io.realm.Realm;
import io.realm.RealmResults;

public class ViewActivity extends AppCompatActivity {
    Realm realm;

    Book book = realm.where(Book.class).equalTo("id", diaryId).findFirst();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view);
    }


    //상세보기뷰 to 메인뷰
    public void backtoMain(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }


}