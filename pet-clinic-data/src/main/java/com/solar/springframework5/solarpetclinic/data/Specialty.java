package com.solar.springframework5.solarpetclinic.data;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "specialties")
public class Specialty extends BaseEntity {
    @Column(name = "description")
    private String description;
}
