package com.CibilCalculator.entities;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
/**
 * POJO representation for Attributes in Model Registry json file
 */
public class Attribute implements Serializable{

    private String name;

    private boolean required;

    private boolean nullable;

}
