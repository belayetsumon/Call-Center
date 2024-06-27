package com.itgarden.ERP.module.callcenter.master.model;

import java.io.Serializable;
import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

/**
 *
 * @author libertyerp_local
 */
@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name = "assignednumber")
public class AssignedNumber implements Serializable{

//    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "gatewayrouting_id")
    private Integer gatewayroutingId;

    private String gatewayName;

    private int gatewayNamePrefix;

    @Lob
    private String gatewayRoutingPrefix;

    @Lob
    private String gatewayRoutingSettingRewriteRules;

    private String incommingNumber;

    private int priority;

    private int repeats;
    
    
        ///// Audit /// 
//    @Version
//    private int version;
//
    @CreatedBy
    @Column(nullable = false, updatable = false)
    private String createdBy;

    @CreatedDate
    @Column(nullable = false, updatable = false)
    private LocalDateTime created;

    @LastModifiedBy
    @Column(insertable = false, updatable = true)
    private String modifiedBy;

    @LastModifiedDate
    @Column(insertable = false, updatable = true)
    private LocalDateTime modified;

    public AssignedNumber() {
    }

    public AssignedNumber(Long id, Integer gatewayroutingId, String gatewayName, int gatewayNamePrefix, String gatewayRoutingPrefix, String gatewayRoutingSettingRewriteRules, String incommingNumber, int priority, int repeats, String createdBy, LocalDateTime created, String modifiedBy, LocalDateTime modified) {
        this.id = id;
        this.gatewayroutingId = gatewayroutingId;
        this.gatewayName = gatewayName;
        this.gatewayNamePrefix = gatewayNamePrefix;
        this.gatewayRoutingPrefix = gatewayRoutingPrefix;
        this.gatewayRoutingSettingRewriteRules = gatewayRoutingSettingRewriteRules;
        this.incommingNumber = incommingNumber;
        this.priority = priority;
        this.repeats = repeats;
        this.createdBy = createdBy;
        this.created = created;
        this.modifiedBy = modifiedBy;
        this.modified = modified;
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

    public String getGatewayName() {
        return gatewayName;
    }

    public void setGatewayName(String gatewayName) {
        this.gatewayName = gatewayName;
    }

    public int getGatewayNamePrefix() {
        return gatewayNamePrefix;
    }

    public void setGatewayNamePrefix(int gatewayNamePrefix) {
        this.gatewayNamePrefix = gatewayNamePrefix;
    }

    public String getGatewayRoutingPrefix() {
        return gatewayRoutingPrefix;
    }

    public void setGatewayRoutingPrefix(String gatewayRoutingPrefix) {
        this.gatewayRoutingPrefix = gatewayRoutingPrefix;
    }

    public String getGatewayRoutingSettingRewriteRules() {
        return gatewayRoutingSettingRewriteRules;
    }

    public void setGatewayRoutingSettingRewriteRules(String gatewayRoutingSettingRewriteRules) {
        this.gatewayRoutingSettingRewriteRules = gatewayRoutingSettingRewriteRules;
    }

    public String getIncommingNumber() {
        return incommingNumber;
    }

    public void setIncommingNumber(String incommingNumber) {
        this.incommingNumber = incommingNumber;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public int getRepeats() {
        return repeats;
    }

    public void setRepeats(int repeats) {
        this.repeats = repeats;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public LocalDateTime getCreated() {
        return created;
    }

    public void setCreated(LocalDateTime created) {
        this.created = created;
    }

    public String getModifiedBy() {
        return modifiedBy;
    }

    public void setModifiedBy(String modifiedBy) {
        this.modifiedBy = modifiedBy;
    }

    public LocalDateTime getModified() {
        return modified;
    }

    public void setModified(LocalDateTime modified) {
        this.modified = modified;
    }
}
