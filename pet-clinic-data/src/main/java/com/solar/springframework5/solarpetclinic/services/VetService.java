package com.solar.springframework5.solarpetclinic.services;

import com.solar.springframework5.solarpetclinic.data.Vet;

import java.util.Set;

public interface VetService {
    Vet findById (Long id);
    Set<Vet> findAll();
    Vet save (Vet vet);
}
