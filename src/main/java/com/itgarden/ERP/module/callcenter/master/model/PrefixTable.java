package com.itgarden.ERP.module.callcenter.master.model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import org.springframework.data.annotation.Transient;

/**
 *
 * @author libertyerp_local
 */
@Entity
@Table(name = "prefixtable")
public class PrefixTable implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    ConfigurationVoice configId;

    private int prefix;

    private int assignTime; // minute

    @Transient
    private int countDown; // minute

    private long lastUpdateTime; // unix time stemp milisecend

    @Transient
    private String lastUpdateTimeHumanReadableTime; // unix time stemp milisecend

    @Enumerated(EnumType.STRING)
    private PrefixStatus status;

    public PrefixTable() {
    }

    public PrefixTable(Long id, ConfigurationVoice configId, int prefix, int assignTime, int countDown, long lastUpdateTime, String lastUpdateTimeHumanReadableTime, PrefixStatus status) {
        this.id = id;
        this.configId = configId;
        this.prefix = prefix;
        this.assignTime = assignTime;
        this.countDown = countDown;
        this.lastUpdateTime = lastUpdateTime;
        this.lastUpdateTimeHumanReadableTime = lastUpdateTimeHumanReadableTime;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ConfigurationVoice getConfigId() {
        return configId;
    }

    public void setConfigId(ConfigurationVoice configId) {
        this.configId = configId;
    }

    public int getPrefix() {
        return prefix;
    }

    public void setPrefix(int prefix) {
        this.prefix = prefix;
    }

    public int getAssignTime() {
        return assignTime;
    }

    public void setAssignTime(int assignTime) {
        this.assignTime = assignTime;
    }

    public int getCountDown() {
        return countDown;
    }

    public void setCountDown(int countDown) {
        this.countDown = countDown;
    }

    public long getLastUpdateTime() {
        return lastUpdateTime;
    }

    public void setLastUpdateTime(long lastUpdateTime) {
        this.lastUpdateTime = lastUpdateTime;
    }

    public String getLastUpdateTimeHumanReadableTime() {
        return lastUpdateTimeHumanReadableTime;
    }

    public void setLastUpdateTimeHumanReadableTime(String lastUpdateTimeHumanReadableTime) {
        this.lastUpdateTimeHumanReadableTime = lastUpdateTimeHumanReadableTime;
    }

    public PrefixStatus getStatus() {
        return status;
    }

    public void setStatus(PrefixStatus status) {
        this.status = status;
    }

//    @Override
//    public String toString() {
//        return "PrefixTable{" + "id=" + id + ", configId=" + configId + ", prefix=" + prefix + ", assignTime=" + assignTime + ", countDown=" + countDown + ", lastUpdateTime=" + lastUpdateTime + ", lastUpdateTimeHumanReadableTime=" + lastUpdateTimeHumanReadableTime + ", status=" + status + '}';
//    }
    
    
    
    

}
