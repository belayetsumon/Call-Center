/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/springframework/Service.java to edit this template
 */
package com.itgarden.ERP.module.callcenter.services;

import com.itgarden.ERP.module.callcenter.Model.Gatewayroutingsetting;
import com.itgarden.ERP.module.callcenter.repository.GatewayroutingsettingRepository;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
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
public class GatewayroutingsettingService {

    @PersistenceContext(name = "childEntityManagerFactory")
    EntityManager em;

    @Autowired
    GatewayroutingsettingRepository gatewayroutingsettingRepository;

    @Transactional(transactionManager = "childTransactionManager")
    public List<Gatewayroutingsetting> getwayRoutingNameList() {

        CriteriaBuilder cb = em.getCriteriaBuilder();

        CriteriaQuery<Gatewayroutingsetting> cq = cb.createQuery(Gatewayroutingsetting.class);

        Root<Gatewayroutingsetting> rootgt = cq.from(Gatewayroutingsetting.class);

        cq.select(rootgt);

        return em.createQuery(cq).getResultList();
    }

    @Transactional(transactionManager = "childTransactionManager", isolation = Isolation.SERIALIZABLE)
    public void updateRewriterulesincallee(int id, String rule) {

        Gatewayroutingsetting gatewayroutingsetting = gatewayroutingsettingRepository.findByGatewayroutingId(id);

        if (gatewayroutingsetting != null) {

            gatewayroutingsetting.setRewriterulesincallee(rule);

            gatewayroutingsettingRepository.saveAndFlush(gatewayroutingsetting);
        } else {

            //System.out.println("Gateway routing setting id not found-----"+id);
        }

    }

}
