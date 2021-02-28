package com.example.contactinfo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainActivity extends AppCompatActivity implements AddContactDialogListener{
    RecyclerView recyclerView;
    ContactAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);
        ContactSource contacts = new ContactSource();

        adapter = new ContactAdapter(contacts.getContacts());
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        FloatingActionButton fab = findViewById(R.id.floatingActionButton);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fm = getSupportFragmentManager();
                AddContactFragment addContactFragment = AddContactFragment.newInstance();
                addContactFragment.show(fm, "fragment_dialog");
            }
        });
    }

    @Override
    public void onFinishAddDialog(Contact contact) {
        adapter.addContact(contact);
    }
}
