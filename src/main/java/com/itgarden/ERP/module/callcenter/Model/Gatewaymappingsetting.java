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
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author libertyerp_local
 */
@Entity
@Table(name = "e_gatewaymappingsetting")
public class Gatewaymappingsetting implements Serializable {

    private static final long serialVersionUID = 1L;
    @Column(name = "callercitye164check")
    private Integer callercitye164check;
    @Column(name = "calleecitye164check")
    private Integer calleecitye164check;
    @Lob
    @Size(max = 65535)
    @Column(name = "calloutcallerprefixes",columnDefinition = "TEXT")
    private String calloutcallerprefixes;
    @Lob
    @Size(max = 65535)
    @Column(name = "calloutcalleeprefixes",columnDefinition = "TEXT")
    private String calloutcalleeprefixes;
    @Lob
    @Size(max = 65535)
    @Column(name = "rewriterulesoutcallee",columnDefinition = "TEXT")
    private String rewriterulesoutcallee;
    @Lob
    @Size(max = 65535)
    @Column(name = "rewriterulesoutcaller",columnDefinition = "TEXT")
    private String rewriterulesoutcaller;
    @Lob
    @Size(max = 65535)
    @Column(name = "rewriterulesinmobilearea",columnDefinition = "TEXT")
    private String rewriterulesinmobilearea;
    @Lob
    @Size(max = 65535)
    @Column(name = "scheduledcalloutprefixes",columnDefinition = "TEXT")
    private String scheduledcalloutprefixes;
    @Lob
    @Size(max = 65535)
    @Column(name = "scheduledrewriterulesout",columnDefinition = "TEXT")
    private String scheduledrewriterulesout;
    @Lob
    @Size(max = 65535)
    @Column(name = "scheduledcapacity",columnDefinition = "TEXT")
    private String scheduledcapacity;
    @Column(name = "timeoutcallproceeding")
    private Integer timeoutcallproceeding;
    @Column(name = "dtmfreceivemethod")
    private Integer dtmfreceivemethod;
    @Column(name = "dtmfsendmethodh323")
    private Integer dtmfsendmethodh323;
    @Column(name = "dtmfsendmethodsip")
    private Integer dtmfsendmethodsip;
    @Column(name = "dtmfreceivepayloadtype")
    private Integer dtmfreceivepayloadtype;
    @Column(name = "dtmfsendpayloadtypeh323")
    private Integer dtmfsendpayloadtypeh323;
    @Column(name = "dtmfsendpayloadtypesip")
    private Integer dtmfsendpayloadtypesip;
    @Column(name = "q931progressindicator")
    private Integer q931progressindicator;
    @Lob
    @Size(max = 65535)
    @Column(name = "callfailedsipcode",columnDefinition = "TEXT")
    private String callfailedsipcode;
    @Lob
    @Size(max = 65535)
    @Column(name = "callfailedq931causevalue",columnDefinition = "TEXT")
    private String callfailedq931causevalue;
    @Column(name = "sipresponseaddressmethod")
    private Integer sipresponseaddressmethod;
    @Column(name = "siprequestaddressmethod")
    private Integer siprequestaddressmethod;
    @Column(name = "sipremoteringsignal")
    private Integer sipremoteringsignal;
    @Column(name = "sipcalleee164domain")
    private Integer sipcalleee164domain;
    @Column(name = "sipcallere164domain")
    private Integer sipcallere164domain;
    @Column(name = "h323calleee164domain")
    private Integer h323calleee164domain;
    @Column(name = "h323callere164domain")
    private Integer h323callere164domain;
    @Column(name = "allowphonebilling")
    private Integer allowphonebilling;
    @Column(name = "allowbindede164billing")
    private Integer allowbindede164billing;
    @Column(name = "enablephonesetting")
    private Integer enablephonesetting;
    @Column(name = "sipauthenticationmethod")
    private Integer sipauthenticationmethod;
    @Size(max = 255)
    @Column(name = "sipauthenticationuser")
    private String sipauthenticationuser;
    @Column(name = "calltransferbillingmode")
    private Integer calltransferbillingmode;
    @Column(name = "bitsofh323config")
    private Integer bitsofh323config;
    @Column(name = "bitsofsipconfig")
    private Integer bitsofsipconfig;
    @Column(name = "bitsofconfig")
    private Integer bitsofconfig;
    @Column(name = "callerallowlength")
    private Integer callerallowlength;
    @Column(name = "calleeallowlength")
    private Integer calleeallowlength;
    @Size(max = 255)
    @Column(name = "callerlimite164groups")
    private String callerlimite164groups;
    @Size(max = 255)
    @Column(name = "calleelimite164groups")
    private String calleelimite164groups;
    @Column(name = "minprofitpercent")
    private Integer minprofitpercent;
    @Column(name = "firstroutepolicy")
    private Integer firstroutepolicy;
    @Column(name = "secondroutepolicy")
    private Integer secondroutepolicy;
    @Column(name = "h323g729sendmode")
    private Integer h323g729sendmode;
    @Column(name = "sipg729sendmode")
    private Integer sipg729sendmode;
    @Column(name = "sipg729annexb")
    private Integer sipg729annexb;
    @Column(name = "sipg723annexa")
    private Integer sipg723annexa;
    @Column(name = "mediacheckdirection")
    private Integer mediacheckdirection;
    @Column(name = "calleee164restrict")
    private Integer calleee164restrict;
    @Column(name = "maxcalldurationlower")
    private Integer maxcalldurationlower;
    @Column(name = "maxcalldurationupper")
    private Integer maxcalldurationupper;
    @Column(name = "timeoutcallredirect")
    private Integer timeoutcallredirect;
    @Column(name = "maxcallrate")
    private Integer maxcallrate;
    @Column(name = "maxcallrateunit")
    private Integer maxcallrateunit;
    @Size(max = 255)
    @Column(name = "timeoutredirecte164")
    private String timeoutredirecte164;
    @Lob
    @Size(max = 65535)
    @Column(name = "h323codecs",columnDefinition = "TEXT")
    private String h323codecs;
    @Lob
    @Size(max = 65535)
    @Column(name = "sipcodecs",columnDefinition = "TEXT")
    private String sipcodecs;
    @Column(name = "calculateasr")
    private Integer calculateasr;
    @Column(name = "calculateacd")
    private Integer calculateacd;
    @Lob
    @Size(max = 65535)
    @Column(name = "denysamecitycodes",columnDefinition = "TEXT")
    private String denysamecitycodes;
    @Lob
    @Size(max = 65535)
    @Column(name = "checkmobilearea",columnDefinition = "TEXT")
    private String checkmobilearea;
    @Column(name = "externalrewritetype")
    private Integer externalrewritetype;
    @Column(name = "sipremotepartyidscreen")
    private Integer sipremotepartyidscreen;
    @Column(name = "sipe164displayfrom")
    private Integer sipe164displayfrom;
    @Column(name = "tryprotectroutedelay")
    private Integer tryprotectroutedelay;
    @Size(max = 255)
    @Column(name = "forwardsignalrewritee164group")
    private String forwardsignalrewritee164group;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "maxsecondrates")
    private Double maxsecondrates;
    @Column(name = "lrneatprefixlength")
    private Integer lrneatprefixlength;
    @Column(name = "lrnfailureaction")
    private Integer lrnfailureaction;
    @Size(max = 255)
    @Column(name = "lrninterstatebillingprefix")
    private String lrninterstatebillingprefix;
    @Size(max = 255)
    @Column(name = "lrnundeterminedbillingprefix")
    private String lrnundeterminedbillingprefix;
    @Lob
    @Size(max = 65535)
    @Column(name = "calloutroutinggateways",columnDefinition = "TEXT")
    private String calloutroutinggateways;
    @Column(name = "traceendtime")
    private long traceendtime;
    @Column(name = "aassampling")
    private Double aassampling;
    @Size(max = 255)
    @Column(name = "aaswordcategory")
    private String aaswordcategory;
    @Size(max = 255)
    @Column(name = "language")
    private String language;
    @Lob
    @Size(max = 65535)
    @Column(name = "rewriteprefixaddoutcallee",columnDefinition = "TEXT")
    private String rewriteprefixaddoutcallee;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "gatewaymapping_id")
    private Integer gatewaymappingId;

    public Gatewaymappingsetting() {
    }

    public Gatewaymappingsetting(Integer callercitye164check, Integer calleecitye164check, String calloutcallerprefixes, String calloutcalleeprefixes, String rewriterulesoutcallee, String rewriterulesoutcaller, String rewriterulesinmobilearea, String scheduledcalloutprefixes, String scheduledrewriterulesout, String scheduledcapacity, Integer timeoutcallproceeding, Integer dtmfreceivemethod, Integer dtmfsendmethodh323, Integer dtmfsendmethodsip, Integer dtmfreceivepayloadtype, Integer dtmfsendpayloadtypeh323, Integer dtmfsendpayloadtypesip, Integer q931progressindicator, String callfailedsipcode, String callfailedq931causevalue, Integer sipresponseaddressmethod, Integer siprequestaddressmethod, Integer sipremoteringsignal, Integer sipcalleee164domain, Integer sipcallere164domain, Integer h323calleee164domain, Integer h323callere164domain, Integer allowphonebilling, Integer allowbindede164billing, Integer enablephonesetting, Integer sipauthenticationmethod, String sipauthenticationuser, Integer calltransferbillingmode, Integer bitsofh323config, Integer bitsofsipconfig, Integer bitsofconfig, Integer callerallowlength, Integer calleeallowlength, String callerlimite164groups, String calleelimite164groups, Integer minprofitpercent, Integer firstroutepolicy, Integer secondroutepolicy, Integer h323g729sendmode, Integer sipg729sendmode, Integer sipg729annexb, Integer sipg723annexa, Integer mediacheckdirection, Integer calleee164restrict, Integer maxcalldurationlower, Integer maxcalldurationupper, Integer timeoutcallredirect, Integer maxcallrate, Integer maxcallrateunit, String timeoutredirecte164, String h323codecs, String sipcodecs, Integer calculateasr, Integer calculateacd, String denysamecitycodes, String checkmobilearea, Integer externalrewritetype, Integer sipremotepartyidscreen, Integer sipe164displayfrom, Integer tryprotectroutedelay, String forwardsignalrewritee164group, Double maxsecondrates, Integer lrneatprefixlength, Integer lrnfailureaction, String lrninterstatebillingprefix, String lrnundeterminedbillingprefix, String calloutroutinggateways, long traceendtime, Double aassampling, String aaswordcategory, String language, String rewriteprefixaddoutcallee, Integer gatewaymappingId) {
        this.callercitye164check = callercitye164check;
        this.calleecitye164check = calleecitye164check;
        this.calloutcallerprefixes = calloutcallerprefixes;
        this.calloutcalleeprefixes = calloutcalleeprefixes;
        this.rewriterulesoutcallee = rewriterulesoutcallee;
        this.rewriterulesoutcaller = rewriterulesoutcaller;
        this.rewriterulesinmobilearea = rewriterulesinmobilearea;
        this.scheduledcalloutprefixes = scheduledcalloutprefixes;
        this.scheduledrewriterulesout = scheduledrewriterulesout;
        this.scheduledcapacity = scheduledcapacity;
        this.timeoutcallproceeding = timeoutcallproceeding;
        this.dtmfreceivemethod = dtmfreceivemethod;
        this.dtmfsendmethodh323 = dtmfsendmethodh323;
        this.dtmfsendmethodsip = dtmfsendmethodsip;
        this.dtmfreceivepayloadtype = dtmfreceivepayloadtype;
        this.dtmfsendpayloadtypeh323 = dtmfsendpayloadtypeh323;
        this.dtmfsendpayloadtypesip = dtmfsendpayloadtypesip;
        this.q931progressindicator = q931progressindicator;
        this.callfailedsipcode = callfailedsipcode;
        this.callfailedq931causevalue = callfailedq931causevalue;
        this.sipresponseaddressmethod = sipresponseaddressmethod;
        this.siprequestaddressmethod = siprequestaddressmethod;
        this.sipremoteringsignal = sipremoteringsignal;
        this.sipcalleee164domain = sipcalleee164domain;
        this.sipcallere164domain = sipcallere164domain;
        this.h323calleee164domain = h323calleee164domain;
        this.h323callere164domain = h323callere164domain;
        this.allowphonebilling = allowphonebilling;
        this.allowbindede164billing = allowbindede164billing;
        this.enablephonesetting = enablephonesetting;
        this.sipauthenticationmethod = sipauthenticationmethod;
        this.sipauthenticationuser = sipauthenticationuser;
        this.calltransferbillingmode = calltransferbillingmode;
        this.bitsofh323config = bitsofh323config;
        this.bitsofsipconfig = bitsofsipconfig;
        this.bitsofconfig = bitsofconfig;
        this.callerallowlength = callerallowlength;
        this.calleeallowlength = calleeallowlength;
        this.callerlimite164groups = callerlimite164groups;
        this.calleelimite164groups = calleelimite164groups;
        this.minprofitpercent = minprofitpercent;
        this.firstroutepolicy = firstroutepolicy;
        this.secondroutepolicy = secondroutepolicy;
        this.h323g729sendmode = h323g729sendmode;
        this.sipg729sendmode = sipg729sendmode;
        this.sipg729annexb = sipg729annexb;
        this.sipg723annexa = sipg723annexa;
        this.mediacheckdirection = mediacheckdirection;
        this.calleee164restrict = calleee164restrict;
        this.maxcalldurationlower = maxcalldurationlower;
        this.maxcalldurationupper = maxcalldurationupper;
        this.timeoutcallredirect = timeoutcallredirect;
        this.maxcallrate = maxcallrate;
        this.maxcallrateunit = maxcallrateunit;
        this.timeoutredirecte164 = timeoutredirecte164;
        this.h323codecs = h323codecs;
        this.sipcodecs = sipcodecs;
        this.calculateasr = calculateasr;
        this.calculateacd = calculateacd;
        this.denysamecitycodes = denysamecitycodes;
        this.checkmobilearea = checkmobilearea;
        this.externalrewritetype = externalrewritetype;
        this.sipremotepartyidscreen = sipremotepartyidscreen;
        this.sipe164displayfrom = sipe164displayfrom;
        this.tryprotectroutedelay = tryprotectroutedelay;
        this.forwardsignalrewritee164group = forwardsignalrewritee164group;
        this.maxsecondrates = maxsecondrates;
        this.lrneatprefixlength = lrneatprefixlength;
        this.lrnfailureaction = lrnfailureaction;
        this.lrninterstatebillingprefix = lrninterstatebillingprefix;
        this.lrnundeterminedbillingprefix = lrnundeterminedbillingprefix;
        this.calloutroutinggateways = calloutroutinggateways;
        this.traceendtime = traceendtime;
        this.aassampling = aassampling;
        this.aaswordcategory = aaswordcategory;
        this.language = language;
        this.rewriteprefixaddoutcallee = rewriteprefixaddoutcallee;
        this.gatewaymappingId = gatewaymappingId;
    }

    public Integer getCallercitye164check() {
        return callercitye164check;
    }

    public void setCallercitye164check(Integer callercitye164check) {
        this.callercitye164check = callercitye164check;
    }

    public Integer getCalleecitye164check() {
        return calleecitye164check;
    }

    public void setCalleecitye164check(Integer calleecitye164check) {
        this.calleecitye164check = calleecitye164check;
    }

    public String getCalloutcallerprefixes() {
        return calloutcallerprefixes;
    }

    public void setCalloutcallerprefixes(String calloutcallerprefixes) {
        this.calloutcallerprefixes = calloutcallerprefixes;
    }

    public String getCalloutcalleeprefixes() {
        return calloutcalleeprefixes;
    }

    public void setCalloutcalleeprefixes(String calloutcalleeprefixes) {
        this.calloutcalleeprefixes = calloutcalleeprefixes;
    }

    public String getRewriterulesoutcallee() {
        return rewriterulesoutcallee;
    }

    public void setRewriterulesoutcallee(String rewriterulesoutcallee) {
        this.rewriterulesoutcallee = rewriterulesoutcallee;
    }

    public String getRewriterulesoutcaller() {
        return rewriterulesoutcaller;
    }

    public void setRewriterulesoutcaller(String rewriterulesoutcaller) {
        this.rewriterulesoutcaller = rewriterulesoutcaller;
    }

    public String getRewriterulesinmobilearea() {
        return rewriterulesinmobilearea;
    }

    public void setRewriterulesinmobilearea(String rewriterulesinmobilearea) {
        this.rewriterulesinmobilearea = rewriterulesinmobilearea;
    }

    public String getScheduledcalloutprefixes() {
        return scheduledcalloutprefixes;
    }

    public void setScheduledcalloutprefixes(String scheduledcalloutprefixes) {
        this.scheduledcalloutprefixes = scheduledcalloutprefixes;
    }

    public String getScheduledrewriterulesout() {
        return scheduledrewriterulesout;
    }

    public void setScheduledrewriterulesout(String scheduledrewriterulesout) {
        this.scheduledrewriterulesout = scheduledrewriterulesout;
    }

    public String getScheduledcapacity() {
        return scheduledcapacity;
    }

    public void setScheduledcapacity(String scheduledcapacity) {
        this.scheduledcapacity = scheduledcapacity;
    }

    public Integer getTimeoutcallproceeding() {
        return timeoutcallproceeding;
    }

    public void setTimeoutcallproceeding(Integer timeoutcallproceeding) {
        this.timeoutcallproceeding = timeoutcallproceeding;
    }

    public Integer getDtmfreceivemethod() {
        return dtmfreceivemethod;
    }

    public void setDtmfreceivemethod(Integer dtmfreceivemethod) {
        this.dtmfreceivemethod = dtmfreceivemethod;
    }

    public Integer getDtmfsendmethodh323() {
        return dtmfsendmethodh323;
    }

    public void setDtmfsendmethodh323(Integer dtmfsendmethodh323) {
        this.dtmfsendmethodh323 = dtmfsendmethodh323;
    }

    public Integer getDtmfsendmethodsip() {
        return dtmfsendmethodsip;
    }

    public void setDtmfsendmethodsip(Integer dtmfsendmethodsip) {
        this.dtmfsendmethodsip = dtmfsendmethodsip;
    }

    public Integer getDtmfreceivepayloadtype() {
        return dtmfreceivepayloadtype;
    }

    public void setDtmfreceivepayloadtype(Integer dtmfreceivepayloadtype) {
        this.dtmfreceivepayloadtype = dtmfreceivepayloadtype;
    }

    public Integer getDtmfsendpayloadtypeh323() {
        return dtmfsendpayloadtypeh323;
    }

    public void setDtmfsendpayloadtypeh323(Integer dtmfsendpayloadtypeh323) {
        this.dtmfsendpayloadtypeh323 = dtmfsendpayloadtypeh323;
    }

    public Integer getDtmfsendpayloadtypesip() {
        return dtmfsendpayloadtypesip;
    }

    public void setDtmfsendpayloadtypesip(Integer dtmfsendpayloadtypesip) {
        this.dtmfsendpayloadtypesip = dtmfsendpayloadtypesip;
    }

    public Integer getQ931progressindicator() {
        return q931progressindicator;
    }

    public void setQ931progressindicator(Integer q931progressindicator) {
        this.q931progressindicator = q931progressindicator;
    }

    public String getCallfailedsipcode() {
        return callfailedsipcode;
    }

    public void setCallfailedsipcode(String callfailedsipcode) {
        this.callfailedsipcode = callfailedsipcode;
    }

    public String getCallfailedq931causevalue() {
        return callfailedq931causevalue;
    }

    public void setCallfailedq931causevalue(String callfailedq931causevalue) {
        this.callfailedq931causevalue = callfailedq931causevalue;
    }

    public Integer getSipresponseaddressmethod() {
        return sipresponseaddressmethod;
    }

    public void setSipresponseaddressmethod(Integer sipresponseaddressmethod) {
        this.sipresponseaddressmethod = sipresponseaddressmethod;
    }

    public Integer getSiprequestaddressmethod() {
        return siprequestaddressmethod;
    }

    public void setSiprequestaddressmethod(Integer siprequestaddressmethod) {
        this.siprequestaddressmethod = siprequestaddressmethod;
    }

    public Integer getSipremoteringsignal() {
        return sipremoteringsignal;
    }

    public void setSipremoteringsignal(Integer sipremoteringsignal) {
        this.sipremoteringsignal = sipremoteringsignal;
    }

    public Integer getSipcalleee164domain() {
        return sipcalleee164domain;
    }

    public void setSipcalleee164domain(Integer sipcalleee164domain) {
        this.sipcalleee164domain = sipcalleee164domain;
    }

    public Integer getSipcallere164domain() {
        return sipcallere164domain;
    }

    public void setSipcallere164domain(Integer sipcallere164domain) {
        this.sipcallere164domain = sipcallere164domain;
    }

    public Integer getH323calleee164domain() {
        return h323calleee164domain;
    }

    public void setH323calleee164domain(Integer h323calleee164domain) {
        this.h323calleee164domain = h323calleee164domain;
    }

    public Integer getH323callere164domain() {
        return h323callere164domain;
    }

    public void setH323callere164domain(Integer h323callere164domain) {
        this.h323callere164domain = h323callere164domain;
    }

    public Integer getAllowphonebilling() {
        return allowphonebilling;
    }

    public void setAllowphonebilling(Integer allowphonebilling) {
        this.allowphonebilling = allowphonebilling;
    }

    public Integer getAllowbindede164billing() {
        return allowbindede164billing;
    }

    public void setAllowbindede164billing(Integer allowbindede164billing) {
        this.allowbindede164billing = allowbindede164billing;
    }

    public Integer getEnablephonesetting() {
        return enablephonesetting;
    }

    public void setEnablephonesetting(Integer enablephonesetting) {
        this.enablephonesetting = enablephonesetting;
    }

    public Integer getSipauthenticationmethod() {
        return sipauthenticationmethod;
    }

    public void setSipauthenticationmethod(Integer sipauthenticationmethod) {
        this.sipauthenticationmethod = sipauthenticationmethod;
    }

    public String getSipauthenticationuser() {
        return sipauthenticationuser;
    }

    public void setSipauthenticationuser(String sipauthenticationuser) {
        this.sipauthenticationuser = sipauthenticationuser;
    }

    public Integer getCalltransferbillingmode() {
        return calltransferbillingmode;
    }

    public void setCalltransferbillingmode(Integer calltransferbillingmode) {
        this.calltransferbillingmode = calltransferbillingmode;
    }

    public Integer getBitsofh323config() {
        return bitsofh323config;
    }

    public void setBitsofh323config(Integer bitsofh323config) {
        this.bitsofh323config = bitsofh323config;
    }

    public Integer getBitsofsipconfig() {
        return bitsofsipconfig;
    }

    public void setBitsofsipconfig(Integer bitsofsipconfig) {
        this.bitsofsipconfig = bitsofsipconfig;
    }

    public Integer getBitsofconfig() {
        return bitsofconfig;
    }

    public void setBitsofconfig(Integer bitsofconfig) {
        this.bitsofconfig = bitsofconfig;
    }

    public Integer getCallerallowlength() {
        return callerallowlength;
    }

    public void setCallerallowlength(Integer callerallowlength) {
        this.callerallowlength = callerallowlength;
    }

    public Integer getCalleeallowlength() {
        return calleeallowlength;
    }

    public void setCalleeallowlength(Integer calleeallowlength) {
        this.calleeallowlength = calleeallowlength;
    }

    public String getCallerlimite164groups() {
        return callerlimite164groups;
    }

    public void setCallerlimite164groups(String callerlimite164groups) {
        this.callerlimite164groups = callerlimite164groups;
    }

    public String getCalleelimite164groups() {
        return calleelimite164groups;
    }

    public void setCalleelimite164groups(String calleelimite164groups) {
        this.calleelimite164groups = calleelimite164groups;
    }

    public Integer getMinprofitpercent() {
        return minprofitpercent;
    }

    public void setMinprofitpercent(Integer minprofitpercent) {
        this.minprofitpercent = minprofitpercent;
    }

    public Integer getFirstroutepolicy() {
        return firstroutepolicy;
    }

    public void setFirstroutepolicy(Integer firstroutepolicy) {
        this.firstroutepolicy = firstroutepolicy;
    }

    public Integer getSecondroutepolicy() {
        return secondroutepolicy;
    }

    public void setSecondroutepolicy(Integer secondroutepolicy) {
        this.secondroutepolicy = secondroutepolicy;
    }

    public Integer getH323g729sendmode() {
        return h323g729sendmode;
    }

    public void setH323g729sendmode(Integer h323g729sendmode) {
        this.h323g729sendmode = h323g729sendmode;
    }

    public Integer getSipg729sendmode() {
        return sipg729sendmode;
    }

    public void setSipg729sendmode(Integer sipg729sendmode) {
        this.sipg729sendmode = sipg729sendmode;
    }

    public Integer getSipg729annexb() {
        return sipg729annexb;
    }

    public void setSipg729annexb(Integer sipg729annexb) {
        this.sipg729annexb = sipg729annexb;
    }

    public Integer getSipg723annexa() {
        return sipg723annexa;
    }

    public void setSipg723annexa(Integer sipg723annexa) {
        this.sipg723annexa = sipg723annexa;
    }

    public Integer getMediacheckdirection() {
        return mediacheckdirection;
    }

    public void setMediacheckdirection(Integer mediacheckdirection) {
        this.mediacheckdirection = mediacheckdirection;
    }

    public Integer getCalleee164restrict() {
        return calleee164restrict;
    }

    public void setCalleee164restrict(Integer calleee164restrict) {
        this.calleee164restrict = calleee164restrict;
    }

    public Integer getMaxcalldurationlower() {
        return maxcalldurationlower;
    }

    public void setMaxcalldurationlower(Integer maxcalldurationlower) {
        this.maxcalldurationlower = maxcalldurationlower;
    }

    public Integer getMaxcalldurationupper() {
        return maxcalldurationupper;
    }

    public void setMaxcalldurationupper(Integer maxcalldurationupper) {
        this.maxcalldurationupper = maxcalldurationupper;
    }

    public Integer getTimeoutcallredirect() {
        return timeoutcallredirect;
    }

    public void setTimeoutcallredirect(Integer timeoutcallredirect) {
        this.timeoutcallredirect = timeoutcallredirect;
    }

    public Integer getMaxcallrate() {
        return maxcallrate;
    }

    public void setMaxcallrate(Integer maxcallrate) {
        this.maxcallrate = maxcallrate;
    }

    public Integer getMaxcallrateunit() {
        return maxcallrateunit;
    }

    public void setMaxcallrateunit(Integer maxcallrateunit) {
        this.maxcallrateunit = maxcallrateunit;
    }

    public String getTimeoutredirecte164() {
        return timeoutredirecte164;
    }

    public void setTimeoutredirecte164(String timeoutredirecte164) {
        this.timeoutredirecte164 = timeoutredirecte164;
    }

    public String getH323codecs() {
        return h323codecs;
    }

    public void setH323codecs(String h323codecs) {
        this.h323codecs = h323codecs;
    }

    public String getSipcodecs() {
        return sipcodecs;
    }

    public void setSipcodecs(String sipcodecs) {
        this.sipcodecs = sipcodecs;
    }

    public Integer getCalculateasr() {
        return calculateasr;
    }

    public void setCalculateasr(Integer calculateasr) {
        this.calculateasr = calculateasr;
    }

    public Integer getCalculateacd() {
        return calculateacd;
    }

    public void setCalculateacd(Integer calculateacd) {
        this.calculateacd = calculateacd;
    }

    public String getDenysamecitycodes() {
        return denysamecitycodes;
    }

    public void setDenysamecitycodes(String denysamecitycodes) {
        this.denysamecitycodes = denysamecitycodes;
    }

    public String getCheckmobilearea() {
        return checkmobilearea;
    }

    public void setCheckmobilearea(String checkmobilearea) {
        this.checkmobilearea = checkmobilearea;
    }

    public Integer getExternalrewritetype() {
        return externalrewritetype;
    }

    public void setExternalrewritetype(Integer externalrewritetype) {
        this.externalrewritetype = externalrewritetype;
    }

    public Integer getSipremotepartyidscreen() {
        return sipremotepartyidscreen;
    }

    public void setSipremotepartyidscreen(Integer sipremotepartyidscreen) {
        this.sipremotepartyidscreen = sipremotepartyidscreen;
    }

    public Integer getSipe164displayfrom() {
        return sipe164displayfrom;
    }

    public void setSipe164displayfrom(Integer sipe164displayfrom) {
        this.sipe164displayfrom = sipe164displayfrom;
    }

    public Integer getTryprotectroutedelay() {
        return tryprotectroutedelay;
    }

    public void setTryprotectroutedelay(Integer tryprotectroutedelay) {
        this.tryprotectroutedelay = tryprotectroutedelay;
    }

    public String getForwardsignalrewritee164group() {
        return forwardsignalrewritee164group;
    }

    public void setForwardsignalrewritee164group(String forwardsignalrewritee164group) {
        this.forwardsignalrewritee164group = forwardsignalrewritee164group;
    }

    public Double getMaxsecondrates() {
        return maxsecondrates;
    }

    public void setMaxsecondrates(Double maxsecondrates) {
        this.maxsecondrates = maxsecondrates;
    }

    public Integer getLrneatprefixlength() {
        return lrneatprefixlength;
    }

    public void setLrneatprefixlength(Integer lrneatprefixlength) {
        this.lrneatprefixlength = lrneatprefixlength;
    }

    public Integer getLrnfailureaction() {
        return lrnfailureaction;
    }

    public void setLrnfailureaction(Integer lrnfailureaction) {
        this.lrnfailureaction = lrnfailureaction;
    }

    public String getLrninterstatebillingprefix() {
        return lrninterstatebillingprefix;
    }

    public void setLrninterstatebillingprefix(String lrninterstatebillingprefix) {
        this.lrninterstatebillingprefix = lrninterstatebillingprefix;
    }

    public String getLrnundeterminedbillingprefix() {
        return lrnundeterminedbillingprefix;
    }

    public void setLrnundeterminedbillingprefix(String lrnundeterminedbillingprefix) {
        this.lrnundeterminedbillingprefix = lrnundeterminedbillingprefix;
    }

    public String getCalloutroutinggateways() {
        return calloutroutinggateways;
    }

    public void setCalloutroutinggateways(String calloutroutinggateways) {
        this.calloutroutinggateways = calloutroutinggateways;
    }

    public long getTraceendtime() {
        return traceendtime;
    }

    public void setTraceendtime(long traceendtime) {
        this.traceendtime = traceendtime;
    }

    public Double getAassampling() {
        return aassampling;
    }

    public void setAassampling(Double aassampling) {
        this.aassampling = aassampling;
    }

    public String getAaswordcategory() {
        return aaswordcategory;
    }

    public void setAaswordcategory(String aaswordcategory) {
        this.aaswordcategory = aaswordcategory;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getRewriteprefixaddoutcallee() {
        return rewriteprefixaddoutcallee;
    }

    public void setRewriteprefixaddoutcallee(String rewriteprefixaddoutcallee) {
        this.rewriteprefixaddoutcallee = rewriteprefixaddoutcallee;
    }

    public Integer getGatewaymappingId() {
        return gatewaymappingId;
    }

    public void setGatewaymappingId(Integer gatewaymappingId) {
        this.gatewaymappingId = gatewaymappingId;
    }

    

}
