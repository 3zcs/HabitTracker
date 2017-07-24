package me.a3zcs.habittracker.habittracker;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import static me.a3zcs.habittracker.habittracker.HabitContract.DB_NAME;
import static me.a3zcs.habittracker.habittracker.HabitContract.DB_VERSION;
import static me.a3zcs.habittracker.habittracker.HabitContract.SQL_CREATE_ENTRIES;
import static me.a3zcs.habittracker.habittracker.HabitContract.SQL_DELETE_ENTRIES;

/**
 * Created by root on 24/07/17.
 */

public class HabitSqlHelper extends SQLiteOpenHelper {

    public HabitSqlHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREATE_ENTRIES);
    }

    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(SQL_DELETE_ENTRIES);
        onCreate(db);
    }

    public long insert(String title,int type){
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(HabitContract.HabitEntry.COLUMN_NAME_TITLE, title);
        values.put(HabitContract.HabitEntry.COLUMN_TYPE, type);

        return db.insert(HabitContract.HabitEntry.TABLE_NAME, null, values);
    }

    public Cursor query(String selectionArg){
        SQLiteDatabase db = this.getReadableDatabase();
        String selection = HabitContract.HabitEntry.COLUMN_NAME_TITLE + " LIKE ?";
        String[] selectionArgs = { selectionArg };
        return db.query(HabitContract.HabitEntry.TABLE_NAME,
                new String [] {HabitContract.HabitEntry.COLUMN_NAME_TITLE,
                        HabitContract.HabitEntry.COLUMN_TYPE},
                selection,selectionArgs,null,null,null);
    }

}
