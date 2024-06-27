package com.itgarden.ERP.module.callcenter.master.controller;

import com.itgarden.ERP.module.callcenter.master.model.Settings;
import com.itgarden.ERP.module.callcenter.master.ripository.SettingsRepository;
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
@RequestMapping("/callcentersettings")
public class SettingsController {

    @Autowired
    SettingsRepository settingsRepository;

    @RequestMapping("/index")
    public String index(Model model, Settings settings) {

        model.addAttribute("list", settingsRepository.findAll());

        return "module/callcenter/master/settings";
    }

    @RequestMapping("/save")
    public String save(Model model, @Valid Settings settings, BindingResult bindingResult, RedirectAttributes redirectAttrs) {
        if (bindingResult.hasErrors()) {
            return "module/callcenter/master/settings";
        }
        settingsRepository.save(settings);

        return "redirect:/callcentersettings/list";
    }

    @RequestMapping("/list")
    public String list(Model model) {

        Settings settings = settingsRepository.findOne(2L);

        if (settings != null) {

            model.addAttribute("list", settings);

        }

        return "module/callcenter/master/settings_list";
    }

    @RequestMapping("/edit/{id}")
    public String edit(Model model, @PathVariable Long id, Settings settings) {

        model.addAttribute("settings", settingsRepository.getOne(id));

        return "module/callcenter/master/settings";
    }

    @RequestMapping("/delete/{id}")
    public String delete(Model model, @PathVariable Long id, Settings settings) {

        settingsRepository.delete(id);

        return "redirect:/callcentersettings/list";
    }
}
