package com.carllewis14.retrofitjsonobject.DataModel;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Contact model class
 */

public class ContactList {

    @SerializedName("contacts")
    @Expose
    private ArrayList<Contact> contacts = new ArrayList<>();

    /**
     * @return The contacts
     */
    public ArrayList<Contact> getContacts() {
        return contacts;
    }

    /**
     * @param contacts The contacts
     */
    public void setContacts(ArrayList<Contact> contacts) {
        this.contacts = contacts;
    }
}
