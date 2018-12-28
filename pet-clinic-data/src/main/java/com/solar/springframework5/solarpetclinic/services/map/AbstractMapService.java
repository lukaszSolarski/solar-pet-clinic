package com.solar.springframework5.solarpetclinic.services.map;

import com.solar.springframework5.solarpetclinic.data.BaseEntity;

import java.util.*;

public abstract class AbstractMapService<T extends BaseEntity, ID extends Long> {
    protected Map<Long, T> map = new HashMap<>();

    Set<T> findAll() {
        return new HashSet<>(map.values());
    }
    T findById(ID id) {
        return map.get(id);
    }

    T save(T object) {
        if (object != null) {
            if (object.getId() == null) {
                object.setId(getNextId());
            }
            map.put(object.getId(), object);
        }
        else {
            throw new RuntimeException("Object cannot be a null value");
        }
        return object;
    }
    void deleteById (ID id) {
        map.remove(id);
    }
    void delete (T object) {
        map.entrySet().removeIf(entry -> entry.getValue().equals(object));
    }

    private Long getNextId() {
        Long nextId = null;
        try {
            nextId = Collections.max(map.keySet()) + 1;
        } catch (NoSuchElementException e) {
            // map is empty, so I assign value 1L for nextId by myself
            nextId = 1L;
        }
        return nextId;
    }
}
