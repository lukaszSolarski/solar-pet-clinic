package com.solar.springframework5.solarpetclinic.services.springdatajpa;

import com.solar.springframework5.solarpetclinic.data.Owner;
import com.solar.springframework5.solarpetclinic.repositories.OwnerRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class OwnerServiceJpaTest {

    public final String LAST_NAME = "Solar";

    @Mock
    OwnerRepository ownerRepository;

    /*
    @InjectMocks doesn't work here so I had to use constructor in setUp() method on my own
    TODO check why it doesn't work
    @InjectMocks
     */
    OwnerServiceJpa ownerServiceJpa;

    Owner returnOwner;

    @BeforeEach
    void setUp() {
        ownerServiceJpa = new OwnerServiceJpa(ownerRepository);
        returnOwner = new Owner();
        returnOwner.setId(1L);
        returnOwner.setLastName(LAST_NAME);
    }

    @Test
    void findByLastName() {
        when(ownerRepository.findByLastName(any())).thenReturn(returnOwner);
        Owner owner = ownerServiceJpa.findByLastName(LAST_NAME);
        assertEquals(LAST_NAME, owner.getLastName());
        verify(ownerRepository).findByLastName(any());

    }

    @Test
    void findById() {
        when(ownerRepository.findById(anyLong())).thenReturn(Optional.of(returnOwner));
        Owner owner = ownerServiceJpa.findById(1L);
        assertNotNull(owner);
    }

    @Test
    void findByIdNotFound() {
        when(ownerRepository.findById(anyLong())).thenReturn(Optional.empty());
        Owner owner = ownerServiceJpa.findById(1L);
        assertNull(owner);
    }

    @Test
    void findAll() {
        Set<Owner> returnOwnersSet = new HashSet<>();
        Owner o1 = new Owner();
        o1.setId(1L);
        Owner o2 = new Owner();
        o2.setId(2L);
        returnOwnersSet.add(o1);
        returnOwnersSet.add(o2);
        when(ownerRepository.findAll()).thenReturn(returnOwnersSet);
        Set<Owner> owners = ownerServiceJpa.findAll();
        assertNotNull(owners);
        assertEquals(2, owners.size());
    }

    @Test
    void save() {
        Owner ownerToSave = new Owner();
        ownerToSave.setId(1L);
        when(ownerRepository.save(any())).thenReturn(returnOwner);
        Owner savedOwner = ownerServiceJpa.save(ownerToSave);
        assertNotNull(savedOwner);
        verify(ownerRepository).save(any());
    }

    @Test
    void delete() {
        ownerServiceJpa.delete(returnOwner);
        verify(ownerRepository, times(1)).delete(any());
    }

    @Test
    void deleteById() {
        ownerServiceJpa.deleteById(1L);
        verify(ownerRepository).deleteById(anyLong());
    }
}