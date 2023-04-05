package com.example.contactmanager.modele;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.contactmanager.R;
import java.util.ArrayList;

public class AdapterRecycleV extends RecyclerView.Adapter<AdapterRecycleV.ViewHolder> {

    private final Context context;
    private ArrayList<Contact> contacts;

    public AdapterRecycleV(Context context, ArrayList<Contact> contacts){
        this.context = context;
        setContacts(contacts);
    }
    public void setContacts(ArrayList<Contact> contacts){
        this.contacts = contacts;
    }
    public static class ViewHolder extends RecyclerView.ViewHolder {
        private final TextView textView;

        public ViewHolder(View view) {
            super(view);
            // Define click listener for the ViewHolder's View

            textView = (TextView) view.findViewById(R.id.adapterContent);
        }

        public TextView getTextView() {
            return textView;
        }
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.adapter_layout, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        String contact = contacts.get(position).getFirstname() +" "+ contacts.get(position).getLastname();
        holder.getTextView().setText(contact);

    }

    @Override
    public int getItemCount() {
        return contacts.size();
    }
}
