package com.solar.springframework5.solarpetclinic.services.map;

import com.solar.springframework5.solarpetclinic.data.Owner;
import com.solar.springframework5.solarpetclinic.services.BasicCrudService;

import java.util.Set;

public class OwnerServiceMap extends AbstractMapService<Owner, Long> implements BasicCrudService<Owner, Long> {
    @Override
    public Owner findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Set<Owner> findAll() {
        return super.findAll();
    }

    @Override
    public Owner save(Owner owner) {
        return super.save(owner.getId(), owner);
    }

    @Override
    public void delete(Owner owner) {
        super.delete(owner);
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }
}
