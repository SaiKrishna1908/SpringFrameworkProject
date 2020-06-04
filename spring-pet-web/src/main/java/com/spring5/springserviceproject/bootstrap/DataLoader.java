package com.spring5.springserviceproject.bootstrap;

import com.spring5.springserviceproject.Model.*;
import com.spring5.springserviceproject.Service.OwnerService;
import com.spring5.springserviceproject.Service.PetTypeService;
import com.spring5.springserviceproject.Service.SpecialityService;
import com.spring5.springserviceproject.Service.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;
    private final SpecialityService specialityService;

    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService, SpecialityService specialityService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
        this.specialityService = specialityService;
    }

    @Override
    public void run(String... args) throws Exception {

        int count = petTypeService.findAll().size();

        if(count == 0) {
            loadData();
        }
    }

    private void loadData() {
        Owner owner1 = new Owner();
        owner1.setFirstName("Jackson");
        owner1.setSecondName("Florence");
        owner1.setAddress("7th street ");
        owner1.setCity("Hyderabad");
        owner1.setTelephone("123897590");


        PetType petType1 = new PetType();
        petType1.setName("Dog");

        Pet pet1 = new Pet();
        pet1.setPetType(petType1);
        pet1.setBirthday(LocalDate.now());
        pet1.setOwner(owner1);
        pet1.setName("Simba");

        owner1.getPets().add(pet1);

        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setFirstName("Plimbo");
        owner2.setSecondName("dumbo");
        owner2.setAddress("7th street ");
        owner2.setCity("Hyderabad");
        owner2.setTelephone("123897590");

        PetType petType2 = new PetType();
        petType2.setName("Cat");

        Pet pet2 = new Pet();
        pet2.setPetType(petType2);
        pet2.setBirthday(LocalDate.now());
        pet2.setOwner(owner2);
        pet2.setName("Apollo");

        owner2.getPets().add(pet2);

        ownerService.save(owner2);

        System.out.println("Loaded Owner's ...");

        Vet vet1 = new Vet();

        Speciality radiology = new Speciality();
        radiology.setDescription("Radiology");
        Speciality savedRadiology = specialityService.save(radiology);

        Speciality dentistry = new Speciality();
        dentistry.setDescription("Densitry");
        Speciality savedDentistry = specialityService.save(dentistry);

        Speciality surgery = new Speciality();
        surgery.setDescription("Surgery");
        Speciality savedSurgery = specialityService.save(surgery);


        vet1.setFirstName("Payqwe");
        vet1.setSecondName("doom");
        vet1.getSpecialitySet().add(savedRadiology);

        vetService.save(vet1);

        Vet vet2 = new Vet();

        vet2.setFirstName("Leo");
        vet2.setSecondName("cabin");
        vet2.getSpecialitySet().add(savedSurgery);

        vetService.save(vet2);

        System.out.println("Loaded Vet's ...");

        PetType dog = new PetType();
        dog.setName("Dog");

        petTypeService.save(dog);

        PetType cat = new PetType();
        cat.setName("Cat");

        petTypeService.save(cat);

        System.out.println("Loaded PetType's ...");
    }
}
