
package com.itgarden.ERP.module.callcenter.Model;

import java.io.Serializable;
import java.math.BigDecimal;
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
@Table(name = "e_cdr")

public class ECdr implements Serializable {

    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @NotNull
    @Column(name = "id")
    public int id;
    @Size(max = 64)
    @Column(name = "callere164")
    private String callere164;
    @Size(max = 64)
    @Column(name = "calleraccesse164")
    private String calleraccesse164;
    @Size(max = 64)
    @Column(name = "calleee164")
    private String calleee164;
    @Size(max = 64)
    @Column(name = "calleeaccesse164")
    private String calleeaccesse164;
    @Size(max = 64)
    @Column(name = "callerip")
    private String callerip;
    @Size(max = 64)
    @Column(name = "callerrtpip")
    private String callerrtpip;
    @Size(max = 64)
    @Column(name = "callercodec")
    private String callercodec;
    @Size(max = 64)
    @Column(name = "callergatewayid")
    private String callergatewayid;
    @Size(max = 64)
    @Column(name = "callerproductid")
    private String callerproductid;
    @Size(max = 64)
    @Column(name = "callertogatewaye164")
    private String callertogatewaye164;
    @Column(name = "callertype")
    private Integer callertype;
    @Size(max = 64)
    @Column(name = "calleeip")
    private String calleeip;
    @Size(max = 64)
    @Column(name = "calleertpip")
    private String calleertpip;
    @Size(max = 64)
    @Column(name = "calleecodec")
    private String calleecodec;
    @Size(max = 64)
    @Column(name = "calleegatewayid")
    private String calleegatewayid;
    @Size(max = 64)
    @Column(name = "calleeproductid")
    private String calleeproductid;
    @Size(max = 64)
    @Column(name = "calleetogatewaye164")
    private String calleetogatewaye164;
    @Column(name = "calleetype")
    private Integer calleetype;
    @Column(name = "billingmode")
    private Integer billingmode;
    @Column(name = "calllevel")
    private Integer calllevel;
    @Column(name = "agentfeetime")
    private Integer agentfeetime;
    @Column(name = "starttime")
    private long starttime;
    @Column(name = "stoptime")
    private long stoptime;
    @Column(name = "callerpdd")
    private Integer callerpdd;
    @Column(name = "calleepdd")
    private Integer calleepdd;
    @Column(name = "holdtime")
    private Integer holdtime;
    @Size(max = 64)
    @Column(name = "callerareacode")
    private String callerareacode;
    @Column(name = "feetime")
    private Integer feetime;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "fee")
    private Double fee;
    @Column(name = "tax")
    private Double tax;
    @Column(name = "suitefee")
    private Double suitefee;
    @Column(name = "suitefeetime")
    private Integer suitefeetime;
    @Column(name = "incomefee")
    private Double incomefee;
    @Column(name = "incometax")
    private Double incometax;
    @Size(max = 255)
    @Column(name = "customeraccount")
    private String customeraccount;
    @Size(max = 255)
    @Column(name = "customername")
    private String customername;
    @Size(max = 64)
    @Column(name = "calleeareacode")
    private String calleeareacode;
    @Column(name = "agentfee")
    private Double agentfee;
    @Column(name = "agenttax")
    private Double agenttax;
    @Column(name = "agentsuitefee")
    private Double agentsuitefee;
    @Column(name = "agentsuitefeetime")
    private Integer agentsuitefeetime;
    @Size(max = 255)
    @Column(name = "agentaccount")
    private String agentaccount;
    @Size(max = 255)
    @Column(name = "agentname")
    private String agentname;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "flowno")
    private Long flowno;
    @Size(max = 64)
    @Column(name = "softswitchname")
    private String softswitchname;
    @Column(name = "softswitchcallid")
    private long softswitchcallid;
    @Size(max = 64)
    @Column(name = "callercallid")
    private String callercallid;
    @Size(max = 64)
    @Column(name = "calleroriginalcallid")
    private String calleroriginalcallid;
    @Size(max = 64)
    @Column(name = "calleecallid")
    private String calleecallid;
    @Size(max = 255)
    @Column(name = "calleroriginalinfo")
    private String calleroriginalinfo;
    @Column(name = "rtpforward")
    private Integer rtpforward;
    @Column(name = "enddirection")
    private Integer enddirection;
    @Column(name = "endreason")
    private Integer endreason;
    @Column(name = "billingtype")
    private Integer billingtype;
    @Column(name = "cdrlevel")
    private Integer cdrlevel;
    @Column(name = "agentcdr_id")
    private Integer agentcdrId;
    @Size(max = 64)
    @Column(name = "sipreasonheader")
    private String sipreasonheader;
    @Column(name = "recordstarttime")
    private long  recordstarttime;
    @Size(max = 64)
    @Column(name = "transactionid")
    private String transactionid;

    public ECdr() {
    }

    public ECdr(int id, String callere164, String calleraccesse164, String calleee164, String calleeaccesse164, String callerip, String callerrtpip, String callercodec, String callergatewayid, String callerproductid, String callertogatewaye164, Integer callertype, String calleeip, String calleertpip, String calleecodec, String calleegatewayid, String calleeproductid, String calleetogatewaye164, Integer calleetype, Integer billingmode, Integer calllevel, Integer agentfeetime, long starttime, long stoptime, Integer callerpdd, Integer calleepdd, Integer holdtime, String callerareacode, Integer feetime, Double fee, Double tax, Double suitefee, Integer suitefeetime, Double incomefee, Double incometax, String customeraccount, String customername, String calleeareacode, Double agentfee, Double agenttax, Double agentsuitefee, Integer agentsuitefeetime, String agentaccount, String agentname, Long flowno, String softswitchname, long softswitchcallid, String callercallid, String calleroriginalcallid, String calleecallid, String calleroriginalinfo, Integer rtpforward, Integer enddirection, Integer endreason, Integer billingtype, Integer cdrlevel, Integer agentcdrId, String sipreasonheader, long recordstarttime, String transactionid) {
        this.id = id;
        this.callere164 = callere164;
        this.calleraccesse164 = calleraccesse164;
        this.calleee164 = calleee164;
        this.calleeaccesse164 = calleeaccesse164;
        this.callerip = callerip;
        this.callerrtpip = callerrtpip;
        this.callercodec = callercodec;
        this.callergatewayid = callergatewayid;
        this.callerproductid = callerproductid;
        this.callertogatewaye164 = callertogatewaye164;
        this.callertype = callertype;
        this.calleeip = calleeip;
        this.calleertpip = calleertpip;
        this.calleecodec = calleecodec;
        this.calleegatewayid = calleegatewayid;
        this.calleeproductid = calleeproductid;
        this.calleetogatewaye164 = calleetogatewaye164;
        this.calleetype = calleetype;
        this.billingmode = billingmode;
        this.calllevel = calllevel;
        this.agentfeetime = agentfeetime;
        this.starttime = starttime;
        this.stoptime = stoptime;
        this.callerpdd = callerpdd;
        this.calleepdd = calleepdd;
        this.holdtime = holdtime;
        this.callerareacode = callerareacode;
        this.feetime = feetime;
        this.fee = fee;
        this.tax = tax;
        this.suitefee = suitefee;
        this.suitefeetime = suitefeetime;
        this.incomefee = incomefee;
        this.incometax = incometax;
        this.customeraccount = customeraccount;
        this.customername = customername;
        this.calleeareacode = calleeareacode;
        this.agentfee = agentfee;
        this.agenttax = agenttax;
        this.agentsuitefee = agentsuitefee;
        this.agentsuitefeetime = agentsuitefeetime;
        this.agentaccount = agentaccount;
        this.agentname = agentname;
        this.flowno = flowno;
        this.softswitchname = softswitchname;
        this.softswitchcallid = softswitchcallid;
        this.callercallid = callercallid;
        this.calleroriginalcallid = calleroriginalcallid;
        this.calleecallid = calleecallid;
        this.calleroriginalinfo = calleroriginalinfo;
        this.rtpforward = rtpforward;
        this.enddirection = enddirection;
        this.endreason = endreason;
        this.billingtype = billingtype;
        this.cdrlevel = cdrlevel;
        this.agentcdrId = agentcdrId;
        this.sipreasonheader = sipreasonheader;
        this.recordstarttime = recordstarttime;
        this.transactionid = transactionid;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCallere164() {
        return callere164;
    }

    public void setCallere164(String callere164) {
        this.callere164 = callere164;
    }

    public String getCalleraccesse164() {
        return calleraccesse164;
    }

    public void setCalleraccesse164(String calleraccesse164) {
        this.calleraccesse164 = calleraccesse164;
    }

    public String getCalleee164() {
        return calleee164;
    }

    public void setCalleee164(String calleee164) {
        this.calleee164 = calleee164;
    }

    public String getCalleeaccesse164() {
        return calleeaccesse164;
    }

    public void setCalleeaccesse164(String calleeaccesse164) {
        this.calleeaccesse164 = calleeaccesse164;
    }

    public String getCallerip() {
        return callerip;
    }

    public void setCallerip(String callerip) {
        this.callerip = callerip;
    }

    public String getCallerrtpip() {
        return callerrtpip;
    }

    public void setCallerrtpip(String callerrtpip) {
        this.callerrtpip = callerrtpip;
    }

    public String getCallercodec() {
        return callercodec;
    }

    public void setCallercodec(String callercodec) {
        this.callercodec = callercodec;
    }

    public String getCallergatewayid() {
        return callergatewayid;
    }

    public void setCallergatewayid(String callergatewayid) {
        this.callergatewayid = callergatewayid;
    }

    public String getCallerproductid() {
        return callerproductid;
    }

    public void setCallerproductid(String callerproductid) {
        this.callerproductid = callerproductid;
    }

    public String getCallertogatewaye164() {
        return callertogatewaye164;
    }

    public void setCallertogatewaye164(String callertogatewaye164) {
        this.callertogatewaye164 = callertogatewaye164;
    }

    public Integer getCallertype() {
        return callertype;
    }

    public void setCallertype(Integer callertype) {
        this.callertype = callertype;
    }

    public String getCalleeip() {
        return calleeip;
    }

    public void setCalleeip(String calleeip) {
        this.calleeip = calleeip;
    }

    public String getCalleertpip() {
        return calleertpip;
    }

    public void setCalleertpip(String calleertpip) {
        this.calleertpip = calleertpip;
    }

    public String getCalleecodec() {
        return calleecodec;
    }

    public void setCalleecodec(String calleecodec) {
        this.calleecodec = calleecodec;
    }

    public String getCalleegatewayid() {
        return calleegatewayid;
    }

    public void setCalleegatewayid(String calleegatewayid) {
        this.calleegatewayid = calleegatewayid;
    }

    public String getCalleeproductid() {
        return calleeproductid;
    }

    public void setCalleeproductid(String calleeproductid) {
        this.calleeproductid = calleeproductid;
    }

    public String getCalleetogatewaye164() {
        return calleetogatewaye164;
    }

    public void setCalleetogatewaye164(String calleetogatewaye164) {
        this.calleetogatewaye164 = calleetogatewaye164;
    }

    public Integer getCalleetype() {
        return calleetype;
    }

    public void setCalleetype(Integer calleetype) {
        this.calleetype = calleetype;
    }

    public Integer getBillingmode() {
        return billingmode;
    }

    public void setBillingmode(Integer billingmode) {
        this.billingmode = billingmode;
    }

    public Integer getCalllevel() {
        return calllevel;
    }

    public void setCalllevel(Integer calllevel) {
        this.calllevel = calllevel;
    }

    public Integer getAgentfeetime() {
        return agentfeetime;
    }

    public void setAgentfeetime(Integer agentfeetime) {
        this.agentfeetime = agentfeetime;
    }

    public long getStarttime() {
        return starttime;
    }

    public void setStarttime(long starttime) {
        this.starttime = starttime;
    }

    public long getStoptime() {
        return stoptime;
    }

    public void setStoptime(long stoptime) {
        this.stoptime = stoptime;
    }

    public Integer getCallerpdd() {
        return callerpdd;
    }

    public void setCallerpdd(Integer callerpdd) {
        this.callerpdd = callerpdd;
    }

    public Integer getCalleepdd() {
        return calleepdd;
    }

    public void setCalleepdd(Integer calleepdd) {
        this.calleepdd = calleepdd;
    }

    public Integer getHoldtime() {
        return holdtime;
    }

    public void setHoldtime(Integer holdtime) {
        this.holdtime = holdtime;
    }

    public String getCallerareacode() {
        return callerareacode;
    }

    public void setCallerareacode(String callerareacode) {
        this.callerareacode = callerareacode;
    }

    public Integer getFeetime() {
        return feetime;
    }

    public void setFeetime(Integer feetime) {
        this.feetime = feetime;
    }

    public Double getFee() {
        return fee;
    }

    public void setFee(Double fee) {
        this.fee = fee;
    }

    public Double getTax() {
        return tax;
    }

    public void setTax(Double tax) {
        this.tax = tax;
    }

    public Double getSuitefee() {
        return suitefee;
    }

    public void setSuitefee(Double suitefee) {
        this.suitefee = suitefee;
    }

    public Integer getSuitefeetime() {
        return suitefeetime;
    }

    public void setSuitefeetime(Integer suitefeetime) {
        this.suitefeetime = suitefeetime;
    }

    public Double getIncomefee() {
        return incomefee;
    }

    public void setIncomefee(Double incomefee) {
        this.incomefee = incomefee;
    }

    public Double getIncometax() {
        return incometax;
    }

    public void setIncometax(Double incometax) {
        this.incometax = incometax;
    }

    public String getCustomeraccount() {
        return customeraccount;
    }

    public void setCustomeraccount(String customeraccount) {
        this.customeraccount = customeraccount;
    }

    public String getCustomername() {
        return customername;
    }

    public void setCustomername(String customername) {
        this.customername = customername;
    }

    public String getCalleeareacode() {
        return calleeareacode;
    }

    public void setCalleeareacode(String calleeareacode) {
        this.calleeareacode = calleeareacode;
    }

    public Double getAgentfee() {
        return agentfee;
    }

    public void setAgentfee(Double agentfee) {
        this.agentfee = agentfee;
    }

    public Double getAgenttax() {
        return agenttax;
    }

    public void setAgenttax(Double agenttax) {
        this.agenttax = agenttax;
    }

    public Double getAgentsuitefee() {
        return agentsuitefee;
    }

    public void setAgentsuitefee(Double agentsuitefee) {
        this.agentsuitefee = agentsuitefee;
    }

    public Integer getAgentsuitefeetime() {
        return agentsuitefeetime;
    }

    public void setAgentsuitefeetime(Integer agentsuitefeetime) {
        this.agentsuitefeetime = agentsuitefeetime;
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

    public Long getFlowno() {
        return flowno;
    }

    public void setFlowno(Long flowno) {
        this.flowno = flowno;
    }

    public String getSoftswitchname() {
        return softswitchname;
    }

    public void setSoftswitchname(String softswitchname) {
        this.softswitchname = softswitchname;
    }

    public long getSoftswitchcallid() {
        return softswitchcallid;
    }

    public void setSoftswitchcallid(long softswitchcallid) {
        this.softswitchcallid = softswitchcallid;
    }

    public String getCallercallid() {
        return callercallid;
    }

    public void setCallercallid(String callercallid) {
        this.callercallid = callercallid;
    }

    public String getCalleroriginalcallid() {
        return calleroriginalcallid;
    }

    public void setCalleroriginalcallid(String calleroriginalcallid) {
        this.calleroriginalcallid = calleroriginalcallid;
    }

    public String getCalleecallid() {
        return calleecallid;
    }

    public void setCalleecallid(String calleecallid) {
        this.calleecallid = calleecallid;
    }

    public String getCalleroriginalinfo() {
        return calleroriginalinfo;
    }

    public void setCalleroriginalinfo(String calleroriginalinfo) {
        this.calleroriginalinfo = calleroriginalinfo;
    }

    public Integer getRtpforward() {
        return rtpforward;
    }

    public void setRtpforward(Integer rtpforward) {
        this.rtpforward = rtpforward;
    }

    public Integer getEnddirection() {
        return enddirection;
    }

    public void setEnddirection(Integer enddirection) {
        this.enddirection = enddirection;
    }

    public Integer getEndreason() {
        return endreason;
    }

    public void setEndreason(Integer endreason) {
        this.endreason = endreason;
    }

    public Integer getBillingtype() {
        return billingtype;
    }

    public void setBillingtype(Integer billingtype) {
        this.billingtype = billingtype;
    }

    public Integer getCdrlevel() {
        return cdrlevel;
    }

    public void setCdrlevel(Integer cdrlevel) {
        this.cdrlevel = cdrlevel;
    }

    public Integer getAgentcdrId() {
        return agentcdrId;
    }

    public void setAgentcdrId(Integer agentcdrId) {
        this.agentcdrId = agentcdrId;
    }

    public String getSipreasonheader() {
        return sipreasonheader;
    }

    public void setSipreasonheader(String sipreasonheader) {
        this.sipreasonheader = sipreasonheader;
    }

    public long getRecordstarttime() {
        return recordstarttime;
    }

    public void setRecordstarttime(long recordstarttime) {
        this.recordstarttime = recordstarttime;
    }

    public String getTransactionid() {
        return transactionid;
    }

    public void setTransactionid(String transactionid) {
        this.transactionid = transactionid;
    }
}