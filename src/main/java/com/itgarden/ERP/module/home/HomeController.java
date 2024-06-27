/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.itgarden.ERP.module.home;

import com.itgarden.ERP.module.settings.company_setup.services.CompanySetupService;
import com.itgarden.ERP.module.user.model.*;
import com.itgarden.ERP.module.user.ripository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author User
 */
@Controller
public class HomeController {

   // @Autowired
   // CompanySetupService companySetupService;

    
       @Autowired
    UsersRepository usersRepository;

    @RequestMapping("/")
    public String index(Model model,Authentication authentication ) {
        
        model.addAttribute("username", authentication.getName());
        
         Users users = usersRepository.findByEmail(authentication.getName());
         
         if(users!=null){
         
          model.addAttribute("users", users);
         }
         
        

       // model.addAttribute("c_info", companySetupService.companyInfo());

       // model.addAttribute("u_info", loggedUserService.loggedUserInfo().getName());

        

        return "module/home/welcome";

    }
}
