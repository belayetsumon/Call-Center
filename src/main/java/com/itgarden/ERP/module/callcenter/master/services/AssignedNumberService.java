package com.itgarden.ERP.module.callcenter.master.services;

import com.itgarden.ERP.module.callcenter.Model.Gatewayrouting;
import com.itgarden.ERP.module.callcenter.Model.Gatewayroutingsetting;
import com.itgarden.ERP.module.callcenter.master.model.AssignedNumber;
import com.itgarden.ERP.module.callcenter.master.model.CdrTempCountDTO;
import com.itgarden.ERP.module.callcenter.master.model.PrefixTable;
import com.itgarden.ERP.module.callcenter.master.ripository.AssignedNumberRepository;
import com.itgarden.ERP.module.callcenter.repository.GatewayroutingRepository;
import com.itgarden.ERP.module.callcenter.services.CdrService;
import com.itgarden.ERP.module.callcenter.services.GatewayroutingService;
import com.itgarden.ERP.module.callcenter.services.GatewayroutingsettingService;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaDelete;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ObjectUtils;

/**
 *
 * @author libertyerp_local
 */
@Service
@Repository
public class AssignedNumberService {

    @Autowired
    CdrService cdrService;

    @Autowired
    PrefixTableService prefixTableService;

    @Autowired
    CdrTempService cdrTempService;

    @Autowired
    AssignedNumberRepository assignedNumberRepository;

    @Autowired
    GatewayroutingsettingService gatewayroutingsettingService;

    @Autowired
    GatewayroutingRepository gatewayroutingRepository;

    @Autowired
    GatewayroutingService gatewayroutingService;

    @Autowired
    @Qualifier("masterTransactionManager")
    private PlatformTransactionManager masterPlatformTransactionManager;

//      @Autowired
//    @Qualifier("masterEntityManagerFactory")
//    private EntityManagerFactory masterEntityManagerFactory;
//     @PersistenceUnit(unitName = "masterEntityManagerFactory")
//    private EntityManagerFactory entityManagerFactory;
//     
//     EntityManager em = entityManagerFactory.createEntityManager();
    @PersistenceContext(unitName = "masterEntityManagerFactory")
    EntityManager em;

    //@Transactional(transactionManager = "masterTransactionManager")
    public List<AssignedNumber> assignedNumberlist() {

        CriteriaBuilder cb = em.getCriteriaBuilder();

        CriteriaQuery<AssignedNumber> cq = cb.createQuery(AssignedNumber.class);

        Root<AssignedNumber> root = cq.from(AssignedNumber.class);

        cq.select(root);

        List<Predicate> predicates = new ArrayList<Predicate>();

//        Calculate the Unix timestamp for the current time and 30 minutes ago
//        long currentTime = Instant.now().toEpochMilli();
//        long thirtyMinutesAgo = Instant.now().minus(30, ChronoUnit.MINUTES).toEpochMilli();
//
//        predicates.add(cb.between(rootSm.get("starttime"), thirtyMinutesAgo, currentTime));
        cq.where(predicates.toArray(new Predicate[]{}));

        // cq.orderBy(cb.desc(rootSm.get("starttime")));
        TypedQuery<AssignedNumber> result = em.createQuery(cq);

        return result.getResultList();

    }

  // @Transactional(transactionManager = "masterTransactionManager")
    public List<AssignedNumber> numberlist(
            Integer gatewayroutingId,
            String incommingNumber
    ) {

        CriteriaBuilder cb = em.getCriteriaBuilder();

        CriteriaQuery<AssignedNumber> cq = cb.createQuery(AssignedNumber.class);

        Root<AssignedNumber> root = cq.from(AssignedNumber.class);

        cq.select(root);

        List<Predicate> predicates = new ArrayList<Predicate>();

        if (StringUtils.isNotEmpty(incommingNumber)) {
            predicates.add(cb.and(cb.like(root.get("incommingNumber"), incommingNumber)));
        }

        if (!ObjectUtils.isEmpty(gatewayroutingId)) {
            predicates.add(cb.and(cb.equal(root.get("gatewayroutingId"), gatewayroutingId)));
        }

        cq.where(predicates.toArray(new Predicate[]{}));

        cq.orderBy(cb.desc(root.get("repeats")));

        TypedQuery<AssignedNumber> result = em.createQuery(cq);

        return result.getResultList();

    }

   // @Transactional(transactionManager = "masterTransactionManager")
    public void numberAssign() {

        /// save value in temp table 
        //// process 1
        // cdrTempService.saveValueFromCdrAfterFilter();
        /// process 2
        List<PrefixTable> prefixList = prefixTableService.prefixTableValueListByStatusAndSortByCountDownAsce();

        List<CdrTempCountDTO> incommingNumberList = cdrTempService.repetValueCountListLast30Minutes();
        // List<CdrTempCountDTO> incommingNumberList = cdrTempService.repetValueCountList();

        List<AssignedNumber> assignedNumberlist = new ArrayList<>();

        if (prefixList.size() > 0 && incommingNumberList.size() > 0) { // number and prefix check 

            for (int i = 0; i <= prefixList.size() - 1; i++) { // prefix list

                AssignedNumber incommingNumber = assignedNumberRepository.findByIncommingNumber(incommingNumberList.get(i).getCalleee164());

                /*  AssignedNumber assignedNumber = new AssignedNumber();
                assignedNumber.setGatewayroutingId(prefixList.get(i).getConfigId().getGatewayroutingId());
                assignedNumber.setGatewayName(prefixList.get(i).getConfigId().getName());
                assignedNumber.setGatewayNamePrefix(prefixList.get(i).getPrefix());

                assignedNumber.setGatewayRoutingPrefix(
                        createGatewayRoutingPrefix(
                                incommingNumberList.get(i).getCalleee164()
                        ));

                assignedNumber.setGatewayRoutingSettingRewriteRules(
                        createGatewayRoutingSettingRewriteRules(
                                incommingNumberList.get(i).getCalleee164(),
                                prefixList.get(i).getPrefix())
                );

                assignedNumber.setIncommingNumber(incommingNumberList.get(i).getCalleee164());
                assignedNumber.setPriority(1);
                assignedNumber.setRepeats(Integer.parseInt(incommingNumberList.get(i).getCalleeecount()));

                // save assign number table
                assignedNumberRepository.save(assignedNumber);
                prefixTableService.updatePrefixLastUpdateTimefterAssign(prefixList.get(i).getId());

                // assignedNumberlist.add(assignedNumber);
                 */
                if (incommingNumber != null) { /// repeat count

                    AssignedNumber assignedNumber = new AssignedNumber();
                    assignedNumber.setGatewayroutingId(prefixList.get(i).getConfigId().getGatewayroutingId());
                    assignedNumber.setGatewayName(prefixList.get(i).getConfigId().getName());
                    assignedNumber.setGatewayNamePrefix(prefixList.get(i).getPrefix());

                   assignedNumber.setGatewayRoutingPrefix(
                            createGatewayRoutingPrefix(
                                    incommingNumberList.get(i).getCalleee164())
                    );

                    assignedNumber.setGatewayRoutingSettingRewriteRules(
                            createGatewayRoutingSettingRewriteRules(
                                    incommingNumberList.get(i).getCalleee164(),
                                    prefixList.get(i).getPrefix())
                    );
                    assignedNumber.setId(incommingNumber.getId());
                    assignedNumber.setIncommingNumber(incommingNumberList.get(i).getCalleee164());
                    assignedNumber.setPriority(1);

                    int count = incommingNumber.getRepeats() + Integer.parseInt(incommingNumberList.get(i).getCalleeecount());

                    assignedNumber.setRepeats(count);

                    // save assign number table
                    assignedNumberRepository.save(assignedNumber);
                    
                    prefixTableService.updatePrefixLastUpdateTimefterAssign(prefixList.get(i).getId());

                    // assignedNumberlist.add(assignedNumber);
                } else {

                    AssignedNumber assignedNumber = new AssignedNumber();
                    assignedNumber.setGatewayroutingId(prefixList.get(i).getConfigId().getGatewayroutingId());
                    assignedNumber.setGatewayName(prefixList.get(i).getConfigId().getName());
                    assignedNumber.setGatewayNamePrefix(prefixList.get(i).getPrefix());

                    assignedNumber.setGatewayRoutingPrefix(
                            createGatewayRoutingPrefix(
                                    incommingNumberList.get(i).getCalleee164())
                    );

                    assignedNumber.setGatewayRoutingSettingRewriteRules(
                            createGatewayRoutingSettingRewriteRules(
                                    incommingNumberList.get(i).getCalleee164(),
                                    prefixList.get(i).getPrefix())
                    );

                    assignedNumber.setIncommingNumber(incommingNumberList.get(i).getCalleee164());
                    assignedNumber.setPriority(1);
                    assignedNumber.setRepeats(Integer.parseInt(incommingNumberList.get(i).getCalleeecount()));

                    // save assign number table
                    assignedNumberRepository.save(assignedNumber);
                    prefixTableService.updatePrefixLastUpdateTimefterAssign(prefixList.get(i).getId());

                    // assignedNumberlist.add(assignedNumber);
                }

                // update prefix table
                if (i == prefixList.size() - 1 || i == incommingNumberList.size() - 1) {
                    //System.out.println("Limit reached. Exiting the loop.");
                    break;
                }// end break condition
            }// end for conditions 

        }// end if condition 

        // assignedNumberlist.stream().collect(Collectors.toList()).forEach(System.out::println);
        /// process 3
    }

    //// createGatewayRoutingPrefix
    //@Transactional(transactionManager = "masterTransactionManager")
    public String createGatewayRoutingPrefix(String number) {
        String finalvalue = number + ":" + 1;
        return finalvalue;
    }

//    public  String addCharsAfterFirstTwo(String original, String charsToAdd) {
//        // Check if the original string has at least two characters
//        if (original.length() >= 2) {
//            // Split the string into two parts: the first two characters and the rest
//            String firstTwoChars = original.substring(0, 2);
//            String restOfString = original.substring(2);
//            // Concatenate the first two characters, the additional characters, and the rest of the string
//            return firstTwoChars + charsToAdd + restOfString;
//        } else {
//            // If the original string has less than two characters, just return the original string
//            return original;
//        }
//    }
  //@Transactional(transactionManager = "masterTransactionManager")
    public String createGatewayRoutingSettingRewriteRules(String number, int gatewayNamePrefix) {

        String afterRemoved3Cha = number.substring(3);

        String addPrefix = gatewayNamePrefix + afterRemoved3Cha;

        String finalvalue = number + ":" + addPrefix;
        //System.out.println(finalvalue);
        return finalvalue;
    }

    /// createGatewayRoutingSettingRewriteRules
    //@Transactional(transactionManager = "masterTransactionManager")
    public String createGatewayRoutingPrefix23(String number, int gatewayNamePrefix) {

        String firstTwoChars = number.substring(0, 2);
        String afterRemoved2Cha = number.substring(2);

        String addPrefix = firstTwoChars + gatewayNamePrefix + afterRemoved2Cha;

        String finalvalue = addPrefix + ":" + 1;
        //System.out.println(finalvalue);
        return finalvalue;
    }

    // Gatewayrouting prefix update
 // @Transactional(transactionManager = "masterTransactionManager")
    public void gatewayRoutingGatewayRoutingPrefixDataConcat() {

        String nativeQuery = "SELECT gatewayrouting_id, GROUP_CONCAT(gatewayRoutingPrefix) AS grsrr FROM assignednumber GROUP BY gatewayrouting_id";

        Query query = em.createNativeQuery(nativeQuery);

        List<Object[]> resultList = query.getResultList();

        List<Gatewayrouting> gatewayroutingList = new ArrayList<>();

        for (Object[] results : resultList) {

            Gatewayrouting gatewayrouting = new Gatewayrouting();

            int gatewayroutingId = (int) results[0];
            String gatewayRoutingPrefix = (String) results[1];

            gatewayrouting.setId(gatewayroutingId);
            gatewayrouting.setPrefix(gatewayRoutingPrefix);

            gatewayroutingList.add(gatewayrouting);
        }

        //results.getId()  System.out.println("total getway routing" +gatewayroutingList.size());
        for (Gatewayrouting gatewayroutings : gatewayroutingList) {

            //System.out.println("total getway routing_ _" + gatewayroutings.getId());
            //System.out.println("total getway routing____" + gatewayroutings.getPrefix());
            gatewayroutingService.updateGetwayRoutingPrefix(gatewayroutings.getId(), gatewayroutings.getPrefix());
        }

        // return resultList;
    } // end method

    // Gatewayrouting prefix rull update
    //@Transactional(transactionManager = "masterTransactionManager")
    public void gatewayRoutingSettingRewriteRulesDataConcat() {

        String nativeQuery = "SELECT gatewayrouting_id, GROUP_CONCAT(gatewayRoutingSettingRewriteRules) AS grsrr FROM assignednumber GROUP BY gatewayrouting_id";
        Query query = em.createNativeQuery(nativeQuery);
        List<Object[]> resultList = query.getResultList();

        List<Gatewayroutingsetting> gatewayroutingsettingList = new ArrayList<>();

        for (Object[] results : resultList) {

            Gatewayroutingsetting gMSetting = new Gatewayroutingsetting();

            int gatewayroutingId = (int) results[0];

            String gatewayRoutingSettingRewriteRules = (String) results[1];

            gMSetting.setGatewayroutingId(gatewayroutingId);

            gMSetting.setRewriterulesincallee(gatewayRoutingSettingRewriteRules);

            gatewayroutingsettingList.add(gMSetting);
        }

        for (Gatewayroutingsetting results : gatewayroutingsettingList) {

//             System.out.println(" number "+ results.getRewriterulesincallee());
//            System.out.println(" id _"+ results.getGatewayroutingId());
            gatewayroutingsettingService.updateRewriterulesincallee(results.getGatewayroutingId(), results.getRewriterulesincallee());
        }

        // return resultList;
    }// end method

   @Transactional(transactionManager = "masterTransactionManager")
    public void deleteEntitiesUpdatedBeforeDays(int days) {

        CriteriaBuilder cb = em.getCriteriaBuilder();

        CriteriaDelete<AssignedNumber> deleteQuery = cb.createCriteriaDelete(AssignedNumber.class);
        Root<AssignedNumber> root = deleteQuery.from(AssignedNumber.class);

        LocalDateTime daysAgo = LocalDateTime.now().minusDays(days);
       // System.out.println("ffffffffffffffffffffffffffffffffffff" + daysAgo);

        Predicate predicate = cb.lessThanOrEqualTo(root.get("modified"), daysAgo);

        deleteQuery.where(predicate);

        em.createQuery(deleteQuery).executeUpdate();

    }
    
    
 
    
    
    public void deleteEntitiesModifiedBeforeDays(int days) {
        LocalDateTime daysAgo = LocalDateTime.now().minusDays(days);
        assignedNumberRepository.deleteEntitiesModifiedBefore(daysAgo);
    }
    
    
}
