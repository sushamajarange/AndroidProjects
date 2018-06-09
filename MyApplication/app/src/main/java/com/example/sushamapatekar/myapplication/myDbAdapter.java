package com.example.sushamapatekar.myapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.List;
import java.util.ArrayList;
import com.example.sushamapatekar.myapplication.DataModel;

public class myDbAdapter {
    myDbHelper myhelper;
    public myDbAdapter(Context context)
    {
        myhelper = new myDbHelper(context);
    }

    public long insertData(String name, String lastName, String contactNo)
    {
        SQLiteDatabase dbb = myhelper.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put(myDbHelper.NAME, name);
        contentValues.put(myDbHelper.LASTNAME, lastName);
        contentValues.put(myDbHelper.CONTACTNO, contactNo);
        long id = dbb.insert(myDbHelper.TABLE_NAME, null , contentValues);
        Log.d("DBAdapter", "Insert data :"+ contentValues.toString());
        return id;
    }

    public List<DataModel> getData()
    {
        List<DataModel> data=new ArrayList<>();
        DataModel dataMadel = new DataModel();
        SQLiteDatabase db = myhelper.getWritableDatabase();
        String[] columns = {myDbHelper.UID,myDbHelper.NAME,myDbHelper.LASTNAME,myDbHelper.CONTACTNO};
        Cursor cursor =db.query(myDbHelper.TABLE_NAME,columns,null,null,null,null,null);
        StringBuffer buffer= new StringBuffer();
        while (cursor.moveToNext())
        {
            int cid =cursor.getInt(cursor.getColumnIndex(myDbHelper.UID));
            String name =cursor.getString(cursor.getColumnIndex(myDbHelper.NAME));
            String  lName =cursor.getString(cursor.getColumnIndex(myDbHelper.LASTNAME));
            String contactN=cursor.getString(cursor.getColumnIndex(myDbHelper.CONTACTNO));

            dataMadel.setFirstname(name);
            dataMadel.setLastname(lName);
            dataMadel.setContactNo(contactN);

            data.add(dataMadel);

            Log.d("DBAdapter", "List data [" + cid + " ]:"+ dataMadel.toString());

            // buffer.append(cid+ "   " + name + "   " + lName +"   " + contactN +" \n");
        }
        for(DataModel mo:data){
            Log.i("Hello", mo.getFirstname());
        }
        return data;
        //return buffer.toString();
    }

    public  int delete(String uname)
    {
        SQLiteDatabase db = myhelper.getWritableDatabase();
        String[] whereArgs ={uname};

        int count =db.delete(myDbHelper.TABLE_NAME ,myDbHelper.NAME+" = ?",whereArgs);
        return  count;
    }
    public int updateName(String oldName , String newName)
    {
        SQLiteDatabase db = myhelper.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(myDbHelper.NAME,newName);
        String[] whereArgs= {oldName};
        int count =db.update(myDbHelper.TABLE_NAME,contentValues, myDbHelper.NAME+" = ?",whereArgs );
        return count;
    }

    static class myDbHelper extends SQLiteOpenHelper {
        private static final String DATABASE_NAME = "myDatabase";    // Database Name
        private static final String TABLE_NAME = "myTable";   // Table Name
        private static final int DATABASE_Version = 1;    // Database Version
        private static final String UID = "_id";     // Column I (Primary Key)
        private static final String NAME = "Name";    //Column II
        private static final String LASTNAME = "LastName";    // Column III
        private static final String CONTACTNO = "ContactNo";    // Column VI
        private static final String CREATE_TABLE = "CREATE TABLE " + TABLE_NAME +
                " (" + UID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + NAME + " VARCHAR(255) ," + LASTNAME + " VARCHAR(225),"+ CONTACTNO + " INTEGER(12));";
        private static final String DROP_TABLE = "DROP TABLE IF EXISTS " + TABLE_NAME;
        private Context context;

        public myDbHelper(Context context) {
            super(context, DATABASE_NAME, null, DATABASE_Version);
            this.context = context;
        }

        public void onCreate(SQLiteDatabase db) {

            try {
                db.execSQL(CREATE_TABLE);
            } catch (Exception e) {
                Message.message(context, "" + e);
            }
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            try {
                Message.message(context, "OnUpgrade");
                db.execSQL(DROP_TABLE);
                onCreate(db);
            } catch (Exception e) {
                Message.message(context, "" + e);
            }
        }
    }
}
