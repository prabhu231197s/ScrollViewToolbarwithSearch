package com.example.prabhusivanandam.scrollviewtoolbar;

import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements SearchView.OnQueryTextListener {

    Toolbar t;
    ArrayList<Model> x=new ArrayList<>();
    Adapter adapter;
    RecyclerView v;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        t=(Toolbar)findViewById(R.id.t);
        setSupportActionBar(t);
        v=(RecyclerView)findViewById(R.id.rv);
        Model m=new Model("Hello","hai","vaadaa");
        RecyclerView.LayoutManager layoutManager=new LinearLayoutManager(this);
        x.add(m);
        x.add(m);
        x.add(m);
        x.add(m); x.add(m); x.add(m); x.add(m); x.add(m); x.add(m); x.add(m); x.add(m); x.add(m); x.add(m); x.add(m); x.add(m); x.add(m); x.add(m); x.add(m); x.add(m);
        v.setLayoutManager(layoutManager);
        adapter=new Adapter(x);
        v.setAdapter(adapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_items,menu);
        MenuItem item=menu.findItem(R.id.action_search);
        SearchView searchView=(SearchView) MenuItemCompat.getActionView(item);
        searchView.setOnQueryTextListener(this);
        return true;
    }

    @Override
    public boolean onQueryTextSubmit(String query) {
        return false;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        newText=newText.toLowerCase();
        ArrayList<Model> c=new ArrayList<>();
        for(Model b: x)
        {
            if(b.getName().toLowerCase().contains(newText))
            {
                c.add(b);
            }
        }
       adapter.setFilter(c);
        return true;
    }
}
