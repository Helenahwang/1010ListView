package com.appdev.a503_02.a1010listview;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBOpenHelper extends SQLiteOpenHelper {

    //생성자
    public DBOpenHelper(Context context) {
        //첫번째는 Context
        //두번째는 파일명
        //세번째는 Cursor
        //네번째는 버전
        super(context, "data.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table tb_data(_id integer primary key autoincrement, name text, alias text);");
        db.execSQL("insert into tb_data(name,alias) values('블랙핑크제니','제니')");
        db.execSQL("insert into tb_data(name,alias) values('레드벨벳아이린','아이린')");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table tb_data;");
        onCreate(db);

    }
}
