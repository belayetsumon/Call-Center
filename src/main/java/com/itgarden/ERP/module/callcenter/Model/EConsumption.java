/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.itgarden.ERP.module.callcenter.Model;

import java.io.Serializable;
import java.math.BigInteger;
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
@Table(name = "e_consumption")
public class EConsumption implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id")
    private Integer id;
    @Size(max = 255)
    @Column(name = "account")
    private String account;
    @Size(max = 255)
    @Column(name = "accountname")
    private String accountname;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "money")
    private Double money;
    @Column(name = "remainmoney")
    private Double remainmoney;
    @Column(name = "time")
    private long time;
    @Column(name = "type")
    private Integer type;
    @Size(max = 255)
    @Column(name = "comsumptionname")
    private String comsumptionname;
    @Size(max = 255)
    @Column(name = "agentaccount")
    private String agentaccount;
    @Size(max = 255)
    @Column(name = "agentname")
    private String agentname;
    @Size(max = 255)
    @Column(name = "memo")
    private String memo;

    public EConsumption() {
    }

    public EConsumption(Integer id, String account, String accountname, Double money, Double remainmoney, long time, Integer type, String comsumptionname, String agentaccount, String agentname, String memo) {
        this.id = id;
        this.account = account;
        this.accountname = accountname;
        this.money = money;
        this.remainmoney = remainmoney;
        this.time = time;
        this.type = type;
        this.comsumptionname = comsumptionname;
        this.agentaccount = agentaccount;
        this.agentname = agentname;
        this.memo = memo;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getAccountname() {
        return accountname;
    }

    public void setAccountname(String accountname) {
        this.accountname = accountname;
    }

    public Double getMoney() {
        return money;
    }

    public void setMoney(Double money) {
        this.money = money;
    }

    public Double getRemainmoney() {
        return remainmoney;
    }

    public void setRemainmoney(Double remainmoney) {
        this.remainmoney = remainmoney;
    }

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getComsumptionname() {
        return comsumptionname;
    }

    public void setComsumptionname(String comsumptionname) {
        this.comsumptionname = comsumptionname;
    }

    public String getAgentaccount() {
        return agentaccount;
    }

    public void setAgentaccount(String agentaccount) {
        this.agentaccount = agentaccount;
    }

    public String getAgentname() {
        return agentname;
    }

    public void setAgentname(String agentname) {
        this.agentname = agentname;
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }

    
}
