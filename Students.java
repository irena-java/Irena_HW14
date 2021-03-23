package com.company;

import java.time.LocalDate;

public class Students {
    private String name;
    private String middleName;
    private String surName;
    private LocalDate birthday;
    private String contacts;
    private Group.CourcesName courcesName;

    public Students(String name, String middleName, String surname, LocalDate birthday,
                    String contacts, Group.CourcesName courcesName) {
        this.setName(name);
        this.setMiddleName(middleName);
        this.setSurname(surname);
        this.setBirthday(birthday);
        this.setContacts(contacts);
        this.courcesName = courcesName;
    }

    public void setName(String name) {
        if (name.contains(" ")) {
            throw new IllegalArgumentException("Имя не должно содержать пробел");
        } else {
            this.name = name;
        }
    }

    public void setMiddleName(String middleName) {
        if (middleName.contains(" ")) {
            throw new IllegalArgumentException("Отчество не должно содержать пробел");
        } else {
            this.middleName = middleName;
        }
    }

    public void setSurname(String surname) {
        if (surname.contains(" ")) {
            throw new IllegalArgumentException("Фамилия не должно содержать пробел");
        } else {
            this.surName = surname;
        }
    }

    public void setBirthday(LocalDate birthday) {
        if (birthday.isAfter(LocalDate.now().minusYears(18))) {
            throw new IllegalArgumentException("сильно молодой, с 18 лет");
        } else {
            this.birthday = birthday;
        }
    }

    public void setContacts(String contacts) {
        if (contacts.length() < 10) {
            throw new IllegalArgumentException("нужен как минимум номер телефона");
        } else {
            this.contacts = contacts;
        }
    }

    public String getName() {
        return name;
    }

    public String getMiddleName() {
        return middleName;
    }

    public String getSurName() {
        return surName;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public String getContacts() {
        return contacts;
    }

    public Group.CourcesName getCourcesName() {
        return courcesName;
    }

    @Override
    public String toString() {
        return "Students{" +
                "name='" + name + '\'' +
                ", middleName='" + middleName + '\'' +
                ", surName='" + surName + '\'' +
                ", birthday=" + birthday +
                ", contacts='" + contacts + '\'' +
                ", courcesName= " + courcesName + "\n";
    }
}
