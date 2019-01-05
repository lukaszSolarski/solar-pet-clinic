package com.solar.springframework5.solarpetclinic.bootstrap;

import com.solar.springframework5.solarpetclinic.data.*;
import com.solar.springframework5.solarpetclinic.services.OwnerService;
import com.solar.springframework5.solarpetclinic.services.PetTypeService;
import com.solar.springframework5.solarpetclinic.services.SpecialtyService;
import com.solar.springframework5.solarpetclinic.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

/*
CommandLineRunner and it's 'run' method will fire right after Spring Framework is ready.
 */
@Component
public class DataInitializer implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;
    private final SpecialtyService specialtyService;

    /*
    @Autowired is not required. Since Spring 4.3 (?) Dependency injection by constructor will automatically
    act like the '@Autowired' annotation was provided.
     */
    public DataInitializer(OwnerService ownerService, VetService vetService, PetTypeService petTypeService, SpecialtyService specialtyService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
        this.specialtyService = specialtyService;
    }

    @Override
    public void run(String... args) throws Exception {
        /*
        We have to save data only if database is empty. When we'll be using real MySQL database,
        we shouldn't save this to db because it will cause multiplying data in database.
         */
        int countPetTypes = petTypeService.findAll().size();
        if (countPetTypes == 0) {
            loadDefaultData();
        }
    }

    private void loadDefaultData() {
        PetType dog = new PetType();
        dog.setName("Dog");
        PetType savedDogPetType = petTypeService.save(dog);

        PetType cat = new PetType();
        cat.setName("Cat");
        PetType savedCatPetType = petTypeService.save(cat);
        System.out.println("Pet types loaded...");

        Specialty radiology = new Specialty();
        radiology.setDescription("Radiology");
        Specialty surgery = new Specialty();
        surgery.setDescription("surgery");
        Specialty dentistry = new Specialty();
        dentistry.setDescription("dentistry");
        Specialty savedRadiology = specialtyService.save(radiology);
        Specialty savedSurgary = specialtyService.save(surgery);
        Specialty savedDentistry = specialtyService.save(dentistry);
        System.out.println("Specialties saved");

        Owner o1 = new Owner();
        o1.setFirstName("Luke");
        o1.setLastName("Skywalker");
        o1.setAddress("123 Baker Street");
        o1.setCity("London");
        o1.setTelephone("123456789");
        Pet lukesDog = new Pet();
        lukesDog.setName("Reksio");
        lukesDog.setPetType(savedDogPetType);
        lukesDog.setOwner(o1);
        lukesDog.setBirthday(LocalDate.now());
        o1.getPets().add(lukesDog);
        ownerService.save(o1);

        Owner o2 = new Owner();
        o2.setFirstName("John");
        o2.setLastName("Thomson");
        o2.setAddress("124 Bakre Street");
        o2.setCity("London");
        o2.setTelephone("987654321");
        Pet johnsCat = new Pet();
        johnsCat.setName("Klakier");
        johnsCat.setPetType(savedCatPetType);
        johnsCat.setOwner(o2);
        johnsCat.setBirthday(LocalDate.now().minusDays(1L));
        o2.getPets().add(johnsCat);
        ownerService.save(o2);

        System.out.println("Owners loaded..");

        Vet v1 = new Vet();
        v1.setFirstName("Chuck");
        v1.setLastName("Norris");
        v1.getSpecialties().add(savedRadiology);

        Vet v2 = new Vet();
        v2.setFirstName("Donald");
        v2.setLastName("Duck");
        v2.getSpecialties().add(savedSurgary);
        v2.getSpecialties().add(savedDentistry);

        vetService.save(v1);
        vetService.save(v2);
        System.out.println("Vets loaded...");
    }
}
