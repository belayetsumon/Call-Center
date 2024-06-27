/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/springframework/Service.java to edit this template
 */
package com.itgarden.ERP.module.callcenter.master.services;

import com.itgarden.ERP.module.callcenter.Model.ECdr;
import com.itgarden.ERP.module.callcenter.master.model.Endreason;
import com.itgarden.ERP.module.callcenter.master.model.EndreasonType;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import org.springframework.stereotype.Service;

/**
 *
 * @author libertyerp_local
 */
@Service
public class EndreasonService {

    @PersistenceContext(unitName = "masterEntityManagerFactory")
    EntityManager em;

    public List<Endreason> whitelist() {

        CriteriaBuilder cb = em.getCriteriaBuilder();

        CriteriaQuery<Endreason> cq = cb.createQuery(Endreason.class);

        Root<Endreason> rooter = cq.from(Endreason.class);

        cq.select(rooter);

        List<Predicate> predicates = new ArrayList<Predicate>();

        predicates.add(cb.and(cb.equal(rooter.get("endreasonType"), EndreasonType.whitelist)));

        cq.where(predicates.toArray(new Predicate[]{}));

        TypedQuery<Endreason> result = em.createQuery(cq);

        return result.getResultList();
    }

}
