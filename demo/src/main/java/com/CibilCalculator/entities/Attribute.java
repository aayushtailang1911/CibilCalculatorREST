package com.CibilCalculator.entities;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "attribute")

public class Attribute {

    @Column(name = "name",nullable = false,unique = true)
    private String name;

    @Column(name = "required",nullable = false)
    private Boolean required;

    @Column(name = "nullable")
    private Boolean nullable;

}
