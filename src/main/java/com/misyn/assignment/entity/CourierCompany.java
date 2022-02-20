package com.misyn.assignment.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class CourierCompany {
    @Id
    private String companyCode;
    @Column
    private String companyName;
    @Column
    private String companyEmail;
    @Column
    private String companyAddress;
    @Column
    private String companyContact;
}
