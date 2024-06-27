/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.itgarden.ERP.module.callcenter.master.model;

/**
 *
 * @author libertyerp_local
 */
public class CdrTempCountDTO {

    public int id;
    
    private String calleee164;

    private String calleeecount;

    public CdrTempCountDTO() {
    }

    public CdrTempCountDTO(int id, String calleee164, String calleeecount) {
        this.id = id;
        this.calleee164 = calleee164;
        this.calleeecount = calleeecount;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCalleee164() {
        return calleee164;
    }

    public void setCalleee164(String calleee164) {
        this.calleee164 = calleee164;
    }

    public String getCalleeecount() {
        return calleeecount;
    }

    public void setCalleeecount(String calleeecount) {
        this.calleeecount = calleeecount;
    }
    
}
