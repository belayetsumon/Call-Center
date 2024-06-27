/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.itgarden.ERP.module.user.ripository;

import com.itgarden.ERP.module.user.model.*;
import java.util.*;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;



/**
 *
 * @author Md Belayet Hossin
 */
@Repository
public interface UsersRepository extends JpaRepository<Users, Long> {
   
    Users findByEmail(String email);

    Users findByMobile(String mobile);

    List<Users> findByRole(Role role);

    List<Users> findByRoleAndStatusOrderByIdDesc(Role role, Status status);

    Users findByEmailAndStatus(String email, Status status);

    Users findByIdAndStatus(Long id, Status status);

    List<Users> findByStatus(Status status);

}
