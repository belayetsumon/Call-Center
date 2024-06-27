/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/springframework/Repository.java to edit this template
 */
package com.itgarden.ERP.module.callcenter.repository;

import com.itgarden.ERP.module.callcenter.Model.Gatewaymapping;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author libertyerp_local
 */
public interface GatewaymappingRepository extends JpaRepository<Gatewaymapping, Long> {
    
}
