package com.solar.springframework5.solarpetclinic.data;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "types")
public class PetType extends NamedBaseEntity {
}
