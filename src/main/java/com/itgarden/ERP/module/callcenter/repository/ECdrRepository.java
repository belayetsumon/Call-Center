/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/springframework/Repository.java to edit this template
 */
package com.itgarden.ERP.module.callcenter.repository;

import com.itgarden.ERP.module.callcenter.Model.ECdr;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author libertyerp_local
 */
@Repository
public interface ECdrRepository extends JpaRepository<ECdr, Long> {
    
}
