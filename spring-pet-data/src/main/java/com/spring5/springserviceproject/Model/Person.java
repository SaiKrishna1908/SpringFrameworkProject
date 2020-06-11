package com.spring5.springserviceproject.Model;


import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.Table;

@MappedSuperclass
public class Person  extends  BaseEntity{

    private String firstName;

    private String secondName;

    //Default Constructor
    public Person() { }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }


}
