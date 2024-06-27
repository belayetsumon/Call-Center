/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/springframework/Controller.java to edit this template
 */
package com.itgarden.ERP.module.callcenter.Controller;

import com.itgarden.ERP.module.callcenter.services.CdrService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author libertyerp_local
 */
@Controller
@RequestMapping("/cdr")
public class CdrController {

    @Autowired
    CdrService cdrService;

    @RequestMapping("/list")
    public String list(Model model) {
        model.addAttribute("list", cdrService.list());
        return "module/callcenter/transaction/cdrlist";
    }

}
