package com.solar.springframework5.solarpetclinic.services.map;

import com.solar.springframework5.solarpetclinic.data.Specialty;
import com.solar.springframework5.solarpetclinic.data.Vet;
import com.solar.springframework5.solarpetclinic.services.SpecialtyService;
import com.solar.springframework5.solarpetclinic.services.VetService;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class VetServiceMap extends AbstractMapService<Vet, Long> implements VetService {

    private final SpecialtyService specialtyService;

    public VetServiceMap(SpecialtyService specialtyService) {
        this.specialtyService = specialtyService;
    }

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
        if (vet != null) {
            if ((vet.getSpecialties() != null) & (vet.getSpecialties().size() > 0)) {
                vet.getSpecialties().forEach(specialty -> {
                    if (specialty.getId() == null) {
                        Specialty savedSpecialty = specialtyService.save(specialty);
                        specialty.setId(savedSpecialty.getId());
                    }
                });
            }
            return super.save(vet);
        } else {
            throw new RuntimeException("Vet cannot be null!");
        }
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
