package com.appdev.a503_02.a1010listview;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.CursorAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.SimpleCursorAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CreateList extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_list);

        ListView simplelist = (ListView)findViewById(R.id.simplelist);
        ListView cursorlist = (ListView)findViewById(R.id.cursorlist);

        //데이터베이스 사용 클래스의 객체 생성 - onCreate가 호출
        DBOpenHelper helper = new DBOpenHelper(this);

        //데이터베이스에서 읽기 작업
        SQLiteDatabase db = helper.getReadableDatabase();
        Cursor cursor1 = db.rawQuery("select * from tb_data;", null);

        //읽어온 데이터를 List<Map>에 저장하기
        List<Map<String, Object>> list1 = new ArrayList<>();

        while(cursor1.moveToNext()){
            Map<String, Object> map1 = new HashMap<>();
            map1.put("name", cursor1.getString(1));
            map1.put("alias", cursor1.getString(2));
            list1.add(map1);

        }

        db.close();

        //데이터 출력을 위한 Adapter 생성
        //첫번째는 Context
        //두번째는 데이터, 세번째는 셀의 출력모양
        //네번째는 출력할 데이터의 키 배열
        //다섯번째는 출력할 셀 안의 id
        //데이터베이스에서 데이터를 받아 list로 저장 후 출력하는 것 => SimpleAdapter : 데이터 가공을 하고 싶을 때 사용
        SimpleAdapter simpleAdapter = new SimpleAdapter(this, list1, android.R.layout.simple_list_item_2,
                new String[]{"name","alias"}, new int[]{android.R.id.text1, android.R.id.text2});

        simplelist.setAdapter(simpleAdapter);




        //데이터베이스에서 바로 데이터를 받아서 출력하는 것 => CursorAdapter
        CursorAdapter cursorAdapter = new SimpleCursorAdapter(this, android.R.layout.simple_list_item_2, cursor1, new String[]{"name","alias"}, new int[]{android.R.id.text1, android.R.id.text2}, CursorAdapter.FLAG_REGISTER_CONTENT_OBSERVER);
        cursorlist.setAdapter(cursorAdapter);

    }
}
