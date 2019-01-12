package com.solar.springframework5.solarpetclinic.repositories;

import com.solar.springframework5.solarpetclinic.data.Visit;
import org.springframework.data.repository.CrudRepository;

public interface VisitRepository extends CrudRepository<Visit, Long> {
}
