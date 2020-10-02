package com.schuhmacher.models;

import java.util.Date;

public final class Person {

    private final String lastName;
    private final String firstName;
    private final String pseudo;
    private final Date birthday;


    public Person(String firstName, String lastName, String pseudo, Date birthday) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.pseudo = pseudo;
        this.birthday = new Date(birthday.getTime());
    }

    public Date getBirthday() {
        return new Date(this.birthday.getTime());
    }

    public String getLastName() {
        return this.lastName;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public String getPseudo() {
        return this.pseudo;
    }

    @Override
    public String toString() {
        return "Person{" +
                "lastName='" + lastName + '\'' +
                ", firstName='" + firstName + '\'' +
                ", pseudo='" + pseudo + '\'' +
                ", birthday=" + birthday +
                '}';
    }
}
