package com.itgarden.ERP.module.callcenter.Model;

import java.io.Serializable;
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
@Table(name = "e_gatewayroutingsetting")

public class Gatewayroutingsetting implements Serializable {

    private static final long serialVersionUID = 1L;
    @Column(name = "callercitye164check")
    private Integer callercitye164check;
    @Column(name = "calleecitye164check")
    private Integer calleecitye164check;
    @Lob
    @Size(max = 65535)
    @Column(name = "denycallercallee" ,columnDefinition = "TEXT")
    private String denycallercallee;
    @Lob
    @Size(max = 65535)
    @Column(name = "denysamecitycodes",columnDefinition = "TEXT")
    private String denysamecitycodes;
    @Lob
    @Size(max = 65535)
    @Column(name = "checkmobilearea",columnDefinition = "TEXT")
    private String checkmobilearea;
    @Lob
    @Size(max = 65535)
    @Column(name = "callincallerprefixes",columnDefinition = "TEXT")
    private String callincallerprefixes;
    @Lob
    @Size(max = 65535)
    @Column(name = "callincalleeprefixes",columnDefinition = "TEXT")
    private String callincalleeprefixes;
    @Lob
    @Size(max = 65535)
    @Column(name = "callinforwardprefixes",columnDefinition = "TEXT")
    private String callinforwardprefixes;
    @Lob
    @Size(max = 65535)
    @Column(name = "rewriterulesincallee",columnDefinition = "TEXT")
    private String rewriterulesincallee;
    @Lob
    @Size(max = 65535)
    @Column(name = "rewriterulesinmobilearea",columnDefinition = "TEXT")
    private String rewriterulesinmobilearea;
    @Lob
    @Size(max = 65535)
    @Column(name = "rewriterulesincaller",columnDefinition = "TEXT")
    private String rewriterulesincaller;
    @Size(max = 255)
    @Column(name = "rewriterulesincallerusee164group")
    private String rewriterulesincallerusee164group;
    @Lob
    @Size(max = 65535)
    @Column(name = "rewriterulespidentity",columnDefinition = "TEXT")
    private String rewriterulespidentity;
    @Lob
    @Size(max = 65535)
    @Column(name = "scheduledcallinprefixes",columnDefinition = "TEXT")
    private String scheduledcallinprefixes;
    @Lob
    @Size(max = 65535)
    @Column(name = "scheduledrewriterulesin",columnDefinition = "TEXT")
    private String scheduledrewriterulesin;
    @Lob
    @Size(max = 65535)
    @Column(name = "scheduledcapacity",columnDefinition = "TEXT")
    private String scheduledcapacity;
    @Lob
    @Size(max = 65535)
    @Column(name = "scheduledpriority",columnDefinition = "TEXT")
    private String scheduledpriority;
    @Column(name = "timeoutsetup")
    private Integer timeoutsetup;
    @Column(name = "timeoutcallproceeding")
    private Integer timeoutcallproceeding;
    @Column(name = "timeoutcallproceedingolc")
    private Integer timeoutcallproceedingolc;
    @Column(name = "timeoutalerting")
    private Integer timeoutalerting;
    @Column(name = "timeoutinvite")
    private Integer timeoutinvite;
    @Column(name = "timeouttrying")
    private Integer timeouttrying;
    @Column(name = "timeoutsessionprogresssdp")
    private Integer timeoutsessionprogresssdp;
    @Column(name = "timeoutsessionprogress")
    private Integer timeoutsessionprogress;
    @Column(name = "timeoutringing")
    private Integer timeoutringing;
    @Column(name = "stopswitchafterolc")
    private Integer stopswitchafterolc;
    @Column(name = "stopswitchaftersdp")
    private Integer stopswitchaftersdp;
    @Column(name = "clearingaccountusecalloute164")
    private Integer clearingaccountusecalloute164;
    @Column(name = "q931presentationindicator")
    private Integer q931presentationindicator;
    @Column(name = "q931screeningindicator")
    private Integer q931screeningindicator;
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
    @Column(name = "q931numberingplan")
    private Integer q931numberingplan;
    @Column(name = "q931numbertype")
    private Integer q931numbertype;
    @Column(name = "sipresponseaddressmethod")
    private Integer sipresponseaddressmethod;
    @Column(name = "siprequestaddressmethod")
    private Integer siprequestaddressmethod;
    @Column(name = "stopswitchafterrtpstart")
    private Integer stopswitchafterrtpstart;
    @Column(name = "stopswitchafteruserbusy")
    private Integer stopswitchafteruserbusy;
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
    @Size(max = 255)
    @Column(name = "localip")
    private String localip;
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
    @Column(name = "minprofitpercent")
    private Integer minprofitpercent;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "maxsecondrates")
    private Double maxsecondrates;
    @Column(name = "feeraterestrict")
    private Integer feeraterestrict;
    @Column(name = "leastcostrouting")
    private Integer leastcostrouting;
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
    @Column(name = "enablecalltransfer")
    private Integer enablecalltransfer;
    @Column(name = "maxcalldurationlower")
    private Integer maxcalldurationlower;
    @Column(name = "maxcalldurationupper")
    private Integer maxcalldurationupper;
    @Column(name = "calleee164restrict")
    private Integer calleee164restrict;
    @Column(name = "enablephonedisplay")
    private Integer enablephonedisplay;
    @Column(name = "switchuntilconnect")
    private Integer switchuntilconnect;
    @Column(name = "maxcallrate")
    private Integer maxcallrate;
    @Column(name = "maxcallrateunit")
    private Integer maxcallrateunit;
    @Column(name = "sipremotepartyidscreen")
    private Integer sipremotepartyidscreen;
    @Column(name = "sipe164displaytype")
    private Integer sipe164displaytype;
    @Column(name = "sipprivacytype")
    private Integer sipprivacytype;
    @Column(name = "sipppreferredidentitytype")
    private Integer sipppreferredidentitytype;
    @Column(name = "sippassertedidentitytype")
    private Integer sippassertedidentitytype;
    @Size(max = 255)
    @Column(name = "sipinvitecode")
    private String sipinvitecode;
    @Size(max = 255)
    @Column(name = "sipauthenticationuser")
    private String sipauthenticationuser;
    @Size(max = 255)
    @Column(name = "forwardsignalrewritee164group")
    private String forwardsignalrewritee164group;
    @Lob
    @Size(max = 65535)
    @Column(name = "callinmappinggateways",columnDefinition = "TEXT")
    private String callinmappinggateways;
    
    @Column(name = "traceendtime")
    private long traceendtime;
    @Column(name = "aassampling")
    private Double aassampling;
    @Size(max = 255)
    @Column(name = "aaswordcategory")
    private String aaswordcategory;
    @Lob
    @Size(max = 65535)
    @Column(name = "stopswitchsipcodes",columnDefinition = "TEXT")
    private String stopswitchsipcodes;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "gatewayrouting_id")
    private Integer gatewayroutingId;

    public Gatewayroutingsetting() {
    }

    public Gatewayroutingsetting(Integer callercitye164check, Integer calleecitye164check, String denycallercallee, String denysamecitycodes, String checkmobilearea, String callincallerprefixes, String callincalleeprefixes, String callinforwardprefixes, String rewriterulesincallee, String rewriterulesinmobilearea, String rewriterulesincaller, String rewriterulesincallerusee164group, String rewriterulespidentity, String scheduledcallinprefixes, String scheduledrewriterulesin, String scheduledcapacity, String scheduledpriority, Integer timeoutsetup, Integer timeoutcallproceeding, Integer timeoutcallproceedingolc, Integer timeoutalerting, Integer timeoutinvite, Integer timeouttrying, Integer timeoutsessionprogresssdp, Integer timeoutsessionprogress, Integer timeoutringing, Integer stopswitchafterolc, Integer stopswitchaftersdp, Integer clearingaccountusecalloute164, Integer q931presentationindicator, Integer q931screeningindicator, Integer dtmfreceivemethod, Integer dtmfsendmethodh323, Integer dtmfsendmethodsip, Integer dtmfreceivepayloadtype, Integer dtmfsendpayloadtypeh323, Integer dtmfsendpayloadtypesip, Integer q931numberingplan, Integer q931numbertype, Integer sipresponseaddressmethod, Integer siprequestaddressmethod, Integer stopswitchafterrtpstart, Integer stopswitchafteruserbusy, Integer bitsofh323config, Integer bitsofsipconfig, Integer bitsofconfig, Integer callerallowlength, Integer calleeallowlength, String callerlimite164groups, String calleelimite164groups, String localip, String h323codecs, String sipcodecs, Integer calculateasr, Integer calculateacd, Integer minprofitpercent, Double maxsecondrates, Integer feeraterestrict, Integer leastcostrouting, Integer h323g729sendmode, Integer sipg729sendmode, Integer sipg729annexb, Integer sipg723annexa, Integer mediacheckdirection, Integer enablecalltransfer, Integer maxcalldurationlower, Integer maxcalldurationupper, Integer calleee164restrict, Integer enablephonedisplay, Integer switchuntilconnect, Integer maxcallrate, Integer maxcallrateunit, Integer sipremotepartyidscreen, Integer sipe164displaytype, Integer sipprivacytype, Integer sipppreferredidentitytype, Integer sippassertedidentitytype, String sipinvitecode, String sipauthenticationuser, String forwardsignalrewritee164group, String callinmappinggateways, long traceendtime, Double aassampling, String aaswordcategory, String stopswitchsipcodes, Integer gatewayroutingId) {
        this.callercitye164check = callercitye164check;
        this.calleecitye164check = calleecitye164check;
        this.denycallercallee = denycallercallee;
        this.denysamecitycodes = denysamecitycodes;
        this.checkmobilearea = checkmobilearea;
        this.callincallerprefixes = callincallerprefixes;
        this.callincalleeprefixes = callincalleeprefixes;
        this.callinforwardprefixes = callinforwardprefixes;
        this.rewriterulesincallee = rewriterulesincallee;
        this.rewriterulesinmobilearea = rewriterulesinmobilearea;
        this.rewriterulesincaller = rewriterulesincaller;
        this.rewriterulesincallerusee164group = rewriterulesincallerusee164group;
        this.rewriterulespidentity = rewriterulespidentity;
        this.scheduledcallinprefixes = scheduledcallinprefixes;
        this.scheduledrewriterulesin = scheduledrewriterulesin;
        this.scheduledcapacity = scheduledcapacity;
        this.scheduledpriority = scheduledpriority;
        this.timeoutsetup = timeoutsetup;
        this.timeoutcallproceeding = timeoutcallproceeding;
        this.timeoutcallproceedingolc = timeoutcallproceedingolc;
        this.timeoutalerting = timeoutalerting;
        this.timeoutinvite = timeoutinvite;
        this.timeouttrying = timeouttrying;
        this.timeoutsessionprogresssdp = timeoutsessionprogresssdp;
        this.timeoutsessionprogress = timeoutsessionprogress;
        this.timeoutringing = timeoutringing;
        this.stopswitchafterolc = stopswitchafterolc;
        this.stopswitchaftersdp = stopswitchaftersdp;
        this.clearingaccountusecalloute164 = clearingaccountusecalloute164;
        this.q931presentationindicator = q931presentationindicator;
        this.q931screeningindicator = q931screeningindicator;
        this.dtmfreceivemethod = dtmfreceivemethod;
        this.dtmfsendmethodh323 = dtmfsendmethodh323;
        this.dtmfsendmethodsip = dtmfsendmethodsip;
        this.dtmfreceivepayloadtype = dtmfreceivepayloadtype;
        this.dtmfsendpayloadtypeh323 = dtmfsendpayloadtypeh323;
        this.dtmfsendpayloadtypesip = dtmfsendpayloadtypesip;
        this.q931numberingplan = q931numberingplan;
        this.q931numbertype = q931numbertype;
        this.sipresponseaddressmethod = sipresponseaddressmethod;
        this.siprequestaddressmethod = siprequestaddressmethod;
        this.stopswitchafterrtpstart = stopswitchafterrtpstart;
        this.stopswitchafteruserbusy = stopswitchafteruserbusy;
        this.bitsofh323config = bitsofh323config;
        this.bitsofsipconfig = bitsofsipconfig;
        this.bitsofconfig = bitsofconfig;
        this.callerallowlength = callerallowlength;
        this.calleeallowlength = calleeallowlength;
        this.callerlimite164groups = callerlimite164groups;
        this.calleelimite164groups = calleelimite164groups;
        this.localip = localip;
        this.h323codecs = h323codecs;
        this.sipcodecs = sipcodecs;
        this.calculateasr = calculateasr;
        this.calculateacd = calculateacd;
        this.minprofitpercent = minprofitpercent;
        this.maxsecondrates = maxsecondrates;
        this.feeraterestrict = feeraterestrict;
        this.leastcostrouting = leastcostrouting;
        this.h323g729sendmode = h323g729sendmode;
        this.sipg729sendmode = sipg729sendmode;
        this.sipg729annexb = sipg729annexb;
        this.sipg723annexa = sipg723annexa;
        this.mediacheckdirection = mediacheckdirection;
        this.enablecalltransfer = enablecalltransfer;
        this.maxcalldurationlower = maxcalldurationlower;
        this.maxcalldurationupper = maxcalldurationupper;
        this.calleee164restrict = calleee164restrict;
        this.enablephonedisplay = enablephonedisplay;
        this.switchuntilconnect = switchuntilconnect;
        this.maxcallrate = maxcallrate;
        this.maxcallrateunit = maxcallrateunit;
        this.sipremotepartyidscreen = sipremotepartyidscreen;
        this.sipe164displaytype = sipe164displaytype;
        this.sipprivacytype = sipprivacytype;
        this.sipppreferredidentitytype = sipppreferredidentitytype;
        this.sippassertedidentitytype = sippassertedidentitytype;
        this.sipinvitecode = sipinvitecode;
        this.sipauthenticationuser = sipauthenticationuser;
        this.forwardsignalrewritee164group = forwardsignalrewritee164group;
        this.callinmappinggateways = callinmappinggateways;
        this.traceendtime = traceendtime;
        this.aassampling = aassampling;
        this.aaswordcategory = aaswordcategory;
        this.stopswitchsipcodes = stopswitchsipcodes;
        this.gatewayroutingId = gatewayroutingId;
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

    public String getDenycallercallee() {
        return denycallercallee;
    }

    public void setDenycallercallee(String denycallercallee) {
        this.denycallercallee = denycallercallee;
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

    public String getCallincallerprefixes() {
        return callincallerprefixes;
    }

    public void setCallincallerprefixes(String callincallerprefixes) {
        this.callincallerprefixes = callincallerprefixes;
    }

    public String getCallincalleeprefixes() {
        return callincalleeprefixes;
    }

    public void setCallincalleeprefixes(String callincalleeprefixes) {
        this.callincalleeprefixes = callincalleeprefixes;
    }

    public String getCallinforwardprefixes() {
        return callinforwardprefixes;
    }

    public void setCallinforwardprefixes(String callinforwardprefixes) {
        this.callinforwardprefixes = callinforwardprefixes;
    }

    public String getRewriterulesincallee() {
        return rewriterulesincallee;
    }

    public void setRewriterulesincallee(String rewriterulesincallee) {
        this.rewriterulesincallee = rewriterulesincallee;
    }

    public String getRewriterulesinmobilearea() {
        return rewriterulesinmobilearea;
    }

    public void setRewriterulesinmobilearea(String rewriterulesinmobilearea) {
        this.rewriterulesinmobilearea = rewriterulesinmobilearea;
    }

    public String getRewriterulesincaller() {
        return rewriterulesincaller;
    }

    public void setRewriterulesincaller(String rewriterulesincaller) {
        this.rewriterulesincaller = rewriterulesincaller;
    }

    public String getRewriterulesincallerusee164group() {
        return rewriterulesincallerusee164group;
    }

    public void setRewriterulesincallerusee164group(String rewriterulesincallerusee164group) {
        this.rewriterulesincallerusee164group = rewriterulesincallerusee164group;
    }

    public String getRewriterulespidentity() {
        return rewriterulespidentity;
    }

    public void setRewriterulespidentity(String rewriterulespidentity) {
        this.rewriterulespidentity = rewriterulespidentity;
    }

    public String getScheduledcallinprefixes() {
        return scheduledcallinprefixes;
    }

    public void setScheduledcallinprefixes(String scheduledcallinprefixes) {
        this.scheduledcallinprefixes = scheduledcallinprefixes;
    }

    public String getScheduledrewriterulesin() {
        return scheduledrewriterulesin;
    }

    public void setScheduledrewriterulesin(String scheduledrewriterulesin) {
        this.scheduledrewriterulesin = scheduledrewriterulesin;
    }

    public String getScheduledcapacity() {
        return scheduledcapacity;
    }

    public void setScheduledcapacity(String scheduledcapacity) {
        this.scheduledcapacity = scheduledcapacity;
    }

    public String getScheduledpriority() {
        return scheduledpriority;
    }

    public void setScheduledpriority(String scheduledpriority) {
        this.scheduledpriority = scheduledpriority;
    }

    public Integer getTimeoutsetup() {
        return timeoutsetup;
    }

    public void setTimeoutsetup(Integer timeoutsetup) {
        this.timeoutsetup = timeoutsetup;
    }

    public Integer getTimeoutcallproceeding() {
        return timeoutcallproceeding;
    }

    public void setTimeoutcallproceeding(Integer timeoutcallproceeding) {
        this.timeoutcallproceeding = timeoutcallproceeding;
    }

    public Integer getTimeoutcallproceedingolc() {
        return timeoutcallproceedingolc;
    }

    public void setTimeoutcallproceedingolc(Integer timeoutcallproceedingolc) {
        this.timeoutcallproceedingolc = timeoutcallproceedingolc;
    }

    public Integer getTimeoutalerting() {
        return timeoutalerting;
    }

    public void setTimeoutalerting(Integer timeoutalerting) {
        this.timeoutalerting = timeoutalerting;
    }

    public Integer getTimeoutinvite() {
        return timeoutinvite;
    }

    public void setTimeoutinvite(Integer timeoutinvite) {
        this.timeoutinvite = timeoutinvite;
    }

    public Integer getTimeouttrying() {
        return timeouttrying;
    }

    public void setTimeouttrying(Integer timeouttrying) {
        this.timeouttrying = timeouttrying;
    }

    public Integer getTimeoutsessionprogresssdp() {
        return timeoutsessionprogresssdp;
    }

    public void setTimeoutsessionprogresssdp(Integer timeoutsessionprogresssdp) {
        this.timeoutsessionprogresssdp = timeoutsessionprogresssdp;
    }

    public Integer getTimeoutsessionprogress() {
        return timeoutsessionprogress;
    }

    public void setTimeoutsessionprogress(Integer timeoutsessionprogress) {
        this.timeoutsessionprogress = timeoutsessionprogress;
    }

    public Integer getTimeoutringing() {
        return timeoutringing;
    }

    public void setTimeoutringing(Integer timeoutringing) {
        this.timeoutringing = timeoutringing;
    }

    public Integer getStopswitchafterolc() {
        return stopswitchafterolc;
    }

    public void setStopswitchafterolc(Integer stopswitchafterolc) {
        this.stopswitchafterolc = stopswitchafterolc;
    }

    public Integer getStopswitchaftersdp() {
        return stopswitchaftersdp;
    }

    public void setStopswitchaftersdp(Integer stopswitchaftersdp) {
        this.stopswitchaftersdp = stopswitchaftersdp;
    }

    public Integer getClearingaccountusecalloute164() {
        return clearingaccountusecalloute164;
    }

    public void setClearingaccountusecalloute164(Integer clearingaccountusecalloute164) {
        this.clearingaccountusecalloute164 = clearingaccountusecalloute164;
    }

    public Integer getQ931presentationindicator() {
        return q931presentationindicator;
    }

    public void setQ931presentationindicator(Integer q931presentationindicator) {
        this.q931presentationindicator = q931presentationindicator;
    }

    public Integer getQ931screeningindicator() {
        return q931screeningindicator;
    }

    public void setQ931screeningindicator(Integer q931screeningindicator) {
        this.q931screeningindicator = q931screeningindicator;
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

    public Integer getQ931numberingplan() {
        return q931numberingplan;
    }

    public void setQ931numberingplan(Integer q931numberingplan) {
        this.q931numberingplan = q931numberingplan;
    }

    public Integer getQ931numbertype() {
        return q931numbertype;
    }

    public void setQ931numbertype(Integer q931numbertype) {
        this.q931numbertype = q931numbertype;
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

    public Integer getStopswitchafterrtpstart() {
        return stopswitchafterrtpstart;
    }

    public void setStopswitchafterrtpstart(Integer stopswitchafterrtpstart) {
        this.stopswitchafterrtpstart = stopswitchafterrtpstart;
    }

    public Integer getStopswitchafteruserbusy() {
        return stopswitchafteruserbusy;
    }

    public void setStopswitchafteruserbusy(Integer stopswitchafteruserbusy) {
        this.stopswitchafteruserbusy = stopswitchafteruserbusy;
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

    public String getLocalip() {
        return localip;
    }

    public void setLocalip(String localip) {
        this.localip = localip;
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

    public Integer getMinprofitpercent() {
        return minprofitpercent;
    }

    public void setMinprofitpercent(Integer minprofitpercent) {
        this.minprofitpercent = minprofitpercent;
    }

    public Double getMaxsecondrates() {
        return maxsecondrates;
    }

    public void setMaxsecondrates(Double maxsecondrates) {
        this.maxsecondrates = maxsecondrates;
    }

    public Integer getFeeraterestrict() {
        return feeraterestrict;
    }

    public void setFeeraterestrict(Integer feeraterestrict) {
        this.feeraterestrict = feeraterestrict;
    }

    public Integer getLeastcostrouting() {
        return leastcostrouting;
    }

    public void setLeastcostrouting(Integer leastcostrouting) {
        this.leastcostrouting = leastcostrouting;
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

    public Integer getEnablecalltransfer() {
        return enablecalltransfer;
    }

    public void setEnablecalltransfer(Integer enablecalltransfer) {
        this.enablecalltransfer = enablecalltransfer;
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

    public Integer getCalleee164restrict() {
        return calleee164restrict;
    }

    public void setCalleee164restrict(Integer calleee164restrict) {
        this.calleee164restrict = calleee164restrict;
    }

    public Integer getEnablephonedisplay() {
        return enablephonedisplay;
    }

    public void setEnablephonedisplay(Integer enablephonedisplay) {
        this.enablephonedisplay = enablephonedisplay;
    }

    public Integer getSwitchuntilconnect() {
        return switchuntilconnect;
    }

    public void setSwitchuntilconnect(Integer switchuntilconnect) {
        this.switchuntilconnect = switchuntilconnect;
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

    public Integer getSipremotepartyidscreen() {
        return sipremotepartyidscreen;
    }

    public void setSipremotepartyidscreen(Integer sipremotepartyidscreen) {
        this.sipremotepartyidscreen = sipremotepartyidscreen;
    }

    public Integer getSipe164displaytype() {
        return sipe164displaytype;
    }

    public void setSipe164displaytype(Integer sipe164displaytype) {
        this.sipe164displaytype = sipe164displaytype;
    }

    public Integer getSipprivacytype() {
        return sipprivacytype;
    }

    public void setSipprivacytype(Integer sipprivacytype) {
        this.sipprivacytype = sipprivacytype;
    }

    public Integer getSipppreferredidentitytype() {
        return sipppreferredidentitytype;
    }

    public void setSipppreferredidentitytype(Integer sipppreferredidentitytype) {
        this.sipppreferredidentitytype = sipppreferredidentitytype;
    }

    public Integer getSippassertedidentitytype() {
        return sippassertedidentitytype;
    }

    public void setSippassertedidentitytype(Integer sippassertedidentitytype) {
        this.sippassertedidentitytype = sippassertedidentitytype;
    }

    public String getSipinvitecode() {
        return sipinvitecode;
    }

    public void setSipinvitecode(String sipinvitecode) {
        this.sipinvitecode = sipinvitecode;
    }

    public String getSipauthenticationuser() {
        return sipauthenticationuser;
    }

    public void setSipauthenticationuser(String sipauthenticationuser) {
        this.sipauthenticationuser = sipauthenticationuser;
    }

    public String getForwardsignalrewritee164group() {
        return forwardsignalrewritee164group;
    }

    public void setForwardsignalrewritee164group(String forwardsignalrewritee164group) {
        this.forwardsignalrewritee164group = forwardsignalrewritee164group;
    }

    public String getCallinmappinggateways() {
        return callinmappinggateways;
    }

    public void setCallinmappinggateways(String callinmappinggateways) {
        this.callinmappinggateways = callinmappinggateways;
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

    public String getStopswitchsipcodes() {
        return stopswitchsipcodes;
    }

    public void setStopswitchsipcodes(String stopswitchsipcodes) {
        this.stopswitchsipcodes = stopswitchsipcodes;
    }

    public Integer getGatewayroutingId() {
        return gatewayroutingId;
    }

    public void setGatewayroutingId(Integer gatewayroutingId) {
        this.gatewayroutingId = gatewayroutingId;
    }
}
