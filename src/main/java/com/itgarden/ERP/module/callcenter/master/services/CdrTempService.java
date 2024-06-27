/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/springframework/Service.java to edit this template
 */
package com.itgarden.ERP.module.callcenter.master.services;

import com.itgarden.ERP.module.callcenter.master.model.CdrTemp;
import com.itgarden.ERP.module.callcenter.master.model.CdrTempCountDTO;
import com.itgarden.ERP.module.callcenter.master.ripository.CdrTempRepository;
import com.itgarden.ERP.module.callcenter.services.CdrService;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Tuple;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author libertyerp_local
 */
@Service
public class CdrTempService {

    @PersistenceContext(unitName = "masterEntityManagerFactory")
    EntityManager em;

    @Autowired
    SettingsService settingsService;

    @Autowired
    CdrService cdrService;
    @Autowired
    CdrTempRepository cdrTempRepository;

    /// last 3 minutes data 
//    public void saveValueFromCdrAfterFilter() {
//
//  
//
//    }
    public List<CdrTemp> last30minutesDataList() {

        CriteriaBuilder cb = em.getCriteriaBuilder();

        CriteriaQuery<CdrTemp> cq = cb.createQuery(CdrTemp.class);

        Root<CdrTemp> rootSm = cq.from(CdrTemp.class);

        cq.select(rootSm);

        List<Predicate> predicates = new ArrayList<Predicate>();

        // Calculate the Unix timestamp for the current time and 30 minutes ago
        long currentTime = Instant.now().toEpochMilli();
        long thirtyMinutesAgo = Instant.now().minus(5, ChronoUnit.MINUTES).toEpochMilli();
        // long thirtyMinutesAgo = Instant.now().minus(30, ChronoUnit.MINUTES).toEpochMilli();

        predicates.add(cb.between(rootSm.get("starttime"), thirtyMinutesAgo, currentTime));

        cq.where(predicates.toArray(new Predicate[]{}));

        cq.orderBy(cb.desc(rootSm.get("starttime")));

        TypedQuery<CdrTemp> result = em.createQuery(cq);

        return result.getResultList();
    }

    public List<CdrTempCountDTO> repetValueCountList() {

        CriteriaBuilder cb = em.getCriteriaBuilder();

        CriteriaQuery<Tuple> cq = cb.createQuery(Tuple.class);

        Root<CdrTemp> rootSm = cq.from(CdrTemp.class);

        cq.multiselect(
                rootSm.get("calleee164").alias("calleee164"),
                cb.count(rootSm.get("calleee164")).alias("count")
        );

        List<Predicate> predicates = new ArrayList<Predicate>();

        // Calculate the Unix timestamp for the current time and 30 minutes ago
//        long currentTime = Instant.now().toEpochMilli();
//        long thirtyMinutesAgo = Instant.now().minus(30, ChronoUnit.MINUTES).toEpochMilli();
//
//        predicates.add(cb.between(rootSm.get("starttime"), thirtyMinutesAgo, currentTime));
        cq.where(predicates.toArray(new Predicate[]{}));

        cq.groupBy(rootSm.get("calleee164"));

        Long repeat = Long.valueOf(settingsService.repeatNumber()); // repet callerpdd

        cq.having(cb.greaterThanOrEqualTo(
                cb.count(rootSm.get("calleee164")), cb.literal(repeat)));

        cq.orderBy(cb.desc(cb.count(rootSm.get("calleee164"))));

        TypedQuery<Tuple> result = em.createQuery(cq);

        List<CdrTempCountDTO> cdrTempCountDTOlist = new ArrayList<CdrTempCountDTO>();

        for (Tuple results : result.getResultList()) {

            CdrTempCountDTO cdrTempCountDTO = new CdrTempCountDTO();

            cdrTempCountDTO.setCalleee164(results.get("calleee164", String.class));

            cdrTempCountDTO.setCalleeecount(String.valueOf(results.get("count", Long.class)));

            cdrTempCountDTOlist.add(cdrTempCountDTO);
        }

        return cdrTempCountDTOlist;
    }

    public List<CdrTempCountDTO> repetValueCountListLast30Minutes() {

        CriteriaBuilder cb = em.getCriteriaBuilder();

        CriteriaQuery<Tuple> cq = cb.createQuery(Tuple.class);

        Root<CdrTemp> rootSm = cq.from(CdrTemp.class);

        cq.multiselect(
                rootSm.get("calleee164").alias("calleee164"),
                cb.count(rootSm.get("calleee164")).alias("count")
        );

        List<Predicate> predicates = new ArrayList<Predicate>();

        // Calculate the Unix timestamp for the current time and 30 minutes ago
        long currentTime = Instant.now().toEpochMilli();
        long thirtyMinutesAgo = Instant.now().minus(5, ChronoUnit.MINUTES).toEpochMilli();
        //long thirtyMinutesAgo = Instant.now().minus(30, ChronoUnit.MINUTES).toEpochMilli();
        predicates.add(cb.between(rootSm.get("starttime"), thirtyMinutesAgo, currentTime));

        cq.where(predicates.toArray(new Predicate[]{}));

        cq.groupBy(rootSm.get("calleee164"));

        Long repeat = Long.valueOf(settingsService.repeatNumber()); // repet callerpdd

        cq.having(cb.greaterThanOrEqualTo(
                cb.count(rootSm.get("calleee164")), cb.literal(repeat)));

        cq.orderBy(cb.desc(cb.count(rootSm.get("calleee164"))));

        TypedQuery<Tuple> result = em.createQuery(cq);

        List<CdrTempCountDTO> cdrTempCountDTOlist = new ArrayList<CdrTempCountDTO>();

        for (Tuple results : result.getResultList()) {

            CdrTempCountDTO cdrTempCountDTO = new CdrTempCountDTO();

            cdrTempCountDTO.setCalleee164(results.get("calleee164", String.class));

            cdrTempCountDTO.setCalleeecount(String.valueOf(results.get("count", Long.class)));

            cdrTempCountDTOlist.add(cdrTempCountDTO);
        }

        return cdrTempCountDTOlist;
    }

}
