/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.itgarden.ERP.module.user.controller;

import com.itgarden.ERP.module.user.model.*;
import com.itgarden.ERP.module.user.ripository.*;
import javax.validation.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;
import org.springframework.ui.*;
import org.springframework.validation.*;
import org.springframework.web.bind.annotation.*;

/**
 *
 * @author User
 */
@Controller
@RequestMapping("/module")
//@PreAuthorize("hasAuthority('module')")
public class ModuleController {

    @Autowired
    PrivilegeRepository privilegeRepository;

    @Autowired
    ModulesRepository modulesRepository;

    @RequestMapping(value = {"", "/", "/index"})

    public String index(Model model, Modules modules) {

        model.addAttribute("list", modulesRepository.findAll());

        return "module/users/module";

    }

    @RequestMapping("/edit/{id}")
    public String edit(Model model, @PathVariable Long id, Modules modules) {

        model.addAttribute("module", modulesRepository.findOne(id));

        model.addAttribute("list", modulesRepository.findAll());

        return "module/users/module";
    }

    @RequestMapping("/save")
    public String save(Model model, @Valid Modules modules, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {

            model.addAttribute("list", modulesRepository.findAll());
            return "module/users/module";
        }

        modulesRepository.save(modules);

        return "redirect:/module/index";
    }

    @RequestMapping("/delete/{id}")

    public String delete(Model model, @PathVariable Long id, Modules modules) {

        modulesRepository.delete(id);

        return "redirect:/module/index";
    }

}
