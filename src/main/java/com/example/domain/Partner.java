package com.example.domain;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Entity
@Getter
@NoArgsConstructor(access =  AccessLevel.PROTECTED)
public class Partner {
    @Id
    @GeneratedValue
    private Long id;

    private String name;

    private String status;

    private String address;

    private String callCenter;

    private String partnerNumber;

    private String businessNumber;

    private String ceoName;

    private LocalDateTime registeredAt;

    private LocalDateTime unregisteredAt;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    private String createdBy;

    private String updatedBy;

    @Builder
    public Partner(Long id, String name, String status, String address, String callCenter,
                   String partnerNumber, String businessNumber, String ceoName, LocalDateTime registeredAt,
                   LocalDateTime unregisteredAt, LocalDateTime createdAt, LocalDateTime updatedAt,
                   String createdBy, String updatedBy) {
        this.id = id;
        this.name = name;
        this.status = status;
        this.address = address;
        this.callCenter = callCenter;
        this.partnerNumber = partnerNumber;
        this.businessNumber = businessNumber;
        this.ceoName = ceoName;
        this.registeredAt = registeredAt;
        this.unregisteredAt = unregisteredAt;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.createdBy = createdBy;
        this.updatedBy = updatedBy;
    }
}
