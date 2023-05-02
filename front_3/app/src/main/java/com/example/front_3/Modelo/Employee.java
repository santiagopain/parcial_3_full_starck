package com.example.front_3.Modelo;

public class Employee {



    private long id;
    private String email;
    private String first_Name;
    private String last_Name;


    public Employee() {
    }


    public Employee(long id, String email, String first_Name, String last_Name) {
        this.id = id;
        this.email = email;
        this.first_Name = first_Name;
        this.last_Name = last_Name;
    }


    public long getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getFirst_name() {
        return first_Name;
    }

    public String getLast_name() {
        return last_Name;
    }


    public void setId(long id) {
        this.id = id;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setFirst_name(String first_name) {
        this.first_Name = first_name;
    }

    public void setLast_name(String last_name) {
        this.last_Name = last_name;
    }
}
