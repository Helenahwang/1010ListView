package com.appdev.a503_02.a1010listview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.GridView;

public class GridViewCreate extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid_view_create);

        GridView gridView = (GridView)findViewById(R.id.gridView);
        ImageAdapterCreate adapter = new ImageAdapterCreate(this);
        gridView.setAdapter(adapter);
    }
}
