/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.itgarden.ERP.globalcomponant;

import com.itgarden.ERP.module.callcenter.Model.ECdr;
import com.itgarden.ERP.module.callcenter.master.model.CdrTemp;
import com.itgarden.ERP.module.callcenter.master.ripository.CdrTempRepository;
import com.itgarden.ERP.module.callcenter.master.services.AssignedNumberService;
import com.itgarden.ERP.module.callcenter.master.services.DataScanTimeService;
import com.itgarden.ERP.module.callcenter.master.services.SettingsService;
import com.itgarden.ERP.module.callcenter.services.CdrService;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 *
 * @author libertyerp_local
 */
@Component
public class PeriodicTask {

    @Autowired
    CdrService cdrService;

    @Autowired
    static SettingsService settingsService;

    @Autowired
    CdrTempRepository cdrTempRepository;

    @Autowired
    AssignedNumberService assignedNumberService;
    @Autowired
    DataScanTimeService dataScanTimeService;

//    @Value("${cdnumber.scanTime}")
//    final long cornJobTime;
//
    @Scheduled(fixedDelayString = "300000")
    //@Scheduled(fixedDelayString = "1800000")
    public void everyFiveSeconds() {

        List<ECdr> eCdrList = cdrService.list4();

        ModelMapper modelMapper = new ModelMapper();

        List<CdrTemp> cdrTempList = new ArrayList<CdrTemp>();

        // System.out.println("total dtata ######## "+cdrTempList.size());
        Type listType = new TypeToken<List<CdrTemp>>() {
        }.getType();

        List<CdrTemp> cdrTempListnew = modelMapper.map(eCdrList, listType);

        //        System.out.println("total data ######## " + cdrTempListnew.size());
        for (CdrTemp entity : cdrTempListnew) {
            cdrTempRepository.save(entity);
        }

        assignedNumberService.numberAssign();

        assignedNumberService.gatewayRoutingGatewayRoutingPrefixDataConcat();
        assignedNumberService.gatewayRoutingSettingRewriteRulesDataConcat();
        /// scan time save

        dataScanTimeService.savescantime();
    }
}
