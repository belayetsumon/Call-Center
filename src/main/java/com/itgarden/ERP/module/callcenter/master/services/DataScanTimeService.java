/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/springframework/Service.java to edit this template
 */
package com.itgarden.ERP.module.callcenter.master.services;

import com.itgarden.ERP.module.callcenter.master.model.DataScanTime;
import com.itgarden.ERP.module.callcenter.master.ripository.DataScanTimeRepository;
import com.itgarden.ERP.module.callcenter.services.CdrService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author libertyerp_local
 */
@Service
public class DataScanTimeService {

    @Autowired
    DataScanTimeRepository dataScanTimeRepository;

    @Autowired
    CdrService cdrService;

    public void savescantime() {

        DataScanTime dataScanTime = new DataScanTime();

        dataScanTime.setCdrdatasize(cdrService.list4().size());

        dataScanTimeRepository.save(dataScanTime);

    }

}
