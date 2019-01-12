package com.solar.springframework5.solarpetclinic.repositories;

import com.solar.springframework5.solarpetclinic.data.Pet;
import org.springframework.data.repository.CrudRepository;

public interface PetRepository extends CrudRepository<Pet, Long> {
}
