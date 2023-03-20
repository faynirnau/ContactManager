package com.example.contactmanager.controler;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.contactmanager.R;

public class MainActivity extends AppCompatActivity {
    RecyclerView contactList;
    RecyclerView.Adapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        contactList.findViewById(R.id.recycleViewContacts);
        contactList.setAdapter(adapter);
        System.out.println("helo");
    }
}