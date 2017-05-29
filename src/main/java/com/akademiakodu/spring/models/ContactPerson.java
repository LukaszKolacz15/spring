package com.akademiakodu.spring.models;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.Size;

/**
 * Created by Lukasz Kolacz on 29.05.2017.
 */
public class ContactPerson {
    @NotEmpty
    @Size(min = 5, max = 25)
    private String conName;

    @NotEmpty
    @Size(min = 5, max = 25)
    private String conLastname;

    @NotEmpty
    @Email
    private String conEmail;

    @NotEmpty
    private String conTextarea;


    public ContactPerson() {
    }


    public ContactPerson(ConBuilder conBuilder) {
        conName = conBuilder.conName;
        conLastname = conBuilder.conLastname;
        conEmail = conBuilder.conEmail;
        conTextarea = conBuilder.conTextarea;
    }


    public String getConName() {
        return conName;
    }

    public void setConName(String conName) {
        this.conName = conName;
    }

    public String getConLastname() {
        return conLastname;
    }

    public void setConLastname(String conLastname) {
        this.conLastname = conLastname;
    }

    public String getConEmail() {
        return conEmail;
    }

    public void setConEmail(String conEmail) {
        this.conEmail = conEmail;
    }

    public String getConTextarea() {
        return conTextarea;
    }

    public void setConTextarea(String conTextarea) {
        this.conTextarea = conTextarea;
    }


    public static class ConBuilder {
        private String conName;
        private String conLastname;
        private String conEmail;
        private String conTextarea;

        public ConBuilder(String conName) {
            this.conName = conName;
        }

        public ConBuilder conLastname(String conLastname) {
            this.conLastname = conLastname;
            return this;
        }

        public ConBuilder conEmail(String conEmail) {
            this.conEmail = conEmail;
            return this;
        }

        public ConBuilder conTextarea(String conTextarea) {
            this.conTextarea = conTextarea;
            return this;
        }


        public ContactPerson build() {
            return new ContactPerson(this);
        }

    }
}
