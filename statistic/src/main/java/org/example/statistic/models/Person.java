package org.example.statistic.models;

public class Person {
    private String name;
    private String surname;
    private String secondName;

    private Person(String name, String secondName, String surname) {
        this.name = name;
        this.secondName = secondName;
        this.surname = surname;
    }

    // Factory method
    public static Person buildPerson(String nameSurname) {
        String[] parts = nameSurname.split(" ");

        // Gestione dei casi in cui il nome completo abbia meno di 3 elementi
        String name = parts.length > 0 ? parts[0] : "";
        String secondName = parts.length > 1 ? parts[1] : "";
        String surname = parts.length > 2 ? parts[2] : "";

        return new Person(name, secondName, surname);
    }

    public String getName() {
        return name;
    }

    public String getSecondName() {
        return secondName;
    }

    public String getSurname() {
        return surname;
    }
}
