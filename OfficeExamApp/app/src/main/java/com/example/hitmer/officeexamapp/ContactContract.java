package com.example.hitmer.officeexamapp;

public final class ContactContract {

    private ContactContract(){}

    public static class contactEntry{
        public static final String TABLE_NAME = "contact_info";
        public static final String CONTACT_ID = "contact_id";
        public static final String FIRSTNAME = "first_name";
        public static final String LASTNAME = "last_name";
        public static final String PHONENO = "phoneno";
        public static final String EMAIL = "email";

    }
}
