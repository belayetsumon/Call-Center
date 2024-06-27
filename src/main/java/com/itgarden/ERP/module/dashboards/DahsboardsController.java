/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.itgarden.ERP.module.dashboards;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author User
 */
@Controller
@RequestMapping("/dashboards")
public class DahsboardsController {

    @Autowired
    DashboardsService dashboardsService;

  



    @RequestMapping("/index")
    public String index(Model model) {

//        model.addAttribute("totalCoustomerDue", customarTransactionsService.customerDueList(null));
//        model.addAttribute("totalSupplierDue", supplierTransactionsService.supplierduelist(null));
//        model.addAttribute("itemStatus", dashboardsService.inventoryStatus());
//        List<BankTransction> btList = bankTransctionService.statusByAccount();
//        model.addAttribute("list", btList);
//        model.addAttribute("todayStatistics", dashboardsService.todayStatistics());

        return "module/dashboards/deshboards";
    }

    @RequestMapping("/access-denied")
    public String access_denied(Model model) {

        model.addAttribute("attribute", "value");

        return "module/dashboards/access_denied";
    }

}
