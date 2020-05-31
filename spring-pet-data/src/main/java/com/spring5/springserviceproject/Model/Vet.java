package com.spring5.springserviceproject.Model;

import java.util.Set;

public class Vet extends Person{

    Set<Speciality> specialitySet;

    public Set<Speciality> getSpecialitySet() {
        return specialitySet;
    }

    public void setSpecialitySet(Set<Speciality> specialitySet) {
        this.specialitySet = specialitySet;
    }
}
