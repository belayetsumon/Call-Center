package com.itgarden.ERP.module.callcenter.master.controller;

import com.itgarden.ERP.module.callcenter.master.model.PrefixStatus;
import com.itgarden.ERP.module.callcenter.master.model.PrefixTable;
import com.itgarden.ERP.module.callcenter.master.ripository.PrefixTableRepository;
import com.itgarden.ERP.module.callcenter.master.services.PrefixTableService;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 *
 * @author libertyerp_local
 */
@Controller
@RequestMapping("/prefixtable")
public class PrefixTableController {

    @Autowired
    PrefixTableRepository prefixTableRepository;

    @Autowired
    PrefixTableService prefixTableService;

    @RequestMapping("/index")
    public String index(Model model, PrefixTable prefixTable) {
        model.addAttribute("status", PrefixStatus.values());

        return "module/callcenter/master/prefixtable";
    }

    @RequestMapping("/save")
    public String save(Model model, @Valid PrefixTable prefixTable, BindingResult bindingResult, RedirectAttributes redirectAttrs) {

        if (bindingResult.hasErrors()) {
            model.addAttribute("status", PrefixStatus.values());
            return "module/callcenter/master/prefixtable";
        }
        //prefixTableService.update(prefixTable);
        prefixTableRepository.save(prefixTable);
        redirectAttrs.addFlashAttribute("success_messages ", "Sucessfully save.");
        return "redirect:/prefixtable/list";
    }

    @RequestMapping("/edit/{id}")
    public String edit(Model model, @PathVariable Long id, PrefixTable prefixTable) {
        model.addAttribute("prefixTable", prefixTableRepository.findOne(id));
        model.addAttribute("status", PrefixStatus.values());
        return "module/callcenter/master/prefixtable";
    }

    @RequestMapping("/delete/{id}")
    public String delete(Model model, @PathVariable Long id, PrefixTable prefixTable) {
        prefixTableRepository.delete(id);
        return "redirect:/prefixtable/list";
    }

    @RequestMapping("/deleteall")
    public String deleteall(
            @RequestParam("id") List<Long> ids, Model model
    ) {

        for (Long id : ids) {
            prefixTableRepository.delete(id);

        }
        return "redirect:/prefixtable/list";
    }

    @RequestMapping("/list")
    public String list(Model model) {
        // model.addAttribute("list", prefixTableRepository.findAll());

        model.addAttribute("list", prefixTableService.prefixTableValueList());

        return "module/callcenter/master/prefixtable_list";
    }

}
