package com.example.tomasz.appwithdatabase;

import android.provider.BaseColumns;

/**
 * Created by Tomasz on 16.10.2017.
 */
public final class FeedReaderContract{
    public FeedReaderContract() {
    }
    public static class FeedEntry implements BaseColumns {
        public static final String TABLE_NAME="dane";
        public static final String COLUMN_NAME_TEKST1="tekst1";
        public static final String COLUMN_NAME_TEKST2="tekst2";
        private static final String SQL_CREATE_ENTRIES="CREATE TABLE "+ FeedEntry.TABLE_NAME+" (" +
                FeedEntry._ID+" INTEGER PRIMARY KEY,"+
                FeedEntry.COLUMN_NAME_TEKST1+" TEXT,"+
                FeedEntry.COLUMN_NAME_TEKST2+" TEXT)";

        private static final String SQL_DELETE_ENTRIES="DROP TABLE IF EXISTS "+ FeedEntry.TABLE_NAME;


        public static String getTableName() {
            return TABLE_NAME;
        }

        public static String getColumnNameTekst1() {
            return COLUMN_NAME_TEKST1;
        }

        public static String getColumnNameTekst2() {
            return COLUMN_NAME_TEKST2;
        }


        public static String getSqlCreateEntries() {
            return SQL_CREATE_ENTRIES;
        }

        public static String getSqlDeleteEntries() {
            return SQL_DELETE_ENTRIES;
        }
    }

}
