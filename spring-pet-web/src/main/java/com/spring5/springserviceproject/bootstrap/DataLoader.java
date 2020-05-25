package com.spring5.springserviceproject.bootstrap;

import com.spring5.springserviceproject.Model.Owner;
import com.spring5.springserviceproject.Model.Vet;
import com.spring5.springserviceproject.Service.OwnerService;
import com.spring5.springserviceproject.Service.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;


    public DataLoader(OwnerService ownerService , VetService vetService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
    }

    @Override
    public void run(String... args) throws Exception {

        Owner owner1 = new Owner();
        owner1.setFirstName("Jackson");
        owner1.setSecondName("Florence");


        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setFirstName("Plimbo");
        owner2.setSecondName("dumbo");


        ownerService.save(owner2);

        System.out.println("Loaded Owner's ...");

        Vet vet1 = new Vet();

        vet1.setFirstName("Payqwe");
        vet1.setSecondName("doom");
        vetService.save(vet1);

        Vet vet2 = new Vet();

        vet2.setFirstName("Leo");
        vet2.setSecondName("cabin");


        vetService.save(vet2);

        System.out.println("Loaded Vet's ...");
    }
}
