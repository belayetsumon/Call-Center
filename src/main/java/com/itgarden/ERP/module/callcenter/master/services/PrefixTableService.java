/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/springframework/Service.java to edit this template
 */
package com.itgarden.ERP.module.callcenter.master.services;

import com.itgarden.ERP.module.callcenter.master.model.ConfigurationVoice;
import com.itgarden.ERP.module.callcenter.master.model.PrefixStatus;
import com.itgarden.ERP.module.callcenter.master.model.PrefixTable;
import com.itgarden.ERP.module.callcenter.master.ripository.PrefixTableRepository;
import java.time.Duration;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Tuple;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.CriteriaUpdate;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Root;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author libertyerp_local
 */
@Service
public class PrefixTableService {
    
    @PersistenceContext(unitName = "masterEntityManagerFactory")
    EntityManager em;
    
    @Autowired
    PrefixTableRepository prefixTableRepository;
    
    public List<PrefixTable> prefixTableValueList() {
        
        CriteriaBuilder cb = em.getCriteriaBuilder();
        
        CriteriaQuery<Tuple> cq = cb.createQuery(Tuple.class);
        
        Root<PrefixTable> rootSm = cq.from(PrefixTable.class);
        
        Expression<Integer> assigntime = rootSm.get("assignTime");
        
        Expression<Long> lastupdatetime = rootSm.get("lastUpdateTime");
        
        Expression<Long> currentTimestam = cb.literal(Instant.now().toEpochMilli());
        
        Expression<Long> timeDifference = cb.diff(currentTimestam, lastupdatetime);
        
        cq.multiselect(
                rootSm.get("id").alias("id"),
                rootSm.get("configId").alias("configId"),
                rootSm.get("prefix").alias("prefix"),
                rootSm.get("assignTime").alias("assignTime"),
                timeDifference.alias("timeDifference"),
                rootSm.get("lastUpdateTime").alias("lastUpdateTime"),
                rootSm.get("status").alias("status")
        );

//        List<Predicate> predicates = new ArrayList<Predicate>();
//        
//        cq.where(predicates.toArray(new Predicate[]{}));
        //cq.groupBy(rootSm.get("calleee164"));
        //cq.orderBy(cb.desc(cb.count(rootSm.get("calleee164"))));
        TypedQuery<Tuple> result = em.createQuery(cq);
        
        List<PrefixTable> prefixTablelist = new ArrayList<PrefixTable>();
        
        for (Tuple results : result.getResultList()) {
            
            PrefixTable prefixTable = new PrefixTable();
//
//            cdrTempCountDTO.setCalleee164(results.get("calleee164", String.class));
//
//            cdrTempCountDTO.setCalleeecount(String.valueOf(results.get("count", Long.class)));

            prefixTable.setId(results.get("id", Long.class));
            prefixTable.setConfigId(results.get("configId", ConfigurationVoice.class));
            prefixTable.setPrefix(results.get("prefix", Integer.class));
            prefixTable.setAssignTime(results.get("assignTime", Integer.class));
            
            Long timeDifferencew = results.get("timeDifference", Long.class);
            
            long durationInMinutes = Duration.ofMillis(timeDifferencew).toMinutes();
            
            int assignTime = results.get("assignTime", Integer.class);
            
            int countdown = (int) (assignTime - durationInMinutes);
            
            prefixTable.setCountDown(countdown);
            
            Long lastupdatehmrt = results.get("lastUpdateTime", Long.class);
            
            LocalDateTime dateTime = Instant.ofEpochMilli(lastupdatehmrt)
                    .atZone(ZoneId.systemDefault())
                    .toLocalDateTime();
            
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            
            String formattedDateTime = dateTime.format(formatter);
            
            prefixTable.setLastUpdateTimeHumanReadableTime(formattedDateTime);
            
            prefixTable.setStatus(results.get("status", PrefixStatus.class));
//
            prefixTablelist.add(prefixTable);
        }
        
        return prefixTablelist;
    }
    
    public void update(PrefixTable prefixTable) {
//        EntityManagerFactory emf = Persistence.createEntityManagerFactory("masterEntityManagerFactory");
        try {
            em.getTransaction().begin();
            CriteriaBuilder cb = em.getCriteriaBuilder();
            
            CriteriaUpdate<PrefixTable> update = cb.createCriteriaUpdate(PrefixTable.class);
            
            Root<PrefixTable> prefixTableRoot = update.from(PrefixTable.class);
            
            update.set("assignTime", prefixTable.getAssignTime());
            
            update.set("status", prefixTable.getStatus());
            
            update.where(cb.equal(prefixTableRoot.get("id"), prefixTable.getId()));
            
            em.createQuery(update).executeUpdate();
            
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }
    
    public List<PrefixTable> prefixTableValueListByStatusAndSortByCountDownAsce() {
        
        List<PrefixTable> prefixTableValueList = prefixTableValueList();
        
        Predicate<PrefixTable> byStatus = prefixTable -> prefixTable.getStatus().equals(PrefixStatus.Enable);
        
        List<PrefixTable> newList = prefixTableValueList.stream()
                .filter(byStatus)
                .sorted(Comparator.comparingInt(PrefixTable::getCountDown))
                .collect(Collectors.toList());

        //newList.forEach(System.out::println);
        return newList;
    }
    
    public void updatePrefixLastUpdateTimefterAssign(long id) {
        
        PrefixTable prefixTable = prefixTableRepository.findOne(id);
        
        long unixTimestampMillis = Instant.now().toEpochMilli();
        
        prefixTable.setLastUpdateTime(unixTimestampMillis);
        prefixTableRepository.save(prefixTable);
        
    }
    
}
