/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.itgarden.ERP.module.callcenter.Controller;

import com.itgarden.ERP.module.callcenter.Model.Gatewayroutingsetting;
import com.itgarden.ERP.module.callcenter.repository.GatewayroutingsettingRepository;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 *
 * @author libertyerp_local
 */
@Controller
@RequestMapping("/gatewayroutingsetting")
public class GatewayroutingsettingController {

    @Autowired
    GatewayroutingsettingRepository gatewayroutingsettingRepository;

    @RequestMapping("/index")
    public String index(Model model, Gatewayroutingsetting gatewayroutingsetting) {

        return "module/callcenter/transaction/gatewayroutingsetting";

    }

    @RequestMapping("/save")
    public String save(Model model, @Valid Gatewayroutingsetting gatewayroutingsetting, BindingResult bindingResult, RedirectAttributes redirectAttrs) {
        if (bindingResult.hasErrors()) {

            return "module/settings/company_setup/companysetup";
        }

        redirectAttrs.addFlashAttribute("success_messages ", "Sucessfully save.");

        return "redirect:/gatewayroutingsetting/list";
    }

    @RequestMapping("/edit/{id}")
    public String edit(Model model, @PathVariable Integer id, Gatewayroutingsetting gatewayroutingsetting) {
        model.addAttribute("gatewayroutingsetting", gatewayroutingsettingRepository.findOne(id));
        return "module/callcenter/transaction/gatewayroutingsetting";
    }

    @RequestMapping("/delete/{id}")
    public String delete(Model model, @PathVariable Integer id, Gatewayroutingsetting gatewayroutingsetting) {
        gatewayroutingsettingRepository.delete(id);
        return "redirect:/gatewayroutingsetting/list";
    }

    @RequestMapping("/list")
    public String list(Model model, Gatewayroutingsetting eGatewayroutingsetting) {

        model.addAttribute("list", gatewayroutingsettingRepository.findAll());

        return "module/callcenter/transaction/gatewayroutingsetting_list";

    }

}
