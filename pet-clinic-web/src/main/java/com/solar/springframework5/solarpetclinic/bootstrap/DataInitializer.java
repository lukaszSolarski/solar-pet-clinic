package com.solar.springframework5.solarpetclinic.bootstrap;

import com.solar.springframework5.solarpetclinic.data.Owner;
import com.solar.springframework5.solarpetclinic.data.Vet;
import com.solar.springframework5.solarpetclinic.services.OwnerService;
import com.solar.springframework5.solarpetclinic.services.VetService;
import com.solar.springframework5.solarpetclinic.services.map.OwnerServiceMap;
import com.solar.springframework5.solarpetclinic.services.map.VetServiceMap;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/*
CommandLineRunner and it's 'run' method will fire right after Spring Framework is ready.
 */
@Component
public class DataInitializer implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;

    /*
    @Autowired is not required. Since Spring 4.3 (?) Dependency injection by constructor will automatically
    act like the '@Autowired' annotation was provided.
     */
    public DataInitializer(OwnerService ownerService, VetService vetService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
    }

    @Override
    public void run(String... args) throws Exception {
        Owner o1 = new Owner();
        o1.setId(1L);
        o1.setFirstName("Luke");
        o1.setLastName("Skywalker");

        Owner o2 = new Owner();
        o2.setId(2L);
        o2.setFirstName("John");
        o2.setLastName("Thomson");

        ownerService.save(o1);
        ownerService.save(o2);
        System.out.println("Owners loaded..");

        Vet v1 = new Vet();
        v1.setId(1l);
        v1.setFirstName("Chuck");
        v1.setLastName("Norris");

        Vet v2 = new Vet();
        v2.setId(2l);
        v2.setFirstName("Donald");
        v2.setLastName("Duck");

        vetService.save(v1);
        vetService.save(v2);
        System.out.println("Vets loaded...");
    }
}
