package com.sample.carmarket.entity;

import io.jmix.core.metamodel.datatype.impl.EnumClass;

import javax.annotation.Nullable;


public enum StatusType implements EnumClass<String> {

    IN_STOCK("IN_STOCK"),
    SOLD("SOLD");

    private String id;

    StatusType(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    @Nullable
    public static StatusType fromId(String id) {
        for (StatusType at : StatusType.values()) {
            if (at.getId().equals(id)) {
                return at;
            }
        }
        return null;
    }
}