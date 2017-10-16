package com.example.tomasz.appwithdatabase;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    DatabaseHelper dbHelper= new DatabaseHelper(this);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



    }
    public void onClickAdd(View view)
    {
        EditText text1= (EditText) findViewById(R.id.text1);
        EditText text2= (EditText) findViewById(R.id.text2);
        SQLiteDatabase db= dbHelper.getWritableDatabase();
        String firstText =text1.getText().toString();
        String secondText =text2.getText().toString();

        ContentValues values = new ContentValues();
        values.put(FeedReaderContract.FeedEntry.getColumnNameTekst1(),firstText);
        values.put(FeedReaderContract.FeedEntry.getColumnNameTekst2(),secondText);
        long newRowId = db.insert(FeedReaderContract.FeedEntry.getTableName(), null, values);
    }
    public void onClickView(View view)
    {
        Intent intent = new Intent(this,ActivityListView.class);
        startActivity(intent);
    }
}
