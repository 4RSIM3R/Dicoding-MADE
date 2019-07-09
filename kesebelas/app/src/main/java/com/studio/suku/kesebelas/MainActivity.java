package com.studio.suku.kesebelas;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;
import android.widget.Toolbar;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private RecyclerView list;
    private ArrayList<Pemain> data = new ArrayList<>();
    private String title = "Mode List";
    final String STATE_TITLE = "state_string";
    final String STATE_LIST = "state_list";
    final String STATE_MODE = "state_mode";
    int mode;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        list = findViewById(R.id.list);
        list.setHasFixedSize(true);



        //Kita Panggil Adapter nya yahhhh -> Buatin fungsi Sendiri - sendiri
        data.addAll(PemainsData.getListData());
        tampilkeun();
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.action_list:
                tampilkeun();
                setActionBarTitle("Ini List");
                break;
            case R.id.action_grid:
                gridakuen();
                setActionBarTitle("Ini Grid");
                break;
            case R.id.action_cardview:
                cardakeun();
                setActionBarTitle("Ini Card");
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    private void setActionBarTitle(String title){
        getSupportActionBar().setTitle(title);
    }

    private void tampilkeun(){
        list.setLayoutManager(new LinearLayoutManager(this));
        ListPemainAdapter adapter = new ListPemainAdapter();
        adapter.setListPemain(data);
        list.setAdapter(adapter);


    }

    private void gridakuen(){
        //Ini yang membuat Mereka Jadi Grid yah
        list.setLayoutManager(new GridLayoutManager(this, 2));
        GridPemainAdapter adapter = new GridPemainAdapter(this);
        adapter.setPemains(data);
        list.setAdapter(adapter);

    }

    private void cardakeun(){
        list.setLayoutManager(new LinearLayoutManager(this));
        CardPemainAdapter adapter = new CardPemainAdapter(this);
        adapter.setPemains(data);
        list.setAdapter(adapter);
    }
}
