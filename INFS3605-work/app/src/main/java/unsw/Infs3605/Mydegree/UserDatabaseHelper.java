package unsw.Infs3605.Mydegree;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class UserDatabaseHelper extends SQLiteOpenHelper {
    private static final int DB_VERSION = 7;
    public static final String DB_NAME="students.db";
    public static final String TABLE_NAME="students";
    public static final String COL_1="ID";
    public static final String COL_2="username";
    public static final String COL_3="password";
    public static final String COL_4="points";
    public static final String COL_5="icon";
    private SQLiteDatabase dbase;

    public UserDatabaseHelper(Context context) {
        super(context, DB_NAME,null,DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS students (ID INTEGER PRIMARY KEY AUTOINCREMENT, username TEXT, password TEXT, points INTEGER,icon INTEGER)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS "+ TABLE_NAME);
        onCreate(sqLiteDatabase);
    }

    public long addStudent(String user,String password){
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues contentValues= new ContentValues();
        contentValues.put("username",user);
        contentValues.put("password",password);
        contentValues.put("points",0);
        contentValues.put("icon",0);
        long res=db.insert("students",null,contentValues);
        db.close();
        return res;
    }

    public void updateicon1(String username) {
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "UPDATE " + TABLE_NAME + " SET " + COL_5 +
                " = " + 1 + " WHERE " + COL_2 + " = '" + username + "'";
        db.execSQL(query);
    }

    public void updateicon2(String username) {
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "UPDATE " + TABLE_NAME + " SET " + COL_5 +
                " = " + 2 + " WHERE " + COL_2 + " = '" + username + "'";
        db.execSQL(query);
    }

    public void updateicon3(String username) {
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "UPDATE " + TABLE_NAME + " SET " + COL_5 +
                " = " + 3 + " WHERE " + COL_2 + " = '" + username + "'";
        db.execSQL(query);
    }

    public void updateicon4(String username) {
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "UPDATE " + TABLE_NAME + " SET " + COL_5 +
                " = " + 4 + " WHERE " + COL_2 + " = '" + username + "'";
        db.execSQL(query);
    }

    public void updateicon5(String username) {
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "UPDATE " + TABLE_NAME + " SET " + COL_5 +
                " = " + 5 + " WHERE " + COL_2 + " = '" + username + "'";
        db.execSQL(query);
    }

    public void updateicon6(String username) {
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "UPDATE " + TABLE_NAME + " SET " + COL_5 +
                " = " + 0 + " WHERE " + COL_2 + " = '" + username + "'";
        db.execSQL(query);
    }

    public int getIcon (String usr) {
        dbase = this.getReadableDatabase();
        int icon = 0;
        String selectQuery = "SELECT icon FROM " + TABLE_NAME + " WHERE " + COL_2 + "='" + usr + "'";
        Cursor cursor = dbase.rawQuery(selectQuery, null);
        if (cursor.moveToFirst()) {
            icon = cursor.getInt(cursor.getColumnIndex("icon"));
        }
        return icon;
    }

    public void updatepoint(String username) {
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "UPDATE " + TABLE_NAME + " SET " + COL_4 +
                " = " + COL_4+ "+10" + " WHERE " + COL_2 + " = '" + username + "'";
        db.execSQL(query);
    }

    public void updatepoint01(String username) {
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "UPDATE " + TABLE_NAME + " SET " + COL_4 +
                " = " + COL_4+ "+1" + " WHERE " + COL_2 + " = '" + username + "'";
        db.execSQL(query);
    }


    public int getPoints (String usr) {
        dbase = this.getReadableDatabase();
        int points = 0;
        String selectQuery = "SELECT points FROM " + TABLE_NAME + " WHERE " + COL_2 + "='" + usr + "'";
        Cursor cursor = dbase.rawQuery(selectQuery, null);
        if (cursor.moveToFirst()) {
            points = cursor.getInt(cursor.getColumnIndex("points"));
        }
        return points;
    }

    public boolean checkUsers(String username, String password){

        String[] columns={COL_1};
        SQLiteDatabase db=getReadableDatabase();
        String selection=COL_2 + "=?" + " and " + COL_3 + "=?";
        String[] selectionArgs = {username, password };
        Cursor cursor=db.query(TABLE_NAME,columns,selection,selectionArgs,null,null,null);
        int count=cursor.getCount();
        cursor.close();
        db.close();
        if(count>0)
            return true;
        else
            return false;

    }
}

