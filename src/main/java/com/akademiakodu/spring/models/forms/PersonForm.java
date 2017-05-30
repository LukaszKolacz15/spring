package com.akademiakodu.spring.models.forms;


import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

/**
 * Created by Lukasz Kolacz on 29.05.2017.
 */
public class PersonForm {
    @NotEmpty
    @Size(min = 5, max = 25)
    private String name;

    @NotEmpty
    @Size(min = 5, max = 25)
    private String lastname;

    @Range(min=18, max=150)
    private int age;

    @Pattern(regexp = "[0-9]{3}-[0-9]{3}-[0-9]{3}")
    private String number;

    @NotEmpty
    @Email
    private String email;

    public PersonForm() {
    }


    private PersonForm(Builder builder) {
        name = builder.name;
        lastname = builder.lastname;
        age = builder.age;
        number = builder.number;
        email = builder.email;
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

    public static class Builder {
        private String name;
        private String lastname;
        private int age;
        private String number;
        private String email;

        public Builder(String name) {
            this.name = name;
        }

        public Builder lastname(String lastname) {
            this.lastname = lastname;
            return this;
        }

        public Builder age(int age) {
            this.age = age;
            return this;
        }

        public Builder number(String number) {
            this.number = number;
            return this;
        }

        public Builder email(String email) {
            this.email = email;
            return this;
        }

        public PersonForm build() {
            return new PersonForm(this);
        }

    }

}
