package com.itgarden.ERP.module.callcenter.master.controller;

import com.itgarden.ERP.module.callcenter.master.model.Endreason;
import com.itgarden.ERP.module.callcenter.master.model.EndreasonType;
import com.itgarden.ERP.module.callcenter.master.model.PrefixStatus;
import com.itgarden.ERP.module.callcenter.master.model.PrefixTable;
import com.itgarden.ERP.module.callcenter.master.ripository.EndreasonRepository;
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
@RequestMapping("/endreason")
public class EndreasonController {

    @Autowired
    EndreasonRepository endreasonRepository;

    @RequestMapping("/index")
    public String index(Model model, Endreason endreason) {

        model.addAttribute("list", endreasonRepository.findAll());

        model.addAttribute("colorList", EndreasonType.values());

        return "module/callcenter/master/endreason";
    }

    @RequestMapping("/save")
    public String save(Model model, @Valid Endreason endreason, BindingResult bindingResult, RedirectAttributes redirectAttrs) {
        if (bindingResult.hasErrors()) {

            return "module/callcenter/master/endreason";
        }
        endreasonRepository.save(endreason);

        return "redirect:/endreason/list";
    }

    @RequestMapping("/list")
    public String list(Model model) {

        model.addAttribute("list", endreasonRepository.findAll());

        return "module/callcenter/master/endreason_list";
    }

    @RequestMapping("/edit/{id}")
    public String edit(Model model, @PathVariable Long id, Endreason endreason) {

        model.addAttribute("endreason", endreasonRepository.getOne(id));
        model.addAttribute("colorList", EndreasonType.values());
        return "module/callcenter/master/endreason";
    }

    @RequestMapping("/delete/{id}")
    public String delete(Model model, @PathVariable Long id, Endreason endreason) {

        endreasonRepository.delete(id);

        return "module/callcenter/master/endreason";
    }

}
