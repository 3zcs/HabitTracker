package me.a3zcs.habittracker.habittracker;

import android.provider.BaseColumns;

import static me.a3zcs.habittracker.habittracker.HabitContract.HabitEntry.COLUMN_NAME_TITLE;

/**
 * Created by root on 24/07/17.
 */

public class HabitContract {

    private HabitContract() {}

    static final String SQL_CREATE_ENTRIES =
            "CREATE TABLE " + HabitContract.HabitEntry.TABLE_NAME + " (" +
                    BaseColumns._ID + " INTEGER PRIMARY KEY," +
                    COLUMN_NAME_TITLE + " TEXT," +
                    HabitContract.HabitEntry.COLUMN_TYPE + " INTEGER)";

    static final String SQL_DELETE_ENTRIES =
            "DROP TABLE IF EXISTS " + HabitContract.HabitEntry.TABLE_NAME;

    static final int DB_VERSION = 1;
    static final String DB_NAME = "habit.db";

    /* Inner class that defines the table contents */
    static class HabitEntry implements BaseColumns {
        static final String TABLE_NAME = "habit";
        static final String COLUMN_NAME_TITLE = "habitName";
        static final String COLUMN_TYPE = "type";
    }
}
