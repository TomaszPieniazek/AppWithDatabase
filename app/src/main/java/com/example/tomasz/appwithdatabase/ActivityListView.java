package com.example.tomasz.appwithdatabase;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.database.sqlite.SQLiteDatabase;
import android.database.Cursor;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.ArrayAdapter;
import java.util.List;
import java.util.ArrayList;
/**
 * Created by Tomasz on 16.10.2017.
 */

public class ActivityListView extends AppCompatActivity {
    DatabaseHelper dbHelper= new DatabaseHelper(this);

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);

        ListView lv= (ListView) findViewById(R.id.lv1);
        SQLiteDatabase db = dbHelper.getReadableDatabase();

        String[] projection = {
                FeedReaderContract.FeedEntry._ID,
                FeedReaderContract.FeedEntry.getColumnNameTekst1(),
                FeedReaderContract.FeedEntry.getColumnNameTekst2()
        };

        Cursor cursor = db.query(
                FeedReaderContract.FeedEntry.TABLE_NAME,                     // The table to query
                projection,                               // The columns to return
                null,                                // The columns for the WHERE clause
                null,                            // The values for the WHERE clause
                null,                                     // don't group the rows
                null,                                     // don't filter by row groups
                null                                 // The sort order
        );


        List items = new ArrayList<>();

        while(cursor.moveToNext()) {
            long itemId = cursor.getLong(
                    cursor.getColumnIndexOrThrow(FeedReaderContract.FeedEntry._ID));
            String itemText1= cursor.getString(
                    cursor.getColumnIndexOrThrow(FeedReaderContract.FeedEntry.COLUMN_NAME_TEKST1));
            String itemText2= cursor.getString(
                    cursor.getColumnIndexOrThrow(FeedReaderContract.FeedEntry.COLUMN_NAME_TEKST2));
            String calosc=itemId+" "+itemText1+" "+itemText2;
            items.add(calosc);

        }
        cursor.close();
        ListAdapter adap = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,items);
        lv.setAdapter(adap);
    }
}
