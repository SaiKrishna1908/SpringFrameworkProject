package com.spring5.springserviceproject.Model;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;


@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "type")
public class PetType extends BaseEntity{

    @Column(name = "name")
    String name;


}
