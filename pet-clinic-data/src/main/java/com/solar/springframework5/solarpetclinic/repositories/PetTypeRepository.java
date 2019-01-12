package com.solar.springframework5.solarpetclinic.repositories;

import com.solar.springframework5.solarpetclinic.data.PetType;
import org.springframework.data.repository.CrudRepository;

public interface PetTypeRepository extends CrudRepository<PetType, Long> {
}
