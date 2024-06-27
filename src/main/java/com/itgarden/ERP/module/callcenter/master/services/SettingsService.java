/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/springframework/Service.java to edit this template
 */
package com.itgarden.ERP.module.callcenter.master.services;

import com.itgarden.ERP.module.callcenter.master.model.Settings;
import com.itgarden.ERP.module.callcenter.master.ripository.SettingsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author libertyerp_local
 */
@Service
public class SettingsService {

    @Autowired
    SettingsRepository settingsRepository;

    public int scantime() {

        Settings settings = settingsRepository.findOne(2l);

        int millisecond;

        if (settings != null) {

            millisecond = settings.getCdrDataScanTime() * 60 * 1000;

        } else {

            millisecond = 0;
        }

        return millisecond;
    }

    public int callerpdd() {

        Settings settings = settingsRepository.findOne(2l);

        int callerpdd;

        if (settings != null) {

            callerpdd = settings.getCallerpdd();

        } else {

            callerpdd = 1;
        }

        return callerpdd;
    }
    
    
    public int repeatNumber() {

        Settings settings = settingsRepository.findOne(2l);

        int callerpdd;

        if (settings != null) {

            callerpdd = settings.getNumberRepet();

        } else {

            callerpdd = 1;
        }

        return callerpdd;
    }
    
    
    

}
