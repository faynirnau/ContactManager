package com.example.contactmanager.controler;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.ImageButton;

import com.example.contactmanager.R;
import com.example.contactmanager.modele.AdapterRecycleV;
import com.example.contactmanager.modele.Bdd;
import com.example.contactmanager.modele.Contact;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

public class MainActivity extends AppCompatActivity {
    static RecyclerView contactList;
    static ArrayList<Contact> contacts;
    ImageButton addContactButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Retire la barre de titre du layout de l'application.
        this.supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);
        contactList = findViewById(R.id.recycleViewContacts);
        //Accede à la base de données et teste la récupération.
        Bdd bdd = new Bdd();
        try {
            contacts = bdd.execute().get();
//            for (Contact contact:
//                    contacts.get()){
//                Log.d("BDD", contact.getFirstname());
//                Log.d("BDD", contact.getLastname());
//                Log.d("BDD", contact.getEmail());
//                Log.d("BDD", contact.getPhoneNumber());
//            }
            contactList.setAdapter(new AdapterRecycleV(this, contacts));
            contactList.setLayoutManager(new LinearLayoutManager(this));

            addContactButton = findViewById(R.id.imageButtonAddContact);
            addContactButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(MainActivity.this, AddContactActivity.class);
                    startActivity(intent);
                }
            });
        } catch (ExecutionException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}