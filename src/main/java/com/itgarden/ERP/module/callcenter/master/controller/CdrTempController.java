package com.itgarden.ERP.module.callcenter.master.controller;

import com.itgarden.ERP.module.callcenter.master.model.CdrTemp;
import com.itgarden.ERP.module.callcenter.master.ripository.CdrTempRepository;
import com.itgarden.ERP.module.callcenter.master.services.CdrTempService;
import java.math.BigInteger;
import java.time.Duration;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;
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
@RequestMapping("/cdrtemp")
public class CdrTempController {

    @Autowired
    CdrTempRepository cdrTempRepository;

    @Autowired
    CdrTempService cdrTempService;

    @RequestMapping("/index")
    public String index(Model model, CdrTemp cdrTemp) {

        model.addAttribute("list", cdrTempRepository.findAll());

        return "module/callcenter/master/cdrtemp";
    }

    @RequestMapping("/save")
    public String save(Model model, @Valid CdrTemp cdrTemp, BindingResult bindingResult, RedirectAttributes redirectAttrs) {
        if (bindingResult.hasErrors()) {
            return "module/callcenter/master/cdrtemp";
        }
        cdrTempRepository.save(cdrTemp);
        return "redirect:/cdrtemp/list";
    }

    @RequestMapping("/list")
    public String list(Model model) {

        List<CdrTemp> cdrTempList = cdrTempRepository.findAll();

        if (cdrTempList.size() > 0) {

            model.addAttribute("list", cdrTempList);

            // maximum date time 
            Optional<BigInteger> maxBigInteger = cdrTempList.stream()
                    .map(CdrTemp::getStarttime)
                    .max(BigInteger::compareTo);

            Long maximumstartunixtime = maxBigInteger.get().max(BigInteger.ONE).longValue();

            // Convert Unix timestamp to LocalDateTime
            LocalDateTime dateTime = Instant.ofEpochMilli(maximumstartunixtime)
                    .atZone(ZoneId.systemDefault())
                    .toLocalDateTime();

            // Format LocalDateTime to a human-readable string
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

            String formattedDateTime = dateTime.format(formatter);

            model.addAttribute("maximumdatetime", formattedDateTime);

            /// Minimum date time 
            Optional<BigInteger> minBigInteger = cdrTempList.stream()
                    .map(CdrTemp::getStarttime)
                    .min(BigInteger::compareTo);

            Long minimumtartunixtime = minBigInteger.get().max(BigInteger.ONE).longValue();

            // Convert Unix timestamp to LocalDateTime
            LocalDateTime minidateTime = Instant.ofEpochMilli(minimumtartunixtime)
                    .atZone(ZoneId.systemDefault())
                    .toLocalDateTime();

            // Format LocalDateTime to a human-readable string
            DateTimeFormatter miniformatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

            String miniformattedDateTime = miniformatter.format(minidateTime);

            model.addAttribute("minimumdatetime", miniformattedDateTime);

            // Parse the two LocalDateTime instances from strings
            DateTimeFormatter formatters = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            LocalDateTime dateTime1 = LocalDateTime.parse(formattedDateTime, formatters);
            LocalDateTime dateTime2 = LocalDateTime.parse(miniformattedDateTime, formatters);

            // Calculate the duration between the two LocalDateTime instances
            Duration duration = Duration.between(dateTime1, dateTime2);

            // Extract the components of the duration
            long days = duration.toDays();
            long hours = duration.toHours() % 24;
            long minutes = duration.toMinutes() % 60;
            long seconds = duration.getSeconds() % 60;

            // Print the duration components
            model.addAttribute("timedurations", "Duration: " + days + " days, " + hours + " hours, " + minutes + " minutes, " + seconds + " seconds");
        } else {
            model.addAttribute("list", cdrTempList);
            model.addAttribute("timedurations", "Duration: " + 0 + " days, " + 0 + " hours, " + 0 + " minutes, " + 0 + " seconds");

        }

        return "module/callcenter/master/cdrtemp_list";
    }

    @RequestMapping("/last30MinutesDatalist")
    public String last30MinutesDatalist(Model model) {

        List<CdrTemp> cdrTempList = cdrTempService.last30minutesDataList();

        model.addAttribute("list", cdrTempList);

        return "module/callcenter/master/cdrtemp_list_last_30_minutes";
    }

    @RequestMapping("/listcount")
    public String listcount(Model model) {

        model.addAttribute("list", cdrTempService.repetValueCountList());

        return "module/callcenter/master/cdrtemp_list_count";
    }

    @RequestMapping("/listcount_last_30_minutes")
    public String listcount_last_30_minutes(Model model) {

        model.addAttribute("list", cdrTempService.repetValueCountListLast30Minutes());

        return "module/callcenter/master/cdrtemp_list_count_last_30_minutes";
    }

    @RequestMapping("/edit/{id}")
    public String edit(Model model, @PathVariable Integer id, CdrTemp cdrTemp) {

        model.addAttribute("settings", cdrTempRepository.getOne(id));

        return "module/callcenter/master/cdrtemp";
    }

    @RequestMapping("/delete/{id}")
    public String delete(Model model, @PathVariable Integer id, CdrTemp cdrTemp) {

        cdrTempRepository.delete(id);

        return "redirect:/cdrtemp/list";
    }

}
