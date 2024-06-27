package com.itgarden.ERP.module.callcenter.master.controller;

import com.itgarden.ERP.module.callcenter.Model.Gatewayrouting;
import com.itgarden.ERP.module.callcenter.master.model.ConfigurationVoice;
import com.itgarden.ERP.module.callcenter.master.model.PrefixStatus;
import com.itgarden.ERP.module.callcenter.master.model.PrefixTable;
import com.itgarden.ERP.module.callcenter.master.ripository.ConfigurationVoiceRepository;
import com.itgarden.ERP.module.callcenter.master.ripository.PrefixTableRepository;
import com.itgarden.ERP.module.callcenter.repository.GatewayroutingRepository;
import com.itgarden.ERP.module.callcenter.services.GatewayroutingService;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
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
@RequestMapping("/configuration")
public class ConfigurationController {

    @Autowired
    ConfigurationVoiceRepository configurationRepository;

    @Autowired
    GatewayroutingService gatewayroutingService;

    @Autowired
    PrefixTableRepository prefixTableRepository;

    //@Autowired
    // GatewayroutingService gatewayroutingService;
    @Autowired
    GatewayroutingRepository gatewayroutingRepository;

    @RequestMapping("/index")
    public String index(Model model, ConfigurationVoice configurationVoice) {
        model.addAttribute("nameList", gatewayroutingService.getwayRoutingNameList2());
        return "module/callcenter/master/configuration";
    }

    @RequestMapping("/save")
    public String save(Model model, @Valid ConfigurationVoice configuration, BindingResult bindingResult, RedirectAttributes redirectAttrs) {

        if (bindingResult.hasErrors()) {
            model.addAttribute("nameList", gatewayroutingRepository.findAll());
            return "module/callcenter/master/configuration";
        }
        int id = configuration.getGatewayroutingId();

        Gatewayrouting gatewayrouting = gatewayroutingRepository.findOne(id);

        configuration.setName(gatewayrouting.getName());
//        configuration.setPrefixStartNumber(100);
//        configuration.setPrefixqty(899);

        configurationRepository.save(configuration);

        ConfigurationVoice lastid = configurationRepository.findTopByOrderByIdDesc();

//        PrefixTable prefixTable = new PrefixTable();
//        prefixTable.setConfigId(lastid);
//            prefixTable.setPrefix(1);
//            prefixTable.setCountDown(0);
//            prefixTable.setStatus(PrefixStatus.Enable);
//            
//            prefixTableRepository.save(prefixTable);
        List<PrefixTable> prefixTableList = new ArrayList<>();

        for (int i = configuration.getPrefixStartNumber(); i <= configuration.getPrefixStartNumber() + configuration.getPrefixqty() - 1; i++) {

            //System.out.println("gfdfgggggggggggggggggggd" + i);
            PrefixTable prefixTable = new PrefixTable();

            prefixTable.setConfigId(lastid);
            prefixTable.setPrefix(i);
            prefixTable.setAssignTime(lastid.getAssignTime());
            //prefixTable.setCountDown(0);
            //  long unixTimestampMillis = System.currentTimeMillis();
            //Instant.now().toEpochMilli();
            long unixTimestampMillis = Instant.now().toEpochMilli();

            prefixTable.setLastUpdateTime(unixTimestampMillis);
            prefixTable.setStatus(PrefixStatus.Enable);
            prefixTableList.add(prefixTable);
//            prefixTableRepository.save(prefixTable);
        }
        prefixTableRepository.save(prefixTableList);

        redirectAttrs.addFlashAttribute("success_messages ", "Sucessfully save.");
        return "redirect:/configuration/list";
    }

    @RequestMapping("/edit/{id}")
    public String edit(Model model, @PathVariable Long id, ConfigurationVoice configurationVoice) {
        model.addAttribute("configurationVoice", configurationRepository.findOne(id));
        model.addAttribute("nameList", gatewayroutingRepository.findAll());
        return "module/callcenter/master/configuration";
    }

    @RequestMapping("/delete/{id}")
    public String delete(Model model, @PathVariable Long id, ConfigurationVoice configuration) {
        configurationRepository.delete(id);
        return "redirect:/configuration/list";
    }

    @RequestMapping("/add_more_prefix/{id}")
    public String addmore(Model model, @PathVariable Long id, ConfigurationVoice configurationVoice) {

        configurationVoice.setId(id);
        List<PrefixTable> prefixlist = prefixTableRepository.findByConfigIdId(id);

        ConfigurationVoice configurationVoices = configurationRepository.getOne(id);

        model.addAttribute("getwayNmae", configurationVoices.getName());
        model.addAttribute("getwayId", configurationVoices.getGatewayroutingId());

        if (!prefixlist.isEmpty()) {

            int maxnumber = prefixlist.stream()
                    .map(PrefixTable::getPrefix)
                    .max(Integer::compareTo).get().intValue();

            model.addAttribute("startNumber", maxnumber + 1);
            
            model.addAttribute("totalPrefix", prefixlist.size());

            int maximumsize = 899 - prefixlist.size();

            model.addAttribute("maximumsize", maximumsize);

            model.addAttribute("nameList", gatewayroutingService.getwayRoutingNameList2());
        } else {

            model.addAttribute("startNumber", 100);

            model.addAttribute("maximumsize", 899);
            
            model.addAttribute("totalPrefix", 0);

            model.addAttribute("nameList", gatewayroutingService.getwayRoutingNameList2());

        }

        return "module/callcenter/master/add_more_prefix";
    }

    @RequestMapping("/saveaddmore")
    public String saveAddmore(Model model, @Valid ConfigurationVoice configuration, BindingResult bindingResult, RedirectAttributes redirectAttrs) {

        if (bindingResult.hasErrors()) {

            return "module/callcenter/master/configuration";
        }

//        PrefixTable prefixTable = new PrefixTable();
//        prefixTable.setConfigId(lastid);
//            prefixTable.setPrefix(1);
//            prefixTable.setCountDown(0);
//            prefixTable.setStatus(PrefixStatus.Enable);
//            
//            prefixTableRepository.save(prefixTable);
        List<PrefixTable> prefixTableList = new ArrayList<>();

        for (int i = configuration.getPrefixStartNumber(); i <= configuration.getPrefixStartNumber() + configuration.getPrefixqty() - 1; i++) {

            //System.out.println("gfdfgggggggggggggggggggd" + i);
            PrefixTable prefixTable = new PrefixTable();

            prefixTable.setConfigId(configuration);
            prefixTable.setPrefix(i);
            prefixTable.setAssignTime(configuration.getAssignTime());
            //prefixTable.setCountDown(0);
            //  long unixTimestampMillis = System.currentTimeMillis();
            //Instant.now().toEpochMilli();
            long unixTimestampMillis = Instant.now().toEpochMilli();

            prefixTable.setLastUpdateTime(unixTimestampMillis);
            prefixTable.setStatus(PrefixStatus.Enable);
            prefixTableList.add(prefixTable);
//            prefixTableRepository.save(prefixTable);
        }
        prefixTableRepository.save(prefixTableList);

        redirectAttrs.addFlashAttribute("success_messages ", "Sucessfully save.");
        return "redirect:/configuration/list";
    }

    @RequestMapping("/list")
    public String list(Model model) {
        model.addAttribute("list", configurationRepository.findAll());
        return "module/callcenter/master/configuration_list";
    }

}
