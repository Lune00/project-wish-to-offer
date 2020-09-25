package com.example.entities;

import java.util.Date;

public final class Person {

    private final String LastName;
    private final String FirstName;
    private final String Pseudo;
    private final Date Birthday;

    public Person(String LastName, String FirstName, String Pseudo, Date Birthday) {
        this.LastName = LastName;
        this.FirstName = FirstName;
        this.Pseudo = Pseudo;
        this.Birthday = new Date(Birthday.getTime());
    }

    public Date getBirthday() {
        return new Date(this.Birthday.getTime());
    }

    public String getLastName() {
        return LastName;
    }

    public String getFirstName() {
        return FirstName;
    }

    public String getPseudo() {
        return Pseudo;
    }
}
