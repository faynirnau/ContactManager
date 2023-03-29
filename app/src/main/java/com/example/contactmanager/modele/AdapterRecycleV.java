package com.example.contactmanager.modele;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.contactmanager.R;
import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

public class AdapterRecycleV extends RecyclerView.Adapter<AdapterRecycleV.ViewHolder> {

    private final Context context;
    private final AsyncTask<ArrayList<Contact>, Void, ArrayList<Contact>> contacts;

    public AdapterRecycleV(Context context, AsyncTask<ArrayList<Contact>, Void, ArrayList<Contact>> contacts){
        this.context = context;
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
        try {
            String contact = contacts.get().get(position).getFirstname() +" "+ contacts.get().get(position).getLastname();
            holder.getTextView().setText(contact);
        } catch (ExecutionException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public int getItemCount() {
        try {
            return contacts.get().size();
        } catch (ExecutionException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
