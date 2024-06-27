/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/springframework/Repository.java to edit this template
 */
package com.itgarden.ERP.module.callcenter.master.ripository;

import com.itgarden.ERP.module.callcenter.master.model.DataScanTime;
import java.util.List;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author libertyerp_local
 */
public interface DataScanTimeRepository extends JpaRepository<DataScanTime, Long> {
     List<DataScanTime> findAll(Sort sort);
}
