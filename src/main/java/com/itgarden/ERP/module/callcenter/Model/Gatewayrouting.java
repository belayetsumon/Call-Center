package com.itgarden.ERP.module.callcenter.Model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
@Table(name = "e_gatewayrouting")

public class Gatewayrouting implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int id;

    @Size(max = 255)
    @Column(name = "name")
    private String name;
    @Lob
    @Size(max = 65535)
    @Column(name = "prefix",columnDefinition = "TEXT")
    private String prefix;
    @Column(name = "prefixstyle")
    private Integer prefixstyle;
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
    @Column(name = "iptype")
    private Integer iptype;
    @Column(name = "encrypt")
    private Integer encrypt;
    @Column(name = "protocol")
    private Integer protocol;
    @Lob
    @Size(max = 65535)
    @Column(name = "remoteips",columnDefinition = "TEXT")
    private String remoteips;
    @Column(name = "rtpforwardtype")
    private Integer rtpforwardtype;
    @Column(name = "signalport")
    private Integer signalport;
    @Column(name = "signalportlocal")
    private Integer signalportlocal;
    @Lob
    @Size(max = 65535)
    @Column(name = "gatewaygroups",columnDefinition = "TEXT")
    private String gatewaygroups;
    @Size(max = 255)
    @Column(name = "memo")
    private String memo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "mbx_id")
    private int mbxId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "clearingcustomer_id")
    private int clearingcustomerId;

    public Gatewayrouting() {
    }

    public Gatewayrouting(Integer id, String name, String prefix, Integer prefixstyle, String password, String customerpassword, Integer locktype, Integer calllevel, Integer capacity, Integer priority, Integer iptype, Integer encrypt, Integer protocol, String remoteips, Integer rtpforwardtype, Integer signalport, Integer signalportlocal, String gatewaygroups, String memo, int mbxId, int clearingcustomerId) {
        this.id = id;
        this.name = name;
        this.prefix = prefix;
        this.prefixstyle = prefixstyle;
        this.password = password;
        this.customerpassword = customerpassword;
        this.locktype = locktype;
        this.calllevel = calllevel;
        this.capacity = capacity;
        this.priority = priority;
        this.iptype = iptype;
        this.encrypt = encrypt;
        this.protocol = protocol;
        this.remoteips = remoteips;
        this.rtpforwardtype = rtpforwardtype;
        this.signalport = signalport;
        this.signalportlocal = signalportlocal;
        this.gatewaygroups = gatewaygroups;
        this.memo = memo;
        this.mbxId = mbxId;
        this.clearingcustomerId = clearingcustomerId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrefix() {
        return prefix;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    public Integer getPrefixstyle() {
        return prefixstyle;
    }

    public void setPrefixstyle(Integer prefixstyle) {
        this.prefixstyle = prefixstyle;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCustomerpassword() {
        return customerpassword;
    }

    public void setCustomerpassword(String customerpassword) {
        this.customerpassword = customerpassword;
    }

    public Integer getLocktype() {
        return locktype;
    }

    public void setLocktype(Integer locktype) {
        this.locktype = locktype;
    }

    public Integer getCalllevel() {
        return calllevel;
    }

    public void setCalllevel(Integer calllevel) {
        this.calllevel = calllevel;
    }

    public Integer getCapacity() {
        return capacity;
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }

    public Integer getPriority() {
        return priority;
    }

    public void setPriority(Integer priority) {
        this.priority = priority;
    }

    public Integer getIptype() {
        return iptype;
    }

    public void setIptype(Integer iptype) {
        this.iptype = iptype;
    }

    public Integer getEncrypt() {
        return encrypt;
    }

    public void setEncrypt(Integer encrypt) {
        this.encrypt = encrypt;
    }

    public Integer getProtocol() {
        return protocol;
    }

    public void setProtocol(Integer protocol) {
        this.protocol = protocol;
    }

    public String getRemoteips() {
        return remoteips;
    }

    public void setRemoteips(String remoteips) {
        this.remoteips = remoteips;
    }

    public Integer getRtpforwardtype() {
        return rtpforwardtype;
    }

    public void setRtpforwardtype(Integer rtpforwardtype) {
        this.rtpforwardtype = rtpforwardtype;
    }

    public Integer getSignalport() {
        return signalport;
    }

    public void setSignalport(Integer signalport) {
        this.signalport = signalport;
    }

    public Integer getSignalportlocal() {
        return signalportlocal;
    }

    public void setSignalportlocal(Integer signalportlocal) {
        this.signalportlocal = signalportlocal;
    }

    public String getGatewaygroups() {
        return gatewaygroups;
    }

    public void setGatewaygroups(String gatewaygroups) {
        this.gatewaygroups = gatewaygroups;
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }

    public int getMbxId() {
        return mbxId;
    }

    public void setMbxId(int mbxId) {
        this.mbxId = mbxId;
    }

    public int getClearingcustomerId() {
        return clearingcustomerId;
    }

    public void setClearingcustomerId(int clearingcustomerId) {
        this.clearingcustomerId = clearingcustomerId;
    }
}
