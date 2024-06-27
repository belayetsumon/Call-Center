/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/springframework/Repository.java to edit this template
 */
package com.itgarden.ERP.module.callcenter.master.ripository;

import com.itgarden.ERP.module.callcenter.master.model.AssignedNumber;
import java.time.LocalDateTime;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

/**
 *
 * @author libertyerp_local
 */
public interface AssignedNumberRepository extends JpaRepository<AssignedNumber, Long> {

    AssignedNumber findByIncommingNumber(String incommingNumber);

    @Modifying
    @Query("DELETE FROM AssignedNumber a WHERE a.modified <= :daysAgo")
    void deleteEntitiesModifiedBefore(LocalDateTime daysAgo);
}
