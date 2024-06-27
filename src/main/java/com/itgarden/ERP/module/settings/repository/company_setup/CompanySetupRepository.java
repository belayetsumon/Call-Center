/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.itgarden.ERP.module.settings.repository.company_setup;

import com.itgarden.ERP.module.settings.model.company_setup.CompanySetup;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author User
 */
@Repository
public interface CompanySetupRepository extends JpaRepository<CompanySetup, Long> {

}
