package com.solar.springframework5.solarpetclinic.services;

import com.solar.springframework5.solarpetclinic.data.Owner;

public interface OwnerService extends BasicCrudService<Owner, Long> {
    Owner findByLastName(String lastName);
}
