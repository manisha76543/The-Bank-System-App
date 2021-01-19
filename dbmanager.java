package com.example.bankapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class dbmanager extends SQLiteOpenHelper {

    private static final String dbname = "dbcontact";
    public Context context;

    public dbmanager(@Nullable Context context) {
        super(context, dbname, null,2);
    }
        @Override
    public void onCreate(SQLiteDatabase db) {

        String qry = "create table tbl_contact1(id integer primary key autoincrement, name text, email text, amount integer, phn integer, account integer, ifsc integer)";

        String qry2 = "create table tbl_contact2(id integer primary key autoincrement, sname text, rname text, transfAmount integer )";

        db.execSQL(qry);
        db.execSQL(qry2);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        String qry = "DROP TABLE IF EXISTS tbl_contact1";
        String qry2 = "DROP TABLE IF EXISTS tbl_contact2";
        db.execSQL(qry);
        db.execSQL(qry2);
        onCreate(db);

    }

    public String insertdata(String name, String email, int amount, int phn, int account, int ifsc)
    {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues cv = new ContentValues();
        cv.put("name", name);
        cv.put("email", email);
        cv.put("amount", amount);
        cv.put("phn", phn);
        cv.put("account", account);
        cv.put("ifsc", ifsc);

        float res = db.insert("tbl_contact1", null, cv);

        if(res==-1)
            return "Failed";
        else
            return "Successfully inserted";
    }
    public Cursor readalldata()
    {
        SQLiteDatabase db = this.getWritableDatabase();
        String qry = "select * from tbl_contact1 order by id desc";

        Cursor cursor = db.rawQuery(qry,null);
        return cursor;

    }

    public Cursor readalldata2()
    {
        SQLiteDatabase db2 = this.getWritableDatabase();
        String qry2 = "select * from tbl_contact2 order by id desc";

        Cursor cursor2 = db2.rawQuery(qry2,null);

        return cursor2;

    }


    public String insertdata2(String sname, String rname, int transferAmount)
    {
        SQLiteDatabase db2 = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("sname", sname);
        cv.put("rname",rname);
        cv.put("transferAmount",transferAmount);

        float res2 = db2.insert("tbl_contact2",null,cv);

        if(res2 == -1)
            return "not get";
        else
            return "got it";

    }

    public String updateData(String senderName, String receiverName, int senderNewamount, int receiverNewAmount)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        ContentValues cv1 = new ContentValues();
        cv.put("amount", senderNewamount);
        cv1.put("amount",receiverNewAmount);

        long result = db.update("tbl_contact1", cv, "name = ?", new String[] {senderName});
        long result1 = db.update("tbl_contact1", cv1, "name = ?", new String[] {receiverName});

        if(result == -1 && result1 == -1)
        {
           // Toast.makeText(context,"Failed to update", Toast.LENGTH_SHORT).show();
            return "Failed to update";
        }
        else
        {
           // Toast.makeText(context,"Successfully updated!", Toast.LENGTH_SHORT).show();
            return  "Successfully updated!";
        }
    }

}
