package com.solar.springframework5.solarpetclinic.services.map;

import com.solar.springframework5.solarpetclinic.data.Vet;
import com.solar.springframework5.solarpetclinic.services.BasicCrudService;

import java.util.Set;

public class VetServiceMap extends AbstractMapService<Vet, Long> implements BasicCrudService<Vet, Long> {
    @Override
    public Vet findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Set<Vet> findAll() {
        return super.findAll();
    }

    @Override
    public Vet save(Vet vet) {
        return super.save(vet.getId(), vet);
    }

    @Override
    public void delete(Vet vet) {
        super.delete(vet);
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }
}
