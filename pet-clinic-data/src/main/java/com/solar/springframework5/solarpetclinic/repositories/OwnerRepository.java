package com.solar.springframework5.solarpetclinic.repositories;

import com.solar.springframework5.solarpetclinic.data.Owner;
import org.springframework.data.repository.CrudRepository;

public interface OwnerRepository extends CrudRepository<Owner, Long> {
}
