package com.solar.springframework5.solarpetclinic.services;

import com.solar.springframework5.solarpetclinic.data.Owner;

import java.util.Set;

public interface OwnerService {
    Owner findByLastName(String lastName);
    Owner findById (Long id);
    Set<Owner> findAll();
    Owner save (Owner owner);
}
