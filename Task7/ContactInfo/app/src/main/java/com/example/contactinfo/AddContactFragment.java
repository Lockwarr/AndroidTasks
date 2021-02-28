package com.example.contactinfo;

import android.app.AlertDialog;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentManager;

public class AddContactFragment extends DialogFragment implements View.OnClickListener {
    private EditText name;
    private EditText address;
    private EditText image;
    private Button add;
    AddContactDialogListener listener;

    public AddContactFragment() { }

    public static AddContactFragment newInstance() {
        return new AddContactFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_dialog, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        name = view.findViewById(R.id.еditText1);
        address = view.findViewById(R.id.еditText2);
        image = view.findViewById(R.id.еditText3);
        add = view.findViewById(R.id.button);
        add.setOnClickListener(this);

        name.requestFocus();

        getDialog().getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_VISIBLE);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        listener = (AddContactDialogListener)context;
    }

    @Override
    public void onClick(View v) {
        Contact contact = new Contact(name.getText().toString(), address.getText().toString(), image.getText().toString());

        listener.onFinishAddDialog(contact);
        dismiss();
    }

}
