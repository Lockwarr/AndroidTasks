package com.example.contactinfo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ContactAdapter extends RecyclerView.Adapter<ContactViewHolder>{
    private ArrayList<Contact> contacts;

    public ContactAdapter(ArrayList<Contact> contacts) {
        this.contacts = contacts;
    }

    @NonNull
    @Override
    public ContactViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        View canimalView = inflater.inflate(R.layout.contact_item, parent, false);

        return new ContactViewHolder(canimalView);
    }

    @Override
    public void onBindViewHolder(@NonNull ContactViewHolder holder, int position) {
        Contact contact = contacts.get(position);

        holder.setName(contact.getName());
        holder.setType(contact.getAddress());
        holder.setImage(contact.getImageUrl());
    }

    @Override
    public int getItemCount() {
        return contacts.size();
    }

    public void addContact(Contact contact) {
        contacts.add(contacts.size(),contact);
        notifyItemChanged(0);
    }
}
