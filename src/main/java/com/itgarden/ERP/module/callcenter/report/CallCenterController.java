
package com.itgarden.ERP.module.callcenter.report;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author Admin
 */
@Controller
@RequestMapping("/callcenter")
public class CallCenterController {

    @RequestMapping("/index")
    public String index(Model model) {
        model.addAttribute("attribute", "value");
        return "module/callcenter/report/index";
    }

}
