/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.itgarden.ERP.module.settings.model.company_setup;

import com.itgarden.ERP.module.settings.model.enumvalue.YesNo;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.data.annotation.Id;


/**
 *
 * @author User
 */
@Entity
public class ItemTaxTypes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @javax.persistence.Id
    private Long id;
     @NotEmpty(message = "This field cannot be blank.")
    String name;
    
    @NotNull(message = "This field cannot be blank.")
    @Enumerated(EnumType.STRING)
    YesNo taxExempt;

    public ItemTaxTypes(Long id, String name, YesNo taxExempt) {
        this.id = id;
        this.name = name;
        this.taxExempt = taxExempt;
    }

    public ItemTaxTypes() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public YesNo getTaxExempt() {
        return taxExempt;
    }

    public void setTaxExempt(YesNo taxExempt) {
        this.taxExempt = taxExempt;
    }
    
    

}
