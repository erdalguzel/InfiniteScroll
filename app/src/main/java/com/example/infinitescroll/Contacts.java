package com.example.infinitescroll;

import java.util.ArrayList;

public class Contacts {

    private static int lastContactId = 0;
    private String mName;
    private boolean mOnline;

    public Contacts(String mName, boolean mOnline) {
        this.mName = mName;
        this.mOnline = mOnline;
    }

    public static ArrayList<Contacts> createContacts(int numContacts) {
        ArrayList<Contacts> contacts = new ArrayList<>();

        for (int i = 0; i <= numContacts; i++) {
            Contacts contact = new Contacts("Person" + lastContactId++, i <= numContacts / 2);
            contacts.add(contact);
        }
        return contacts;
    }

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        this.mName = name;
    }

    public boolean getOnlineStatus() {
        return mOnline;
    }

    public void setOnlineStatus(boolean status) {
        this.mOnline = status;
    }
}
