/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/springframework/Controller.java to edit this template
 */
package com.itgarden.ERP.module.callcenter.master.controller;

import com.itgarden.ERP.module.callcenter.master.model.AssignedNumber;
import com.itgarden.ERP.module.callcenter.master.ripository.AssignedNumberRepository;
import com.itgarden.ERP.module.callcenter.master.services.AssignedNumberService;
import com.itgarden.ERP.module.callcenter.repository.GatewayroutingRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author libertyerp_local
 */
@Controller
@RequestMapping("/assignednumber")
public class AssignedNumberController {

    @Autowired
    AssignedNumberRepository assignedNumberRepository;

    @Autowired
    AssignedNumberService assignedNumberService;

    @Autowired
    GatewayroutingRepository gatewayroutingRepository;

    @RequestMapping("/list")
    public String index(Model model,
            @RequestParam(name = "gatewayroutingId", required = false) Integer gatewayroutingId,
            @RequestParam(name = "incommingNumber", required = false) String incommingNumber
    ) {

        model.addAttribute("nameList", gatewayroutingRepository.findAll());

//        Integer gatewayroutingId=433;
//        String incommingNumber = null;
        model.addAttribute("list", assignedNumberService.numberlist(gatewayroutingId, incommingNumber));

        return "module/callcenter/master/assignednumberlist";
    }

    @RequestMapping("/edit/{id}")
    public String edit(Model model, @PathVariable Long id, AssignedNumber assignedNumber) {
        model.addAttribute("assignedNumber", assignedNumberRepository.findOne(id));

        return "module/callcenter/master/assignednumber";
    }

    @RequestMapping("/delete/{id}")
    public String delete(Model model, @PathVariable Long id, AssignedNumber assignedNumber) {
        assignedNumberRepository.delete(id);

        assignedNumberService.gatewayRoutingGatewayRoutingPrefixDataConcat();
        assignedNumberService.gatewayRoutingSettingRewriteRulesDataConcat();

        return "redirect:/assignednumber/list";
    }

    @RequestMapping("/deleteall")
    public String deleteall(
            @RequestParam("id") List<Long> ids, Model model, AssignedNumber assignedNumber
    ) {

        for (Long id : ids) {
            assignedNumberRepository.delete(id);
        }

        assignedNumberService.gatewayRoutingGatewayRoutingPrefixDataConcat();
        assignedNumberService.gatewayRoutingSettingRewriteRulesDataConcat();

        return "redirect:/assignednumber/list";
    }

    @RequestMapping("/deletenonerepeatnumber")
    public String deletebyday() {

        return "module/callcenter/master/deletenonerepeat";
    }

    @RequestMapping("/deletebyupdateday")
    public String deletebyupdateday(
            @RequestParam(name = "days", required = false) Integer days
    ) {

        assignedNumberService.deleteEntitiesUpdatedBeforeDays(days);

        assignedNumberService.gatewayRoutingGatewayRoutingPrefixDataConcat();
        assignedNumberService.gatewayRoutingSettingRewriteRulesDataConcat();

        return "redirect:/assignednumber/deletenonerepeatnumber";
    }

}
