package com.solar.springframework5.solarpetclinic.services;

import java.util.Set;

public interface BasicCrudService<T, ID> {
    T findById(ID id);
    Set<T> findAll();
    T save(T object);
    void delete(T object);
    void deleteById(ID id);
}
