/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.itgarden.ERP.module.user.controller;

import com.itgarden.ERP.module.user.componant.UserValidator;
import com.itgarden.ERP.module.user.model.Role;
import com.itgarden.ERP.module.user.model.Status;
import com.itgarden.ERP.module.user.model.Users;
import com.itgarden.ERP.module.user.ripository.RoleRepository;
import com.itgarden.ERP.module.user.ripository.UsersRepository;
import com.itgarden.ERP.module.user.services.*;
import java.text.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 *
 * @author Md Belayet Hossin
 */
@Controller
@RequestMapping("/users")
//@PreAuthorize("hasAuthority('users')")
public class UsersController {

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    UsersRepository usersRepository;

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    UserValidator userValidator;

    @Autowired
    UsersService usersService;

    @RequestMapping(value = {"", "/", "/index"})
    public String index(Model model) {
        model.addAttribute("alluser", usersRepository.findAll());
        return "module/users/allusers";
    }

    @RequestMapping(value = {"/menu"})
    public String menu(Model model) {

        return "module/users/index";
    }

    @RequestMapping("/userbystatus")
    public String userByStatus(Model model, @RequestParam(value = "status", required = false) Status status) {

        model.addAttribute("status", Status.values());

        model.addAttribute("alluser", usersRepository.findByStatus(status));

        return "module/users/allusers_by_status";

    }

    @RequestMapping("/view/{uid}")
    public String view(Model model, @PathVariable Long uid) {
        model.addAttribute("users", usersRepository.findOne(uid));
        return "module/users/view";
    }

    @RequestMapping("/registrations")
    public String registrations(Model model, Users users) {
        model.addAttribute("roles", roleRepository.findAll());
        model.addAttribute("status", Status.values());
        return "module/users/registrations";
    }

    @RequestMapping("/edit/{id}")
    public String edit(Model model, @PathVariable Long id, Users users) {
        model.addAttribute("users", usersRepository.findOne(id));

        model.addAttribute("roles", roleRepository.findAll());
        model.addAttribute("status", Status.values());
        return "module/users/registrations";
    }

//    @RequestMapping("/save")
//    //@Transactional
//    public String save(Model model, @RequestParam(value = "password2", required = false) String password2, @Valid Users users, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
//
//        if (bindingResult.hasErrors()) {
//            model.addAttribute("batch", batchRepository.findAll());
//            model.addAttribute("role", roleRepository.findAll());
//            model.addAttribute("status", Status.values());
//            return "user/registrations";
//        }
//
//        // users.setPassword(bCryptPasswordEncoder.encode(users.getPassword()));
//        try {
//
//            if (users.getPassword().isEmpty() && password2 != null && users.getId() != null) {
//
//                users.setPassword(password2);
//            } else {
//
//                users.setPassword(bCryptPasswordEncoder.encode(users.getPassword()));
//            }
//
//            usersRepository.save(users);
//            return "redirect:/users/index";
//
//        } catch (Exception e) {
//
//            model.addAttribute("role", roleRepository.findAll());
//            model.addAttribute("status", Status.values());
//            redirectAttributes.addFlashAttribute("message", e);
//            model.addAttribute("message", e);
//            return "user/registrations";
//        }
//    }
    @RequestMapping("/save")
    //@Transactional
    public String save(Model model, @RequestParam(value = "password2", required = false) String password2, @Valid Users users, BindingResult bindingResult, RedirectAttributes redirectAttributes) {

        if (bindingResult.hasErrors()) {

            model.addAttribute("roles", roleRepository.findAll());
            model.addAttribute("status", Status.values());
            return "/module/users/registrations";
        }

        // users.setPassword(bCryptPasswordEncoder.encode(users.getPassword()));
        try {

            if (users.getPassword().isEmpty() && password2 != null && users.getId() != null) {

                users.setPassword(password2);
            } else {

                users.setPassword(bCryptPasswordEncoder.encode(users.getPassword()));
            }

            usersRepository.save(users);
            return "redirect:/users/index";

        } catch (Exception e) {

            model.addAttribute("roles", roleRepository.findAll());
            model.addAttribute("status", Status.values());
            redirectAttributes.addFlashAttribute("message", e);
            model.addAttribute("message", e);
            return "module/users/registrations";
        }
    }

    @RequestMapping("/delete/{id}")
    public String delete(Model model, @PathVariable Long id, Users users) {
        usersRepository.delete(id);
        return "redirect:/users/index";
    }

    @RequestMapping("/login")
    public String login(Model model) {
        model.addAttribute("attribute", "value");

        model.addAttribute("logout", " You are successfully logout");
        return "module/users/login";
    }

    @RequestMapping("/logout")
    public String logout(Model model, HttpServletRequest request, HttpServletResponse response) throws ParseException {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null) {
            new SecurityContextLogoutHandler().logout(request, response, authentication);
        }
      //  usersService.userloginDateTime();
        return "redirect:/users/login";
    }

    @RequestMapping("/detailsinfo/{id}")
    public String details(Model model, @PathVariable Long id) {
        model.addAttribute("employee", usersRepository.findOne(id));
        return "module/users/details/details";
    }

    @RequestMapping("/uregistrations")
    public String uregistrations(Model model, Users users) {

        model.addAttribute("role", roleRepository.findAll());
        return "module/users/uregistrations";
    }

    @RequestMapping("/usave")
    public String usave(Model model, @Valid Users users, BindingResult bindingResult, RedirectAttributes redirectAttributes) {

        if (bindingResult.hasErrors()) {

            model.addAttribute("role", roleRepository.findAll());
            return "module/users/uregistrations";
        }
        users.setStatus(Status.Pending);
        users.setPassword(bCryptPasswordEncoder.encode(users.getPassword()));
        usersRepository.save(users);
        redirectAttributes.addAttribute("success", " Congratulations you have successfully registered. please contact with system adminstrator.");
        return "redirect:users/uregistrations";
    }

    @RequestMapping("/front-registration-save")
    public String frontUserSave(Model model, @Valid Users users, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        userValidator.validate(users, bindingResult);

        if (bindingResult.hasErrors()) {

            Role role = roleRepository.findBySlug("administrator");

            model.addAttribute("role", role);

            return "frontview/front-registration";
        }
        users.setStatus(Status.Active);
        users.setPassword(bCryptPasswordEncoder.encode(users.getPassword()));
        usersRepository.save(users);
        redirectAttributes.addFlashAttribute("success", " Congratulations you have successfully registered.");
        return "redirect:/front-view/front-registration";
    }

}
