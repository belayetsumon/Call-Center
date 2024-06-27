/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.itgarden.ERP.module.settings.controller.company_setup;

import com.itgarden.ERP.module.settings.model.company_setup.FiscalYears;
import com.itgarden.ERP.module.settings.repository.company_setup.FiscalYearsRepository;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 *
 * @author User
 */
@Controller
@RequestMapping("/fiscalyears")
public class FiscalYearsController {

    @Autowired
    FiscalYearsRepository fiscalYearsRepository;

    @RequestMapping("/index")
    public String index(Model model, FiscalYears fiscalYears) {
         model.addAttribute("list", fiscalYearsRepository.findAll());
        return "module/settings/company_setup/fiscalyears";

    }

    @RequestMapping("/save")
    public String save(Model model, @Valid FiscalYears fiscalYears, BindingResult bindingResult, RedirectAttributes redirectAttrs) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("list", fiscalYearsRepository.findAll());
            return "module/settings/company_setup/fiscalyears";
        }       
        fiscalYearsRepository.save(fiscalYears);
        redirectAttrs.addFlashAttribute("success_messages ", "Sucessfully save.");
        return "redirect:/fiscalyears/index";
    }

}
