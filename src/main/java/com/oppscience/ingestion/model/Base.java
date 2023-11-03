package com.oppscience.ingestion.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import java.util.Optional;
import java.util.UUID;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@MappedSuperclass
public abstract class Base {

    @Id
    @GeneratedValue
    protected UUID id;

    protected String parentType;
    protected UUID parentId;

    public Base() {}

    public Base(String parentType, UUID parentId) {
        this.parentType = parentType;
        this.parentId = parentId;
    }

    @Override
    public String toString() {
        return "IngestionEntity{" +
                "parent='" + parentType + "/" + parentId + '\'' +
                '}';
    }
}
