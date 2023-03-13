package com.sample.carmarket.entity;

import io.jmix.core.entity.annotation.JmixGeneratedValue;
import io.jmix.core.metamodel.annotation.InstanceName;
import io.jmix.core.metamodel.annotation.JmixEntity;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.UUID;

@JmixEntity
@Table(name = "CAR", indexes = {
        @Index(name = "IDX_CAR_MODEL", columnList = "MODEL_ID")
}, uniqueConstraints = {
        @UniqueConstraint(name = "IDX_CAR_REGISTRATION_NUMBER", columnNames = {"REGISTRATION_NUMBER"})
})
@Entity
public class Car {
    @JmixGeneratedValue
    @Column(name = "ID", nullable = false)
    @Id
    private UUID id;

    @Max(2030)
    @Min(1990)
    @Column(name = "PRODUCTION_YEAR")
    private Integer productionYear;

    @Column(name = "STATUS")
    private String status;

    @Column(name = "DATE_OF_SALE")
    private LocalDate dateOfSale;

    @InstanceName
    @Length(min = 6, max = 6)
    @Column(name = "REGISTRATION_NUMBER", nullable = false, length = 6)
    @NotNull
    private String registrationNumber;

    @JoinColumn(name = "MODEL_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private Model model;

    public void setModel(Model model) {
        this.model = model;
    }

    public Model getModel() {
        return model;
    }

    public LocalDate getDateOfSale() {
        return dateOfSale;
    }

    public void setDateOfSale(LocalDate dateOfSale) {
        this.dateOfSale = dateOfSale;
    }

    public StatusType getStatus() {
        return status == null ? null : StatusType.fromId(status);
    }

    public void setStatus(StatusType status) {
        this.status = status == null ? null : status.getId();
    }

    public Integer getProductionYear() {
        return productionYear;
    }

    public void setProductionYear(Integer productionYear) {
        this.productionYear = productionYear;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public void setRegistrationNumber(String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }
}