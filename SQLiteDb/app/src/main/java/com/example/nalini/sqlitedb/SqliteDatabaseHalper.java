package com.example.nalini.sqlitedb;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by nalini on 28/12/16.
 */

public class SqliteDatabaseHalper extends SQLiteOpenHelper {

    private  static final String DATABASE_NAME="StudentDetails.db";

    private static final int DATABASE_VERSION=1;

    private static final String TABLE_NAME="studentinfo";

    private Context context;



    public SqliteDatabaseHalper(Context context, String databasename, SQLiteDatabase.CursorFactory factory, int databaseversion)
    {
        super(context, DATABASE_NAME, null,DATABASE_VERSION);
        this.context=context;
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        String query="CREATE TABLE IF NOT EXISTS "+TABLE_NAME+
                "(" +"id INTEGER PRIMARY KEY, "+"name TEXT, "+"number INTEGER, "+"email TEXT, "+"city TEXT )";

        sqLiteDatabase.execSQL(query);

        Toast.makeText(context,"Table created",Toast.LENGTH_SHORT).show();

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }


    public boolean addStudentDetails(String name,String sNumber,String email,String city)
    {
        long number = Long.parseLong(sNumber);

        ContentValues contentValues=new ContentValues();

        contentValues.put("name",name);
        contentValues.put("number",number);
        contentValues.put("email",email);
        contentValues.put("city",city);

        SQLiteDatabase sqLiteDatabase=this.getWritableDatabase();

              long x= sqLiteDatabase.insert(TABLE_NAME,null,contentValues);

              if(x>0)

                  return true;

             else

                 return false;
    }


      public ArrayList<String> getFirstName()
        {

            ArrayList<String> arrayList=new ArrayList<>();

            String query="SELECT name FROM " + TABLE_NAME;

            SQLiteDatabase sqLiteDatabase=this.getReadableDatabase();


            Cursor cursor= sqLiteDatabase.rawQuery(query,null);

            if(cursor!=null)
            {
                cursor.moveToFirst();

                do {

                    String name=cursor.getString(cursor.getColumnIndex("name"));

                    arrayList.add(name);

                }
                while(cursor.moveToNext());

                cursor.close();

                return arrayList;
            }


            return null;

        }

           public StringBuilder getSingleContact(String name)
              {
                  StringBuilder stringBuilder=new StringBuilder();


                  String query = "SELECT * FROM " + TABLE_NAME + " WHERE name LIKE '" + name + "%'";

                  SQLiteDatabase sqLiteDatabase=this.getReadableDatabase();

                  Cursor cursor=sqLiteDatabase.rawQuery(query,null);


                  if(cursor!=null)
                  {

                      cursor.moveToFirst();

                      do {

                        int id=  cursor.getInt(cursor.getColumnIndex("id"));

                          stringBuilder.append("ID :"+id).append("\n");


                          String sName=cursor.getString(cursor.getColumnIndex("name"));

                          stringBuilder.append("Name :"+sName).append("\n");


                          long number =cursor.getLong(cursor.getColumnIndex("number"));

                          stringBuilder.append("Number:"+number).append("\n");


                          String email=cursor.getString(cursor.getColumnIndex("email"));

                          stringBuilder.append("Email:"+email).append("\n");

                          String city=cursor.getString(cursor.getColumnIndex("city"));

                          stringBuilder.append("City:"+city).append("\n");


                      }
                      while (cursor.moveToNext());

                      cursor.close();
                      return stringBuilder;
                  }

                  return null;

              }
}
