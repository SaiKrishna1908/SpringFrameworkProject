package com.spring5.springserviceproject.Model;

import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;


@Setter
@Getter
@NoArgsConstructor
@Entity
@Table(name = "vet")
public class Vet extends Person{

    public Vet(String firstName, String lastName, Long id, Set<Speciality> specialities){
        super(id, firstName,lastName);
        this.specialitySet = specialities;
    }
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "vet_specialities", joinColumns = @JoinColumn(name = "vet_id"), inverseJoinColumns = @JoinColumn(name = "specialties_id"))
    Set<Speciality> specialitySet = new HashSet<>();

}
