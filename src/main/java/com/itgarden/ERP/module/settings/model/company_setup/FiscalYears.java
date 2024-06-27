/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.itgarden.ERP.module.settings.model.company_setup;



import java.time.LocalDateTime;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.validation.constraints.*;
import org.springframework.data.annotation.*;
import org.springframework.data.jpa.domain.support.*;
import org.springframework.format.annotation.*;


/**
 *
 * @author User
 */
@Entity
@EntityListeners(AuditingEntityListener.class)
public class FiscalYears {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false, nullable = false)
    @javax.persistence.Id
    private Long id;

   
    @Column(nullable = false)
    @NotNull(message = " Date cannot be blank.")
//    @Temporal(javax.persistence.TemporalType.DATE)
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private Date fiscalYearBegin;

    @Column(nullable = false)
    @NotNull(message = " Date cannot be blank.")
//    @Temporal(javax.persistence.TemporalType.DATE)
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private Date fiscalYearEnd;
    @NotNull

    public Boolean isClosed;

       /// Audit /// 
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

    public FiscalYears() {
    }

    public FiscalYears(Long id, Date fiscalYearBegin, Date fiscalYearEnd, Boolean isClosed, String createdBy, LocalDateTime created, String modifiedBy, LocalDateTime modified) {
        this.id = id;
        this.fiscalYearBegin = fiscalYearBegin;
        this.fiscalYearEnd = fiscalYearEnd;
        this.isClosed = isClosed;
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

    public Date getFiscalYearBegin() {
        return fiscalYearBegin;
    }

    public void setFiscalYearBegin(Date fiscalYearBegin) {
        this.fiscalYearBegin = fiscalYearBegin;
    }

    public Date getFiscalYearEnd() {
        return fiscalYearEnd;
    }

    public void setFiscalYearEnd(Date fiscalYearEnd) {
        this.fiscalYearEnd = fiscalYearEnd;
    }

    public Boolean getIsClosed() {
        return isClosed;
    }

    public void setIsClosed(Boolean isClosed) {
        this.isClosed = isClosed;
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
