/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.itgarden.ERP.module.callcenter.master.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 *
 * @author libertyerp_local
 */
@Entity
@Table(name = "endreason")
public class Endreason {

    private static final long serialVersionUID = 1L;

    @NotNull
    @Column(name = "id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotNull
    private String name;

    @NotNull
    private int value;

    @NotNull
    private EndreasonType endreasonType;
    
    

    public Endreason() {
    }

    public Endreason(long id, String name, int value, EndreasonType endreasonType) {
        this.id = id;
        this.name = name;
        this.value = value;
        this.endreasonType = endreasonType;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public EndreasonType getEndreasonType() {
        return endreasonType;
    }

    public void setEndreasonType(EndreasonType endreasonType) {
        this.endreasonType = endreasonType;
    }
   
}
