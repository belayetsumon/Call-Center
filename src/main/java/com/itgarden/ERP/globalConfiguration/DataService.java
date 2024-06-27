/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/springframework/Service.java to edit this template
 */
package com.itgarden.ERP.globalConfiguration;

import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 *
 * @author libertyerp_local
 */
@Service
public class DataService {

    private final DataSource masterDataSource;
    private final DataSource childDataSource;

    public DataService(
            @Qualifier("masterDataSource") DataSource masterDataSource,
            @Qualifier("childDataSource") DataSource childDataSource) {
        this.masterDataSource = masterDataSource;
        this.childDataSource = childDataSource;
    }

}
