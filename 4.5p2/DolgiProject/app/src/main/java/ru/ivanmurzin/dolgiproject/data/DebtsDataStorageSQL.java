package ru.ivanmurzin.dolgiproject.data;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class DebtsDataStorageSQL extends SQLiteOpenHelper implements DebtsDataStorage {
    private final static String DB_NAME = "debts.db";
    private final static String TABLE_NAME = "debts";

    private final static String COLUMN_ID = "_id";
    private final static String COLUMN_NAME = "name";
    private final static String COLUMN_MONEY = "money";


    public DebtsDataStorageSQL(@Nullable Context context) {
        super(context, DB_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(
                "CREATE TABLE " + TABLE_NAME + " (" + // id name money
                        COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                        COLUMN_NAME + " VARCHAR, " +
                        COLUMN_MONEY + " REAL" +
                        ");"
        );
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE " + TABLE_NAME);
        onCreate(db);
    }

    @Override
    public void saveData(Debt debt) { // insert into table ( name, money) values ( "lala", 123)
        SQLiteDatabase database = getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COLUMN_NAME, debt.name);
        contentValues.put(COLUMN_MONEY, debt.money);
        database.insert(TABLE_NAME, null, contentValues);
    }

    @Override
    public Debt getData(int id) {
        SQLiteDatabase database = getReadableDatabase();
        Cursor cursor = database.query(TABLE_NAME, null, null, null, null, null, null);
        cursor.moveToPosition(id);
        @SuppressLint("Range") String name = cursor.getString(cursor.getColumnIndex(COLUMN_NAME));
        @SuppressLint("Range") float money = cursor.getFloat(cursor.getColumnIndex(COLUMN_MONEY));
        cursor.close();
        return new Debt(name, money);
    }

    @Override
    public List<Debt> getAllData() {
        SQLiteDatabase database = getReadableDatabase();
        Cursor cursor = database.query(TABLE_NAME, null, null, null, null, null, null);
        ArrayList<Debt> debts = new ArrayList<>();
        if (cursor.moveToFirst()) {
            do {
                // получать данные
                @SuppressLint("Range") String name = cursor.getString(cursor.getColumnIndex(COLUMN_NAME));
                @SuppressLint("Range") float money = cursor.getFloat(cursor.getColumnIndex(COLUMN_MONEY));

                debts.add(new Debt(name, money));

            } while (cursor.moveToNext());
        }

        cursor.close();
        return debts;
    }

}
