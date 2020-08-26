package com.frh.mvvmsample2.View;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.frh.mvvmsample2.Model.PersonModel;
import com.frh.mvvmsample2.R;
import com.frh.mvvmsample2.ViewModel.TransactionViewModel;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    PersonAdapter personAdapter;
    RecyclerView.LayoutManager layoutManager;
    TransactionViewModel personViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.recyclerview);

        personViewModel = new ViewModelProvider(this).get(TransactionViewModel.class);
        personViewModel.setData(personViewModel);

        personAdapter = new PersonAdapter();
        layoutManager = new LinearLayoutManager(MainActivity.this, LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);

        personViewModel.getLiveData().observe(this, new Observer<ArrayList<PersonModel>>() {
            @Override
            public void onChanged(ArrayList<PersonModel> personModels) {
                Log.e("tag", "onChanged: " + personModels.size() );
                personAdapter.setData(personModels);
            }
        });

        recyclerView.setAdapter(personAdapter);

    }
}