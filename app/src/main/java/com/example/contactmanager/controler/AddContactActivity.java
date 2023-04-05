package com.example.contactmanager.controler;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

import com.example.contactmanager.R;
import com.example.contactmanager.modele.AdapterRecycleV;
import com.example.contactmanager.modele.Contact;

import java.util.ArrayList;

public class AddContactActivity extends AppCompatActivity {
    ImageButton backButton;
    EditText lastname;
    EditText firstname;
    EditText emailAddress;
    EditText phoneNumber;
    Button addContact;
    ArrayList<Contact> contactList = MainActivity.contacts;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_add_contact);
        //Création des instances de mes éléments de layout.
        backButton = findViewById(R.id.imageButtonBackButton);
        lastname = findViewById(R.id.editTextTextPersonLastname);
        firstname = findViewById(R.id.editTextTextPersonFirstname);
        emailAddress = findViewById(R.id.editTextTextEmailAddress);
        phoneNumber = findViewById(R.id.editTextPhone);
        addContact = findViewById(R.id.buttonAddContact);
        //Ajout d'un contact dans la liste de contacts avec les données renseignées, en objet.
        addContact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                contactList.add(new Contact(
                        contactList.size() + 1,
                        firstname.getText().toString(),
                        lastname.getText().toString(),
                        emailAddress.getText().toString(),
                        phoneNumber.getText().toString()
                ));
                //Vérification de la bonne création de l'objet.
                for (Contact contact :
                        contactList) {
                    Log.d("Contact", contact.getId().toString());
                    Log.d("Contact", contact.getFirstname());
                    Log.d("Contact", contact.getLastname());
                    Log.d("Contact", contact.getEmail());
                    Log.d("Contact", contact.getPhoneNumber());
                }
                Intent resultIntent = new Intent(AddContactActivity.this,MainActivity.class);
                resultIntent.putExtra("updatedData", contactList);
                setResult(Activity.RESULT_OK, resultIntent);
                startActivity(resultIntent);
                finish();
            }
        });


        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AddContactActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });

    }

}