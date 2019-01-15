package com.solar.springframework5.solarpetclinic.data;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@MappedSuperclass
public class NamedBaseEntity extends BaseEntity {
    @Column(name = "name")
    private String name;
}
