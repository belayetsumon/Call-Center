/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.itgarden.ERP.module.settings.company_setup.services;

import com.itgarden.ERP.module.settings.model.company_setup.CompanySetup;
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
 * @author User
 */
@Service
public class CompanySetupService {
    


    @PersistenceContext
    EntityManager em;

    public CompanySetup companyInfo() {

        CriteriaBuilder cb = em.getCriteriaBuilder();

        CriteriaQuery<CompanySetup> cq = cb.createQuery(CompanySetup.class);

        Root<CompanySetup> rootIlt = cq.from(CompanySetup.class);

        cq.select(rootIlt);

        List<Predicate> predicates = new ArrayList<Predicate>();

        predicates.add(cb.and(cb.equal(rootIlt.get("id"), 1l)));

        cq.where(predicates.toArray(new Predicate[]{}));

        TypedQuery<CompanySetup> result = em.createQuery(cq);

        return result.getSingleResult();

    }

}
