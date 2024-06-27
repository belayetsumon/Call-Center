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
@Table(name = "callerrtpip")
public class CallerRtpIp {

    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String customerName;

    private String callerrtpip;

      public CallerRtpIp() {
    }
    
    
    public CallerRtpIp(Long id, String customerName, String callerrtpip) {
        this.id = id;
        this.customerName = customerName;
        this.callerrtpip = callerrtpip;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCallerrtpip() {
        return callerrtpip;
    }

    public void setCallerrtpip(String callerrtpip) {
        this.callerrtpip = callerrtpip;
    }


}
