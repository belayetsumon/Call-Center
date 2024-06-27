/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.itgarden.ERP.module.callcenter.Controller;

import com.itgarden.ERP.module.callcenter.Model.Gatewaymappingsetting;
import com.itgarden.ERP.module.callcenter.repository.GatewaymappingsettingRepository;
import com.itgarden.ERP.module.callcenter.repository.GatewayroutingsettingRepository;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 *
 * @author libertyerp_local
 */
@Controller
@RequestMapping("/gatewaymappingsetting")
public class GatewaymappingsettingController {
    
    @Autowired
    GatewaymappingsettingRepository gatewaymappingsettingRepository;
    
    
    @RequestMapping("/index")
    public String index(Model model, Gatewaymappingsetting gatewaymappingsetting) {

        return "module/callcenter/transaction/gatewaymappingsetting";

    }

    @RequestMapping("/save")
    public String save(Model model, @Valid Gatewaymappingsetting gatewaymappingsetting, BindingResult bindingResult, RedirectAttributes redirectAttrs) {
        if (bindingResult.hasErrors()) {

            return "module/settings/company_setup/companysetup";
        }

        redirectAttrs.addFlashAttribute("success_messages ", "Sucessfully save.");

        return "redirect:/companysetup/index";
    }
    
    
    
      @RequestMapping("/list")
    public String list(Model model, Gatewaymappingsetting gatewaymappingsetting) {

          model.addAttribute("list", gatewaymappingsettingRepository.findAll());
        
        
        return "module/callcenter/transaction/gatewaymappingsetting_list";

    } 
}
