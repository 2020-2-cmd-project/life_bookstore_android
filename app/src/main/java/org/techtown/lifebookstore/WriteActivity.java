package org.techtown.lifebookstore;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import io.realm.Realm;
import io.realm.Realm.Transaction;

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

    @Override
    protected void onDestroy() {
        super.onDestroy();
        realm.close();
    }

    private int getBookId() {
        //자동으로 Id를 증가시켜야 되기 때문에
        //이 메소드가 불린 시점에서 Realm에 저장되어있는 Diary의 ID의 최대값을 구해옵니다.
        Number currentIndex = realm.where(Book.class).max("id");

        //새로 저장할 Diary의 ID값
        int nextId;

        //Realm에 Diary가 저장되어있지 않아 저장된 ID도 없는 경우에는
        if (currentIndex == null) {
            //처음 생성되는 ID이기 때문에 1을 지정합니다
            nextId = 1;
            //Realm에 Diary가 저장되어있는 경우에는 저장되어 있는 Diary의 최대 ID를 찾아와서
        } else {
            //찾아온 ID에 +1을 해서 돌려줍니다.
            nextId = currentIndex.intValue() + 1;
        }
        return nextId;
    }

    //작성 및 저장
    public void writeBook(View view){
        EditText setTitle=(EditText)findViewById(R.id.setTitle);
        EditText writeDiary=(EditText)findViewById(R.id.writeDiary);
        EditText setDate = (EditText)findViewById(R.id.setDate);
        EditText setPlace = (EditText)findViewById(R.id.setPlace);

        final String title = setTitle.getText().toString().replace("'", "''");
        final String content=writeDiary.getText().toString().replace("'", "''");
        final String Place = setPlace.getText().toString();
        final String Date = setDate.getText().toString();

        final Book book = new Book(getBookId());
        book.setContent(content);
        book.setTitle(title);
        book.setDate(Date);
        book.setPlace(Place);

        realm.executeTransaction(new Transaction(){
            @Override
            public void execute(Realm realm) {
                realm.copyToRealm(book);

            }
        });

        Intent intent = new Intent(this, ViewActivity.class);
        startActivity(intent);
    }

  //  public void saveBook


//    public void addHashtags()


}