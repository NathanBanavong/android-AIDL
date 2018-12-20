package com.example.aidl_server;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class PersonDatabase extends SQLiteOpenHelper {

    public PersonDatabase(@Nullable Context context) {
        super(context, PersonContract.NAME, null, PersonContract.VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(PersonContract.CREATE_TABLE);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        //drop table and upgrade to new version of database schema
        //migration scripts for saving database
    }

    public List<Person> getPeople() {

        SQLiteDatabase database = getWritableDatabase();

        List<Person> personList = new ArrayList<>();


        Cursor cursor = database.rawQuery(PersonContract.GET_ALL, null);


        if (cursor.moveToFirst()) {
            do {
                Person person = new Person(cursor.getString(cursor.getColumnIndex(PersonContract.FeedEntry.COL_NAME)),
                        cursor.getString(cursor.getColumnIndex(PersonContract.FeedEntry.COL_AGE)),
                        cursor.getString(cursor.getColumnIndex(PersonContract.FeedEntry.COL_GENDER)));

                personList.add(person);


            } while (cursor.moveToNext());
        }

        return personList;


    }
}
