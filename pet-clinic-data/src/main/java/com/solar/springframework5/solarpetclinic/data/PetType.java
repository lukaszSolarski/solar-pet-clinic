package com.solar.springframework5.solarpetclinic.data;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Table;

@Getter
@Setter
@NoArgsConstructor
//@AllArgsConstructor
@Entity
@Table(name = "types")
public class PetType extends NamedBaseEntity {
}
