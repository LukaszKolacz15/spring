package com.akademiakodu.spring.models;

import com.akademiakodu.spring.models.forms.PersonForm;
import com.sun.javafx.beans.IDProperty;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Created by Lukasz Kolacz on 30.05.2017.
 */

@Entity
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;
    private String lastname;
    private int age;
    private String number;
    private String email;

    public Person(ContactPerson contactPerson) {
    }

    public Person(PersonForm personForm) {
        name = personForm.getName();
        lastname = personForm.getLastname();
        age = personForm.getAge();
        number = personForm.getNumber();
        email = personForm.getEmail();
    }

    public Person(String name, String lastname, int age, String number, String email) {
        this.name = name;
        this.lastname = lastname;
        this.age = age;
        this.number = number;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
