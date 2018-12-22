package com.solar.springframework5.solarpetclinic.services.map;

import com.solar.springframework5.solarpetclinic.data.Pet;
import com.solar.springframework5.solarpetclinic.services.BasicCrudService;

import java.util.Set;

public class PetServiceMap extends AbstractMapService<Pet, Long> implements BasicCrudService<Pet, Long> {
    @Override
    public Pet findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Set<Pet> findAll() {
        return super.findAll();
    }

    @Override
    public Pet save(Pet pet) {
        return super.save(pet.getId(), pet);
    }

    @Override
    public void delete(Pet pet) {
        super.delete(pet);
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }
}