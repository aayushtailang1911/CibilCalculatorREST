package com.CibilCalculator.entities;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
/**
 * POJO representation for Model in Model Registry json file
 */
    public class Model implements Serializable {

        private String modelName;
        private String version;
        private String packageName;
        private Set<Attribute> attributes;

        public void setAttributes(Set<Attribute> attributes) {
            this.attributes.clear();
            this.attributes.addAll(attributes);
        }

    }

