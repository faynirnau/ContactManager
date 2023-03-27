package com.example.contactmanager.controler;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import android.os.Bundle;
import com.example.contactmanager.R;
import com.example.contactmanager.modele.AdapterRecycleV;
import com.example.contactmanager.modele.Bdd;

public class MainActivity extends AppCompatActivity {
    RecyclerView contactList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Bdd bdd = new Bdd();
        bdd.execute();
        contactList = findViewById(R.id.recycleViewContacts);
        contactList.setAdapter(new AdapterRecycleV());
    }
}