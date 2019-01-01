package com.solar.springframework5.solarpetclinic.data;

public class NamedBaseEntity extends BaseEntity {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
