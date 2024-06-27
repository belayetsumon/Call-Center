/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.itgarden.ERP.module.callcenter.Controller;

import com.itgarden.ERP.module.callcenter.Model.Gatewaymapping;
import com.itgarden.ERP.module.callcenter.repository.GatewaymappingRepository;
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
@RequestMapping("/gatewaymapping")
public class GatewaymappingController {
    
    @Autowired
    GatewaymappingRepository gatewaymappingRepository;

    @RequestMapping("/index")
    public String index(Model model, Gatewaymapping gatewaymapping) {

        return "module/callcenter/transaction/gatewaymapping";

    }

    @RequestMapping("/save")
    public String save(Model model, @Valid Gatewaymapping gatewaymapping, BindingResult bindingResult, RedirectAttributes redirectAttrs) {
        if (bindingResult.hasErrors()) {

            return "module/settings/company_setup/companysetup";
        }

        redirectAttrs.addFlashAttribute("success_messages ", "Sucessfully save.");

        return "redirect:/companysetup/index";
    }

    @RequestMapping("/list")
    public String list(Model model, @Valid Gatewaymapping gatewaymapping, BindingResult bindingResult, RedirectAttributes redirectAttrs) {
      
          model.addAttribute("list", gatewaymappingRepository.findAll());
        
        return "module/callcenter/transaction/gatewaymapping_list";
    }

}
