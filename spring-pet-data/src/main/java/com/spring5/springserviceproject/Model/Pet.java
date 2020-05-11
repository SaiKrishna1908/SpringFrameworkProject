package com.spring5.springserviceproject.Model;

import java.time.LocalDate;

public class Pet extends BaseEntity{

    private LocalDate birthday ;
    private PetType petType;
    private Owner owner;

}
