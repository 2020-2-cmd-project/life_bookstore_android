package org.techtown.lifebookstore;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextClock;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.io.InputStream;

public class MainActivity extends AppCompatActivity {

    //일기 커버 등록
//    private static final int REQUEST_CODE = 0;
//    private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView textView1 = (TextView)findViewById(R.id.addCategory);
        textView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                show();
            }
        });

        //일기 커버 등록
//        imageView = findViewById(R.id.image);
//
//        imageView.setOnClickListener(new View.OnClickListener(){
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent();
//                intent.setType("image/*");
//                intent.setAction(Intent.ACTION_GET_CONTENT);
//                startActivityForResult(intent, REQUEST_CODE);
//            }
//        });
    }

    //일기 커버 등록
//    @Override
//    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
//        if(requestCode == REQUEST_CODE) {
//
//            if(resultCode == RESULT_OK) {
//                try {
//                    InputStream in = getContentResolver().openInputStream(data.getData());
//                    Bitmap img = BitmapFactory.decodeStream(in);
//                    in.close();
//                    imageView.setImageBitmap(img);
//                } catch(Exception e)
//                {
//                }
//            }
//            else if(resultCode == RESULT_CANCELED) {
//                Toast.makeText(this, "사진 선택 취소", Toast.LENGTH_LONG).show();
//            }
//        }
//    }


    //카테고리 추가 팝업창 함수
    void show() {

        final EditText edittext = new EditText(this);

        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        builder.setTitle("새 카테고리 만들기");
        builder.setMessage("새로운 카테고리를 만들어주세요");

        builder.setView(edittext);

        builder.setPositiveButton("등록하기",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(getApplicationContext(),edittext.getText().toString() ,Toast.LENGTH_LONG).show();
                        //Toast = 하단 팝업. 나중엔 데이터에 반영되도록 수정해야 함.
                    }
                });

        builder.setNegativeButton("취소",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                    }
                });

        builder.show();
    }

    //메인뷰 to 검색뷰
    public void movetoSearch(View view) {
        Intent intent = new Intent(this, SearchActivity.class);
        startActivity(intent);
    }

    //메인뷰 to 작성뷰
   public void movetoWrite(View view) {
        Intent intent = new Intent(this, WriteActivity.class);
        startActivity(intent);
    }

}
