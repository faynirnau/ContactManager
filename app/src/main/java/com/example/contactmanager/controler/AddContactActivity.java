package com.example.contactmanager.controler;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;

import com.example.contactmanager.R;

public class AddContactActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_add_contact);
    }

}