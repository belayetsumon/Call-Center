/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/springframework/Repository.java to edit this template
 */
package com.itgarden.ERP.module.callcenter.master.ripository;

import com.itgarden.ERP.module.callcenter.master.model.CdrTemp;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author libertyerp_local
 */
public interface CdrTempRepository extends JpaRepository<CdrTemp, Integer> {
    
}
