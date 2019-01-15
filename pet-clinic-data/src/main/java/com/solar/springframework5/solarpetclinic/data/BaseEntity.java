package com.solar.springframework5.solarpetclinic.data;

import lombok.*;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@MappedSuperclass
public class BaseEntity implements Serializable {
    //Hibernate prefers "Long" rather than primitive type "long"
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
}
