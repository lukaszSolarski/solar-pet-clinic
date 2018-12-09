package com.solar.springframework5.solarpetclinic.data;

import java.io.Serializable;

public class BaseEntity implements Serializable {
    //Hibernate prefers "Long" rather than primitive type "long"
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
