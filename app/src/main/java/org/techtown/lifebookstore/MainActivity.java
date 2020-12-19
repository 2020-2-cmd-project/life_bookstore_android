package org.techtown.lifebookstore;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


import org.w3c.dom.Text;
import org.xml.sax.SAXException;

import io.realm.Realm;
import io.realm.RealmResults;

public class MainActivity extends AppCompatActivity {

    private Realm realm;

    private static final String TAG = "MainActivity";

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

        realm = Realm.getDefaultInstance();
        Log.i(TAG, "Realm 디렉토리: " + realm.getPath());
        Log.i(TAG, "Realm 환경설정 값: " + realm.getConfiguration());

        RealmResults<Category> categories = realm.where(Category.class).findAllAsync();
        //System.out.println(categories);
        Log.i(TAG, categories.toString());
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        realm.close();
    }


    //카테고리 추가 팝업창 함수
    public void show() {

        //final Category category = realm.where(Category.class);
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        final EditText newCategory = new EditText(this);

        builder.setTitle("새 카테고리 만들기");
        builder.setMessage("새로운 카테고리를 만들어주세요");

        builder.setView(newCategory);

        builder.setPositiveButton("등록하기",

                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {

                        realm.executeTransactionAsync(new Realm.Transaction() {
                            @Override
                            public void execute(Realm realm) {
                                Category category = realm.createObject(Category.class);
                                category.setCategoryName(newCategory.getText().toString());
                                //Log.i(TAG, category.getText().toString());
                            }
                        }, new Realm.Transaction.OnSuccess() {
                            @Override
                            public void onSuccess() {
                                Toast.makeText(MainActivity.this, "성공", Toast.LENGTH_SHORT).show();
                                System.out.println("SUCCESS");
                                //RealmResults<Category> categories = realm.findAll();

                            }
                        }, new Realm.Transaction.OnError() {
                            @Override
                            public void onError(Throwable error) {
                                Toast.makeText(MainActivity.this, "실패", Toast.LENGTH_SHORT).show();
                                System.out.println("faill");
                            }
                        });

//                        realm.beginTransaction();
//
//                        Category category = realm.createObject(Category.class);
//                        category.setCategoryName("카테고리명");
//
//                        //String new_category = newCategory.getText().toString();
//                        //category.setCategoryName(new_category);
//                        realm.commitTransaction();
                        //Toast.makeText(getApplicationContext(), newCategory.getText().toString(), Toast.LENGTH_LONG).show();
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

    //메인뷰 to 상세뷰
    public void movetoView(View view) {
        Intent intent = new Intent(this, ViewActivity.class);
        startActivity(intent);
    }

}
