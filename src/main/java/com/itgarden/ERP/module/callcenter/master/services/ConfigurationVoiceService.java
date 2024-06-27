/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/springframework/Service.java to edit this template
 */
package com.itgarden.ERP.module.callcenter.master.services;

import com.itgarden.ERP.module.callcenter.master.model.ConfigurationVoice;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Tuple;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import org.springframework.stereotype.Service;

/**
 *
 * @author libertyerp_local
 */
@Service
public class ConfigurationVoiceService {

    @PersistenceContext(unitName = "masterEntityManagerFactory")
    EntityManager em;

    public List<Integer> configurationVoiceGatewayRoutingIdList() {

        CriteriaBuilder cb = em.getCriteriaBuilder();

        CriteriaQuery<Tuple> cq = cb.createQuery(Tuple.class);

        Root<ConfigurationVoice> rootSm = cq.from(ConfigurationVoice.class);

        cq.multiselect(rootSm.get("gatewayroutingId"));

//        List<Predicate> predicates = new ArrayList<Predicate>();
//
//      
//        predicates.add(cb.between(rootSm.get("starttime"), thirtyMinutesAgo, currentTime));
//
//        cq.where(predicates.toArray(new Predicate[]{}));

        cq.groupBy(rootSm.get("gatewayroutingId"));

        cq.orderBy(cb.asc(rootSm.get("gatewayroutingId")));

        List<Tuple> result = em.createQuery(cq).getResultList();
        
        
        List<Integer> idList = new ArrayList<Integer>();
        for (Tuple t : result) {
            int id = (int) t.get(0);
            idList.add(id);
        }
        return idList;
    }

}
