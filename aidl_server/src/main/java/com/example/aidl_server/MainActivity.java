package com.example.aidl_server;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.aidl_server.view.PersonRecyclerAdapter;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    List<Person> personList = new ArrayList<>();
    PersonDatabase personDatabase;
    private RecyclerView rvPersonList;
    private PersonRecyclerAdapter adapter;
    private RecyclerView.LayoutManager layoutManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bindRecyclerView();
    }

    private void bindRecyclerView() {
        personList = personDatabase.getPeople();

        rvPersonList = findViewById(R.id.rvPersonList);
//        adapter = new PersonRecyclerAdapter(PersonGenerator.generate(20));
        adapter = personList;
        layoutManager = new LinearLayoutManager(this);
        rvPersonList.setAdapter(adapter);
        rvPersonList.setLayoutManager(layoutManager);
    }

}
