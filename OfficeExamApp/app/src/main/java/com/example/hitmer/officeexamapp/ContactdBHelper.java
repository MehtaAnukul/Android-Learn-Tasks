package com.example.hitmer.officeexamapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class ContactdBHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "contact_db";
    public static final int DATABASE_VERSION = 1;
    public static final String CREATE_TABLE = "create table " + ContactContract.contactEntry.TABLE_NAME+ "("+ ContactContract.contactEntry.CONTACT_ID+ " number," + ContactContract.contactEntry.FIRSTNAME+ " text,"+ContactContract.contactEntry.LASTNAME+ " text,"+ContactContract.contactEntry.PHONENO+ " text," +ContactContract.contactEntry.EMAIL+ " text);";
    public static final String DROP_TABLE = "drop table if exists "+ContactContract.contactEntry.TABLE_NAME;

    public ContactdBHelper(Context context)
    {
        super(context,DATABASE_NAME,null,DATABASE_VERSION);
        Log.d("Database Operations","Database Created Successfully");
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE);
        Log.d("Database Operations","Table Created Successfully");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(DROP_TABLE);
        onCreate(db);
    }

    public void addContact(int id,String firstname,String lastname,String phoneno, String email, SQLiteDatabase database)
    {
        ContentValues contentValues = new ContentValues();
        contentValues.put(ContactContract.contactEntry.CONTACT_ID,id);
        contentValues.put(ContactContract.contactEntry.FIRSTNAME,firstname);
        contentValues.put(ContactContract.contactEntry.LASTNAME,lastname);
        contentValues.put(ContactContract.contactEntry.PHONENO,phoneno);
        contentValues.put(ContactContract.contactEntry.EMAIL,email);

        database.insert(ContactContract.contactEntry.TABLE_NAME,null,contentValues);
        Log.d("Database Operations","Data Inserted Successfully");
    }

    public Cursor readContacts(SQLiteDatabase database)
    {
        String[] projection = {ContactContract.contactEntry.CONTACT_ID,ContactContract.contactEntry.FIRSTNAME,ContactContract.contactEntry.LASTNAME,ContactContract.contactEntry.PHONENO,ContactContract.contactEntry.EMAIL};
        Cursor cursor = database.query(ContactContract.contactEntry.TABLE_NAME,projection,null,null,null,null,null);
        return cursor;
    }
    public void updateContact(int id,String firstname,String lastname,String phoneno, String email, SQLiteDatabase database)
    {
        ContentValues contentValues = new ContentValues();
        contentValues.put(ContactContract.contactEntry.FIRSTNAME,firstname);
        contentValues.put(ContactContract.contactEntry.LASTNAME,lastname);
        contentValues.put(ContactContract.contactEntry.PHONENO,phoneno);
        contentValues.put(ContactContract.contactEntry.EMAIL,email);

        String selection = ContactContract.contactEntry.CONTACT_ID + " = " + id;

        database.update(ContactContract.contactEntry.TABLE_NAME,contentValues,selection,null);
    }
    public void deleteContact(int id, SQLiteDatabase database)
    {
        String selection = ContactContract.contactEntry.CONTACT_ID + " = " + id;

        database.delete(ContactContract.contactEntry.TABLE_NAME,selection,null);
    }
}
