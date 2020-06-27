package com.spring5.springserviceproject.Model;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;


@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "type")
public class PetType extends BaseEntity{

    @Builder
    public PetType(Long id, String name){
        super(id);
        this.name = name;
    }
    @Column(name = "name")
    String name;

    @Override
    public String toString() {
        return name ;
    }
}
