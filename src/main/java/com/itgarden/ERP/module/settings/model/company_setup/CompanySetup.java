/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.itgarden.ERP.module.settings.model.company_setup;


import java.time.*;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.ManyToOne;
import javax.validation.constraints.*;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.data.annotation.*;
import org.springframework.data.jpa.domain.support.*;

/**
 *
 * @author User
 */
@Entity
@EntityListeners(AuditingEntityListener.class)
public class CompanySetup {

    ////  General settings //
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @javax.persistence.Id
    private Long id;

    @NotEmpty(message = "Company Name cannot be blank.")
    @Size(min = 2, message = "Minimum input 2 char. ")
    private String companyName;

    @NotEmpty(message = "Address cannot be blank.")
    private String address;

    private String phoneNumber;

    private String faxNumber;

    @NotEmpty(message = "Email Address cannot be blank.")
    @Email(message = "Email should be valid.")
    private String emailAddress;

    @NotEmpty(message = "Mobile Number cannot be blank.")
    private String mobileNumber;

    private String gstno;

    private String instructions;

    private String invoiceTmc;

//    @NotNull(message = "Home Currency cannot be blank.")
//    @ManyToOne(optional = false)
//    private Currencies homeCurrency;
    // General Ledger Settings//
    @NotNull(message = "Fiscal Year cannot be blank.")
    @ManyToOne(optional = false)
    private FiscalYears fiscalYear;

    @Min(value = 1)
    @NotNull(message = "Tax Periods cannot be blank.")
    private int taxPeriods; //Months.

    @Min(value = 1)
    @NotNull(message = "Tax Last Periods cannot be blank.")
    private int taxLastPeriod; //Months back.

    //User Interface Options//
    private int loginTimeout;

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

//    /// End Audit //// 
    public CompanySetup() {

    }

    public CompanySetup(Long id, String companyName, String address, String phoneNumber, String faxNumber, String emailAddress, String mobileNumber, String gstno, String instructions, String invoiceTmc, FiscalYears fiscalYear, int taxPeriods, int taxLastPeriod, int loginTimeout, String createdBy, LocalDateTime created, String modifiedBy, LocalDateTime modified) {
        this.id = id;
        this.companyName = companyName;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.faxNumber = faxNumber;
        this.emailAddress = emailAddress;
        this.mobileNumber = mobileNumber;
        this.gstno = gstno;
        this.instructions = instructions;
        this.invoiceTmc = invoiceTmc;
        this.fiscalYear = fiscalYear;
        this.taxPeriods = taxPeriods;
        this.taxLastPeriod = taxLastPeriod;
        this.loginTimeout = loginTimeout;
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

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getFaxNumber() {
        return faxNumber;
    }

    public void setFaxNumber(String faxNumber) {
        this.faxNumber = faxNumber;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public String getGstno() {
        return gstno;
    }

    public void setGstno(String gstno) {
        this.gstno = gstno;
    }

    public String getInstructions() {
        return instructions;
    }

    public void setInstructions(String instructions) {
        this.instructions = instructions;
    }

    public String getInvoiceTmc() {
        return invoiceTmc;
    }

    public void setInvoiceTmc(String invoiceTmc) {
        this.invoiceTmc = invoiceTmc;
    }

    public FiscalYears getFiscalYear() {
        return fiscalYear;
    }

    public void setFiscalYear(FiscalYears fiscalYear) {
        this.fiscalYear = fiscalYear;
    }

    public int getTaxPeriods() {
        return taxPeriods;
    }

    public void setTaxPeriods(int taxPeriods) {
        this.taxPeriods = taxPeriods;
    }

    public int getTaxLastPeriod() {
        return taxLastPeriod;
    }

    public void setTaxLastPeriod(int taxLastPeriod) {
        this.taxLastPeriod = taxLastPeriod;
    }

    public int getLoginTimeout() {
        return loginTimeout;
    }

    public void setLoginTimeout(int loginTimeout) {
        this.loginTimeout = loginTimeout;
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
