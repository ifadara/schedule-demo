package com.example.ScheduleDemo.Entities;


import javax.persistence.Entity;

import javax.persistence.Id;
import javax.persistence.Table;

    @Entity
    @Table(name = "emails")
    public class Emails {

        @Id
        private String email;

        public Emails(){}

        public Emails(String email) {
            this.email = email;
        }

        public String getEmails() {
            return email;
        }
    }

