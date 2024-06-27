/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.itgarden.ERP.module.callcenter.Model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author libertyerp_local
 */
@Entity
@Table(name = "e_gatewaymapping")
public class Gatewaymapping implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @NotNull
    @Column(name = "id")
    private Integer id;
    
    @Size(max = 255)
    @Column(name = "name")
    private String name;
    @Size(max = 255)
    @Column(name = "password")
    private String password;
    @Size(max = 255)
    @Column(name = "customerpassword")
    private String customerpassword;
    @Column(name = "locktype")
    private Integer locktype;
    @Column(name = "calllevel")
    private Integer calllevel;
    @Column(name = "capacity")
    private Integer capacity;
    @Column(name = "priority")
    private Integer priority;
    @Column(name = "registertype")
    private Integer registertype;

    @Size(max = 65535)
    @Column(name = "remoteips",columnDefinition = "TEXT")
    private String remoteips;
    
    @Column(name = "rtpforwardtype")
    private Integer rtpforwardtype;

    @Size(max = 65535)
    @Column(name = "gatewaygroups", columnDefinition = "TEXT")
    private String gatewaygroups;
    
   
    @Size(max = 65535)
    @Column(name = "routinggatewaygroups", columnDefinition = "TEXT")
    private String routinggatewaygroups;
    
    @Size(max = 255)
    @Column(name = "memo")
    private String memo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "customer_id")
    private int customerId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "mbx_id")
    private int mbxId;

    public Gatewaymapping() {
    }

    public Gatewaymapping(Integer id, String name, String password, String customerpassword, Integer locktype, Integer calllevel, Integer capacity, Integer priority, Integer registertype, String remoteips, Integer rtpforwardtype, String gatewaygroups, String routinggatewaygroups, String memo, int customerId, int mbxId) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.customerpassword = customerpassword;
        this.locktype = locktype;
        this.calllevel = calllevel;
        this.capacity = capacity;
        this.priority = priority;
        this.registertype = registertype;
        this.remoteips = remoteips;
        this.rtpforwardtype = rtpforwardtype;
        this.gatewaygroups = gatewaygroups;
        this.routinggatewaygroups = routinggatewaygroups;
        this.memo = memo;
        this.customerId = customerId;
        this.mbxId = mbxId;
    }

   
}
