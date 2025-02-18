/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.itgarden.ERP.module.user.controller;

import com.itgarden.ERP.module.user.model.Privilege;
import com.itgarden.ERP.module.user.ripository.PrivilegeRepository;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import com.itgarden.ERP.module.user.ripository.ModulesRepository;

/**
 *
 * @author Md Belayet Hossin
 */
@Controller

@RequestMapping("/privilege")
//@PreAuthorize("hasAuthority('privilege')")
public class PrivilegeController {
    
     @Autowired
    ModulesRepository moduleRepository;

    @Autowired
    PrivilegeRepository privilegeRepository;

    @RequestMapping(value = {"", "/", "/index"})

    public String index(Model model, Privilege privilege) {

        model.addAttribute("list", privilegeRepository.findAll());
        model.addAttribute("modulelist", moduleRepository.findAll());

        return "module/users/privilege";

    }

    @RequestMapping("/edit/{id}")
    public String edit(Model model, @PathVariable Long id, Privilege privilege) {

        model.addAttribute("privilege", privilegeRepository.getOne(id));

        model.addAttribute("list", privilegeRepository.findAll());
        model.addAttribute("modulelist", moduleRepository.findAll());

        return "module/users/privilege";
    }

    @RequestMapping("/save")
    public String save(Model model, @Valid Privilege privilege, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {

            model.addAttribute("list", privilegeRepository.findAll());
            model.addAttribute("modulelist", moduleRepository.findAll());
            return "module/users/privilege";
        }

        privilegeRepository.save(privilege);

        return "redirect:/privilege/index";
    }

    @RequestMapping("/delete/{id}")

    public String delete(Model model, @PathVariable Long id, Privilege privilege) {

        privilegeRepository.delete(id);

        return "redirect:/privilege/index";
    }

}
