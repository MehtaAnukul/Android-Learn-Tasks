package com.example.hitmer.officeexamapp;

public class Contact {
    String id,first_name,last_name,phone_number,email;

    public String getId() {
        return id;
    }

    public String getFirstName() {
        return first_name;
    }

    public String getLastName() {
        return last_name;
    }

    public String getPhoneNumber() {
        return phone_number;
    }

    public String getEmail() {
        return email;
    }

    public Contact(String id, String first_name, String last_name, String phone_number, String email) {

        this.id = id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.phone_number = phone_number;
        this.email = email;
    }
}
