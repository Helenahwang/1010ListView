package com.appdev.a503_02.a1010listview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //SimpleAdapter를 이용해서 출력할 데이터 생성
        //list<Map<String, Object>> 구조
        List<Map<String, String>> list1 = new ArrayList<>();
        Map<String, String> map1 = new HashMap<>();
        map1.put("name","조계현");
        map1.put("alias", "싸움닭");
        list1.add(map1);

        map1 = new HashMap<>();
        map1.put("name","권혁");
        map1.put("alias", "불꽃");
        list1.add(map1);

        //데이터 출력을 위한 Adapter 생성
        //첫번째는 Context
        //두번째는 데이터, 세번째는 셀의 출력모양
        //네번째는 출력할 데이터의 키 배열
        //다섯번째는 출력할 셀 안의 id
        SimpleAdapter adapter = new SimpleAdapter(this, list1, android.R.layout.simple_list_item_2,
                new String[]{"name","alias"}, new int[]{android.R.id.text1, android.R.id.text2});
        ListView listView = (ListView)findViewById(R.id.listView);
        listView.setAdapter(adapter);

    }
}
