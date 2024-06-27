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

/**
 *
 * @author libertyerp_local
 */
@Entity
@Table(name = "settings")
public class Settings {

    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    
    private int cdrDataScanTime;
    
    private int numberRepet;
    
    private Integer callerpdd;

    public Settings() {
    }

    public Settings(Long id, int cdrDataScanTime, int numberRepet, Integer callerpdd) {
        this.id = id;
        this.cdrDataScanTime = cdrDataScanTime;
        this.numberRepet = numberRepet;
        this.callerpdd = callerpdd;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getCdrDataScanTime() {
        return cdrDataScanTime;
    }

    public void setCdrDataScanTime(int cdrDataScanTime) {
        this.cdrDataScanTime = cdrDataScanTime;
    }

    public int getNumberRepet() {
        return numberRepet;
    }

    public void setNumberRepet(int numberRepet) {
        this.numberRepet = numberRepet;
    }

    public Integer getCallerpdd() {
        return callerpdd;
    }

    public void setCallerpdd(Integer callerpdd) {
        this.callerpdd = callerpdd;
    }
    
}
