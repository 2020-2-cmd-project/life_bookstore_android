package org.techtown.lifebookstore;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Button;

public class WriteActivity extends AppCompatActivity {
    EditText editTitle;
    EditText editContent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_write);

//        editTitle=findViewById(R.id.editTitle);
//        editContent=findViewById(R.id.editContent);
    }

    //작성뷰 to 메인뷰
    public void backtoMain(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

// 에뮬레이터 실행시키면 에러나서 일단 주석 처리 했어요!

//    public void writeBook(View view){
//        book newBook = new book();
//        String newTitle = editTitle.getText().toString();
//        newTitle=newTitle.replace("'", "''");
//        //book.setTitle(newTitle);
//        String content=editContent.getText().toString();
//        content=content.replace("'", "''");
//
//        backtoMain(view);
//    }

//    public void addHashtags()


}