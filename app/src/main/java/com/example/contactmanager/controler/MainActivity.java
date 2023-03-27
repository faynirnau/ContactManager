package com.example.contactmanager.controler;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;

import com.example.contactmanager.R;
import com.example.contactmanager.modele.AdapterRecycleV;
import com.example.contactmanager.modele.Bdd;
import com.example.contactmanager.modele.Contact;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

public class MainActivity extends AppCompatActivity {
    RecyclerView contactList;
    AsyncTask<ArrayList<Contact>, Void, ArrayList<Contact>> contacts;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Bdd bdd = new Bdd();
        contacts = bdd.execute();
        try {
            String dataSet = contacts.get().get(0).getFirstname().toString();
            Log.d("bdd", dataSet);
        } catch (ExecutionException | InterruptedException e) {
            throw new RuntimeException(e);
        }
        contactList = findViewById(R.id.recycleViewContacts);
        contactList.setAdapter(new AdapterRecycleV());
    }
}