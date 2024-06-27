package com.itgarden.ERP.module.callcenter.master.controller;

import com.itgarden.ERP.module.callcenter.master.model.CallerRtpIp;
import com.itgarden.ERP.module.callcenter.master.ripository.CallerRtpIpRepository;
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
@RequestMapping("/callerrtpip")
public class CallerRtpIpController {

    @Autowired
    CallerRtpIpRepository callerRtpIpRepository;

    @RequestMapping("/index")
    public String index(Model model, CallerRtpIp callerRtpIp) {

        model.addAttribute("list", callerRtpIpRepository.findAll());

        return "module/callcenter/master/callerrtpip";
    }

    @RequestMapping("/save")
    public String save(Model model, @Valid CallerRtpIp callerRtpIp, BindingResult bindingResult, RedirectAttributes redirectAttrs) {
        if (bindingResult.hasErrors()) {
            return "module/callcenter/master/callerrtpip";
        }
        callerRtpIpRepository.save(callerRtpIp);

        return "redirect:/callerrtpip/list";
    }

    @RequestMapping("/list")
    public String list(Model model) {

        model.addAttribute("list", callerRtpIpRepository.findAll());

        return "module/callcenter/master/callerrtpip_list";
    }

    @RequestMapping("/edit/{id}")
    public String edit(Model model, @PathVariable Long id, CallerRtpIp callerRtpIp) {

        model.addAttribute("callerRtpIp", callerRtpIpRepository.getOne(id));

        return "module/callcenter/master/callerrtpipedit";
    }

    @RequestMapping("/editsave")
    public String editsave(Model model, @Valid CallerRtpIp callerRtpIp, BindingResult bindingResult, RedirectAttributes redirectAttrs) {
        if (bindingResult.hasErrors()) {
            return "module/callcenter/master/callerrtpip";
        }
        callerRtpIpRepository.save(callerRtpIp);

        return "redirect:/callerrtpip/list";
    }

    @RequestMapping("/delete/{id}")
    public String delete(Model model, @PathVariable Long id, CallerRtpIp callerRtpIp) {

        callerRtpIpRepository.delete(id);

        return "redirect:/callerrtpip/list";
    }

}
