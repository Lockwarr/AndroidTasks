package com.example.contactinfo;

import java.util.ArrayList;

public class ContactSource {
    ArrayList<Contact> contacts;

    public ContactSource() {
        contacts = new ArrayList<Contact>() {{
                add(new Contact("Ivan", "Str: \"Stara Planina\"", "https://weetracker.com/wp-content/uploads/2018/09/default-user-icon-profile.png"));
                add(new Contact("Stefan", "Str: \"Pirin\"", "https://weetracker.com/wp-content/uploads/2018/09/default-user-icon-profile.png"));
            }};
        }

    public ArrayList<Contact> getContacts() {
        return contacts;
    }
}
