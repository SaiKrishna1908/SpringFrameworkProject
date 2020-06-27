package com.spring5.springserviceproject.Model;

import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Setter
@Getter
@NoArgsConstructor
@Entity
@Table(name = "owner")
public class Owner extends Person {

    @Builder
    public Owner(Long id, String firstName, String secondName, String address, String city,
                 String telephone, Set<Pet> pets){
        super(id, firstName, secondName);
        this.address = address;
        this.city = city;
        this.telephone = telephone;
        if(pets != null)
        this.pets = pets;
    }
    @Column(name = "address")
    private String address;

    @Column(name = "city")
    private String city;

    @Column(name = "telephone")
    private String telephone;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "owner")
    @Column(name = "pets")
    private Set<Pet> pets = new HashSet<>();

    public  Pet getPet(String name){
        return getPet(name, false);
    }

    public Pet getPet(String name, Boolean ignoreNew){
        name= name.toLowerCase();
        for(Pet pet : pets){
            if(!ignoreNew || !pet.isNew()){
                String compName = pet.getName();
                if(name.equals(compName)){
                    return pet;
                }
            }
        }
        return  null;
    }

}
