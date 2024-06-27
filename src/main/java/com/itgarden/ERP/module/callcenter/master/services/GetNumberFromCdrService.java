/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/springframework/Service.java to edit this template
 */
package com.itgarden.ERP.module.callcenter.master.services;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Service;

/**
 *
 * @author libertyerp_local
 */
@Service
public class GetNumberFromCdrService {

    // @Qualifier("secondaryEM")
    @PersistenceContext
    EntityManager em;
    
//    @Transactional
//    public List<> cdrData() {
//
//        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
//
//        CriteriaQuery<ItemStatusDTO> cq = cb.createQuery(ItemStatusDTO.class);
//
//        Root<StockMoves> rootSm = cq.from(StockMoves.class);
//
//        cq.select(cb.construct(ItemStatusDTO.class,
//                rootSm.get("items").get("id").alias("id"),
//                rootSm.get("items").get("itemCode").alias("itemCode"),
//                rootSm.get("items").get("name").alias("name"),
//                cb.sum(rootSm.get("qty")).alias("quantity"),
//                rootSm.get("standardCost").alias("retailPrice"),
//                //                rootSm.get("standardCost").alias("standardCost"),
//                //                rootSm.get("totalPrice").alias("retailPriceTotal"),
//                rootSm.get("totalPrice").alias("totalPrice")
//        ));

//     List<Predicate> predicates = new ArrayList<Predicate>();
//
//        if (StringUtils.isNotEmpty(itemCode)) {
//            predicates.add(cb.and(cb.like(rootSm.get("items").get("itemCode"), itemCode)));
//        }
//
//        if (StringUtils.isNotEmpty(name)) {
//            predicates.add(cb.and(cb.like(rootSm.get("items").get("name"), name)));
//        }
//
//        if (!ObjectUtils.isEmpty(category)) {
//            predicates.add(cb.and(cb.equal(rootSm.get("items").get("category"), category)));
//        }
//
//        if (!ObjectUtils.isEmpty(location)) {
//            predicates.add(cb.and(cb.equal(rootSm.get("inventoryLocations"), location)));
//        }

//        cq.where(predicates.toArray(new Predicate[]{}));
//
//        cq.groupBy(rootSm.get("items").get("id"));
//
//        cq.orderBy(cb.desc(rootSm.get("items").get("id")));

//        TypedQuery<ItemStatusDTO> result = entityManager.createQuery(cq);
//
//        return itemStatusDTOList;
   // }


    
    
    
    
    
    
    
}
