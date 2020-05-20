package com.spring5.springserviceproject.bootstrap;

import com.spring5.springserviceproject.MapService.OwnerMapService;
import com.spring5.springserviceproject.MapService.VetMapService;
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

    public DataLoader() {
        this.ownerService = new OwnerMapService();
        this.vetService = new VetMapService();
    }

    @Override
    public void run(String... args) throws Exception {

        Owner owner1 = new Owner();
        owner1.setFirstName("Jackson");
        owner1.setSecondName("Florence");
        owner1.setId(1L);

        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setFirstName("Plimbo");
        owner2.setSecondName("dumbo");
        owner2.setId(2L);

        ownerService.save(owner2);

        System.out.println("Loaded Owner's ...");

        Vet vet1 = new Vet();

        vet1.setFirstName("Payqwe");
        vet1.setFirstName("doom");
        vet1.setId(1L);
        vetService.save(vet1);

        Vet vet2 = new Vet();

        vet2.setFirstName("Leo");
        vet2.setSecondName("cabin");
        vet2.setId(2L);

        vetService.save(vet2);

        System.out.println("Loaded Vet's ...");
    }
}
