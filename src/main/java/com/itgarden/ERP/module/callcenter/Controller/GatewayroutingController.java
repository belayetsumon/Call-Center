/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/springframework/Controller.java to edit this template
 */
package com.itgarden.ERP.module.callcenter.Controller;

import com.itgarden.ERP.module.callcenter.Model.Gatewayrouting;
import com.itgarden.ERP.module.callcenter.repository.GatewayroutingRepository;
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
@RequestMapping("/gatewayrouting")
public class GatewayroutingController {

    @Autowired
    GatewayroutingRepository gatewayroutingRepository;

    @RequestMapping("/index")
    public String index(Model model, Gatewayrouting gatewayrouting) {

        return "module/callcenter/transaction/gatewayrouting";

    }

    @RequestMapping("/save")
    public String save(Model model, @Valid Gatewayrouting gatewayrouting, BindingResult bindingResult, RedirectAttributes redirectAttrs) {

        if (bindingResult.hasErrors()) {

            return "module/settings/company_setup/companysetup";
        }
        gatewayroutingRepository.save(gatewayrouting);
        redirectAttrs.addFlashAttribute("success_messages ", "Sucessfully save.");
        return "redirect:/gatewayrouting/list";
    }

    @RequestMapping("/edit/{id}")
    public String edit(Model model, @PathVariable Integer id, Gatewayrouting gatewayrouting) {
        model.addAttribute("gatewayrouting", gatewayroutingRepository.findOne(id));
        return "module/callcenter/transaction/gatewayrouting";
    }

    @RequestMapping("/delete/{id}")
    public String delete(Model model, @PathVariable Integer id, Gatewayrouting gatewayrouting) {
        gatewayroutingRepository.delete(id);
        return "redirect:/gatewayrouting/list";
    }

    @RequestMapping("/list")
    public String list(Model model, @Valid Gatewayrouting gatewayrouting, BindingResult bindingResult, RedirectAttributes redirectAttrs) {

        model.addAttribute("list", gatewayroutingRepository.findAll());

        return "module/callcenter/transaction/gatewayrouting_list";
    }

}
