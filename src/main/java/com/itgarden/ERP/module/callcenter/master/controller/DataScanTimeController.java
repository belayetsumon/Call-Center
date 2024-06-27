/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/springframework/Controller.java to edit this template
 */
package com.itgarden.ERP.module.callcenter.master.controller;

import com.itgarden.ERP.module.callcenter.master.ripository.DataScanTimeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author libertyerp_local
 */
@Controller
@RequestMapping("/datascantime")
public class DataScanTimeController {

    @Autowired
    DataScanTimeRepository dataScanTimeRepository;

    @RequestMapping("/index")
    public String index(Model model) {

        Sort sort = new Sort(Sort.Direction.DESC, "created");
        model.addAttribute("list", dataScanTimeRepository.findAll(sort));
        return "module/callcenter/master/datascantime";
    }

}
