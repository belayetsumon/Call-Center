/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/springframework/Service.java to edit this template
 */
package com.itgarden.ERP.module.callcenter.master.services;

import com.itgarden.ERP.module.callcenter.master.model.AssignedNumber;
import com.itgarden.ERP.module.callcenter.master.ripository.AssignedNumberRepository;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Date;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaDelete;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author libertyerp_local
 */
@Service
public class AssignedNumberService2 {

    @PersistenceContext(unitName = "masterEntityManagerFactory")
    EntityManager em;

    @Autowired
    AssignedNumberRepository assignedNumberRepository;

    @Transactional(transactionManager = "masterTransactionManager")
    public void deleteEntitiesUpdatedBeforeDays(int days) {

        CriteriaBuilder cb = em.getCriteriaBuilder();

        CriteriaDelete<AssignedNumber> deleteQuery = cb.createCriteriaDelete(AssignedNumber.class);
        Root<AssignedNumber> root = deleteQuery.from(AssignedNumber.class);

        LocalDateTime daysAgo = LocalDateTime.now().minusDays(days);
        System.out.println("ffffffffffffffffffffffffffffffffffff" + daysAgo);

        Predicate predicate = cb.lessThanOrEqualTo(root.get("modified"), daysAgo);

        deleteQuery.where(cb.lessThanOrEqualTo(root.get("modified"), daysAgo));

         em.createQuery(deleteQuery).executeUpdate();

    }

}
