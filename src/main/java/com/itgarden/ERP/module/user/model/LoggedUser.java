/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.itgarden.ERP.module.user.model;

/**
 *
 * @author User
 */
public class LoggedUser {
    
  public  Long id;
  
  public String userName;

    public LoggedUser(Long id, String userName) {
        this.id = id;
        this.userName = userName;
    }

    public LoggedUser() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

}
