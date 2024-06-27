/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.itgarden.ERP.module.callcenter.master.model;

import java.io.Serializable;
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
@Table(name = "configurationvoice")
public class ConfigurationVoice implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "gatewayrouting_id")
    private Integer gatewayroutingId;
    private String name;

    @Column(nullable = false, length = 3)
    @NotNull(message = "Prefix Start Number cannot be blank.")
    private int prefixStartNumber;

    @NotNull(message = "Prefix quantity cannot be blank.")
    private int prefixqty;

    @NotNull(message = "Assign time cannot be blank.")
    private int assignTime;

    public ConfigurationVoice() {
    }

    public ConfigurationVoice(Long id, Integer gatewayroutingId, String name, int prefixStartNumber, int prefixqty, int assignTime) {
        this.id = id;
        this.gatewayroutingId = gatewayroutingId;
        this.name = name;
        this.prefixStartNumber = prefixStartNumber;
        this.prefixqty = prefixqty;
        this.assignTime = assignTime;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getGatewayroutingId() {
        return gatewayroutingId;
    }

    public void setGatewayroutingId(Integer gatewayroutingId) {
        this.gatewayroutingId = gatewayroutingId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrefixStartNumber() {
        return prefixStartNumber;
    }

    public void setPrefixStartNumber(int prefixStartNumber) {
        this.prefixStartNumber = prefixStartNumber;
    }

    public int getPrefixqty() {
        return prefixqty;
    }

    public void setPrefixqty(int prefixqty) {
        this.prefixqty = prefixqty;
    }

    public int getAssignTime() {
        return assignTime;
    }

    public void setAssignTime(int assignTime) {
        this.assignTime = assignTime;
    }

    
}
