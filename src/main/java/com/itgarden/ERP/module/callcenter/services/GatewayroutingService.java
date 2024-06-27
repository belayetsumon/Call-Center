/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/springframework/Service.java to edit this template
 */
package com.itgarden.ERP.module.callcenter.services;

import com.itgarden.ERP.module.callcenter.Model.Gatewayrouting;
import com.itgarden.ERP.module.callcenter.master.services.ConfigurationVoiceService;
import com.itgarden.ERP.module.callcenter.repository.GatewayroutingRepository;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author libertyerp_local
 */
@Service
public class GatewayroutingService {

    @PersistenceUnit(unitName = "childEntityManagerFactory")
    private EntityManagerFactory secondaryEntityManagerFactory;

    @Autowired
    GatewayroutingRepository gatewayroutingRepository;

    @Autowired
    ConfigurationVoiceService configurationVoiceService;

    public List<Gatewayrouting> getwayRoutingNameList() {
        EntityManager em = secondaryEntityManagerFactory.createEntityManager();
        CriteriaBuilder cb = em.getCriteriaBuilder();

        CriteriaQuery<Gatewayrouting> cq = cb.createQuery(Gatewayrouting.class);

        Root<Gatewayrouting> rootgt = cq.from(Gatewayrouting.class);

        cq.select(rootgt);

        return em.createQuery(cq).getResultList();
    }
    
    @Transactional(transactionManager = "childTransactionManager")

    public List<Gatewayrouting> getwayRoutingNameList2() {
        EntityManager em = secondaryEntityManagerFactory.createEntityManager();
        
        List<Integer> list = configurationVoiceService.configurationVoiceGatewayRoutingIdList();

        CriteriaBuilder cb = em.getCriteriaBuilder();

        CriteriaQuery<Gatewayrouting> cq = cb.createQuery(Gatewayrouting.class);

        Root<Gatewayrouting> rootgt = cq.from(Gatewayrouting.class);
        cq.select(rootgt);

        List<Predicate> predicates = new ArrayList<Predicate>();
//
     if(!list.isEmpty()){
        predicates.add(cb.not(rootgt.get("id").in(list)));
     }
        cq.where(predicates.toArray(new Predicate[]{}));

        return em.createQuery(cq).getResultList();
    }
    @Transactional(transactionManager = "childTransactionManager", isolation = Isolation.SERIALIZABLE)
    public void updateGetwayRoutingPrefix(int id, String rule) {

        Gatewayrouting gatewayrouting = gatewayroutingRepository.findOne(id);
        
        if(gatewayrouting!= null){

        gatewayrouting.setPrefix(rule);

        gatewayroutingRepository.saveAndFlush(gatewayrouting);
        }else{
        
            //System.out.println(" Getway routing prefix not found____"+id);
        }
        

    }

}
