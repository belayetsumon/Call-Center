/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/springframework/Service.java to edit this template
 */
package com.itgarden.ERP.module.settings.services.company_setup;

import org.springframework.stereotype.Service;

/**
 *
 * @author Admin
 */
@Service
public class DatabaseBackUpService {

    public String dbUserName;

    public String dbPassword;

    public String dbName;
    
    String filePath = "C:\\myFirstDump.sql";
        int status ;

    public void databaseBackup() {
        
        
        String executeCmd = "C:\\wamp\\bin\\mysql\\mysql5.5.8\\bin\\mysqldump -u " + dbUserName + " -p" + dbPassword + " " + dbName + " -r " + filePath;
 
        try {
            Process runtimeProcess = Runtime.getRuntime().exec(executeCmd);
            status = runtimeProcess.waitFor();
            if (status == 0) {
                System.out.println("Backup taken successfully");
            } else {
                System.out.println("Could not take mysql backup");
            }
        } catch (Exception e) {
            System.out.println("Exception " + e);
        }

    }

}
