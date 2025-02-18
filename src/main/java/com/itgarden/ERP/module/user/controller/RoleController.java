/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.itgarden.ERP.module.user.controller;

import com.itgarden.ERP.module.user.model.Role;
import com.itgarden.ERP.module.user.ripository.PrivilegeRepository;
import com.itgarden.ERP.module.user.ripository.RoleRepository;
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
@RequestMapping("/role")
//@PreAuthorize("hasAuthority('role')")
public class RoleController {

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    PrivilegeRepository privilegeRepository;

    @Autowired
    ModulesRepository moduleRepository;

    @RequestMapping(value = {"", "/", "/index"})
    public String index(Model model, Role role) {
        model.addAttribute("list", roleRepository.findAll());

        model.addAttribute("privilegelist", privilegeRepository.findAll());

        model.addAttribute("modulelist", moduleRepository.findAll());

        return "module/users/role";
    }

    @RequestMapping("/edit/{id}")
    public String edit(Model model, @PathVariable Long id, Role role) {
        model.addAttribute("role", roleRepository.findOne(id));

        model.addAttribute("list", roleRepository.findAll());

        model.addAttribute("privilegelist", privilegeRepository.findAll());

        model.addAttribute("modulelist", moduleRepository.findAll());

        return "module/users/role";
    }

    @RequestMapping("/save")
    public String save(Model model, @Valid Role role, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {

            model.addAttribute("list", roleRepository.findAll());

            model.addAttribute("privilegelist", privilegeRepository.findAll());

            model.addAttribute("modulelist", moduleRepository.findAll());

           return "module/users/role";
        }

        roleRepository.save(role);
        return "redirect:/role/index";
    }

    @RequestMapping("/delete/{id}")
    public String delete(Model model, @PathVariable Long id, Role role) {
        roleRepository.delete(id);
        return "redirect:/role/index";
    }

}
