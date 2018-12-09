package com.solar.springframework5.solarpetclinic.services;

import com.solar.springframework5.solarpetclinic.data.Pet;

import java.util.Set;

public interface PetService {
    Pet findById (Long id);
    Set<Pet> findAll();
    Pet save (Pet pet);
}
