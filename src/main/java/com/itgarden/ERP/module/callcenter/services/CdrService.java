package com.itgarden.ERP.module.callcenter.services;

import com.itgarden.ERP.module.callcenter.Model.ECdr;
import com.itgarden.ERP.module.callcenter.master.model.CallerRtpIp;
import com.itgarden.ERP.module.callcenter.master.model.Endreason;
import com.itgarden.ERP.module.callcenter.master.ripository.CallerRtpIpRepository;
import com.itgarden.ERP.module.callcenter.master.services.EndreasonService;
import com.itgarden.ERP.module.callcenter.master.services.SettingsService;
import com.itgarden.ERP.module.callcenter.repository.GatewayroutingRepository;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author libertyerp_local
 */
@Service
public class CdrService {

    @PersistenceContext(unitName = "childEntityManagerFactory") // Define the unitName for the first EntityManager
    private EntityManager em;

    @Autowired
    GatewayroutingRepository gatewayroutingRepository;

    @Autowired
    EndreasonService endreasonService;

    @Autowired
    GatewayroutingService catewayroutingService;

    @Autowired
    SettingsService settingsService;

    @Autowired
    CallerRtpIpRepository callerRtpIpRepository;

    public List<ECdr> list() {

        /// Table Name start
        DateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
        Date ddate = new Date();

        String currentdate = dateFormat.format(ddate);

        String tablename = "e_cdr_" + currentdate;

        /// Table name end
        /// curretn time start 
        long currentUnixTimestamp = System.currentTimeMillis();

        long adjustedTimestamp = (currentUnixTimestamp / 1000) * 1000;

        long afterthirtyMinutesDurations = adjustedTimestamp - 1800000L;


        String sql = " select * from " + tablename + " WHERE starttime BETWEEN " + afterthirtyMinutesDurations + " AND " + adjustedTimestamp +" ORDER BY starttime DESC";

        // WHERE starttime BETWEEN  1704499254000 AND 1704519217000"
        Query query = em.createNativeQuery(sql, ECdr.class);
      
//     query
//
//        CriteriaQuery<ECdr> cq = cb.crecreateQuery(ECdr.class);
//
//        
//
//        cb.literal(sql);
//
//       // Root<ECdr> rootCdr = cq.from(ECdr.class);
//
//        cq.select(cb.literal(sql));
//
//        // cq.where(predicates.toArray(new Predicate[]{}));
//        TypedQuery<ECdr> result = em.createQuery(cq);

        return query.getResultList();

    }



    public List<ECdr> list4() {

        List<ECdr> cdrList = list();

        //System.out.println("Total Data from cdr Table " + list().size());
        List<Endreason> whiteList = endreasonService.whitelist();

//        for (Endreason whiteLists : whiteList) {
//
//            System.out.println("ID_" + whiteLists.getValue() + "whiteLists");
//            // code block to be executed
//        }
        List<Integer> value = whiteList.stream().map(v -> v.getValue()).collect(Collectors.toList());
        //value.forEach(System.out::println);

//        Predicate<ECdr> whitelist = x -> x.getEndreason().compareTo(Integer.SIZE) == value;
        // Predicate.isEqual(value);
        //List<Integer> unlockRouting = catewayroutingService.getwayRoutingUnLock().stream().map(v -> v.getLocktype()).collect(Collectors.toList());
        int min = 0;

        int max = settingsService.callerpdd();

        Predicate<ECdr> callerpddfilter = e -> e.getCallerpdd() >= min && e.getCallerpdd() <= max;

        Predicate<ECdr> endreasonfilter = v -> value.contains(v.getEndreason());

        List<CallerRtpIp> callerRtpIpList = callerRtpIpRepository.findAll();

        List<String> callerRtpIpLists = callerRtpIpList.stream().map(e -> e.getCallerrtpip()).collect(Collectors.toList());

        //callerRtpIpLists.forEach(System.out::println);
        // List<String> pp = Arrays.asList("72.21.24.223", "145.239.4.213");
        Predicate<ECdr> callerRtpIpListcontains = e -> callerRtpIpLists.contains(e.getCallerrtpip());

        List<ECdr> cdrLists = cdrList.stream().filter(endreasonfilter).filter(callerRtpIpListcontains).filter(callerpddfilter).collect(Collectors.toList());

        //.filter(callerRtpIpListcontains).filter(callerpddfilter)
        // System.out.println("Total Data After filter " + cdrLists.size());
//        for (Integer values : value) {
//
//            System.out.println("ID_" + values + "value");
//            // code block to be executed
//        }
//        System.out.println("Total Data" + cdrList2.size());
//
//        for (ECdr lists : cdrList2) {
//
//            System.out.println("ID_" + lists.id + "_callere164_");
//            // code block to be executed
//        }
        return cdrLists;

    }

}
