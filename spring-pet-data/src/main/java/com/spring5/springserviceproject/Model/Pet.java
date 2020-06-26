package com.spring5.springserviceproject.Model;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;


@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "pet")
public class Pet extends BaseEntity{

    @Builder
    public Pet(String name, LocalDate localDate, PetType petType, Owner owner, Set<Visit> visits, Long id){
        super(id);
        this.name = name;
        this.birthday = localDate;
        this.petType = petType;
        this.owner = owner;
        this.visits = visits;
    }
    @Column(name = "name")
    private String name;

    @Column(name = "birthday")
    private LocalDate birthday ;

    @ManyToOne
    @JoinColumn(name = "type_id")
    private PetType petType;

    @ManyToOne
    @JoinColumn(name = "owner_id")
    private Owner owner;

    @OneToMany(cascade = CascadeType.ALL, mappedBy =
    "pet")
    private Set<Visit> visits = new HashSet<>();

}
