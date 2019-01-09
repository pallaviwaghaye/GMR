package com.webakruti.gmr.SQLiteDB;

import android.provider.BaseColumns;

import java.sql.Date;
import java.time.LocalDateTime;

public class DatabaseConstants {
    private DatabaseConstants() {
    }

    public static abstract class CallDatabaseEntry implements BaseColumns {
        // Table ProductCategory
        public static final String TABLE_NAME = "gmr_machine";
        //Column names
        public static final String COLUMN_ID = "id";//pk
        public static final String COLUMN_MACHINE_CODE = "mcode";
        public static final String COLUMN_MACHINE_NAME = "mname";
        public static final String COLUMN_TIMEDATE = "timedate";
        public static final String COLUMN_MACHINE_READING = "mreading";


    }
}
