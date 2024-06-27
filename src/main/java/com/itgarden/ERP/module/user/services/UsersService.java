/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.itgarden.ERP.module.user.services;

import com.itgarden.ERP.globalservices.*;
import com.itgarden.ERP.module.user.model.*;

import java.text.*;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaUpdate;
import javax.persistence.criteria.Root;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.Service;

/**
 *
 * @author User
 */
@Service
public class UsersService {

    @Autowired
    LoggedUserService loggedUserService;

    @Autowired
    DateTimeService dateTimeService;

    @PersistenceContext
    EntityManager em;

    public void userloginDateTime() throws ParseException {

        dateTimeService.localCurrentDate();

        CriteriaBuilder cb = em.getCriteriaBuilder();

        CriteriaUpdate<Users> cu = cb.createCriteriaUpdate(Users.class);
        Root<Users> rootUsers = cu.from(Users.class);

        cu.set(rootUsers.get("lastLogin"), dateTimeService.localCurrentDate()).where(cb.equal(rootUsers.get("id"), loggedUserService.activeUserid()));

        em.createQuery(cu).executeUpdate();
    }

    public void userlogOutDateTime() throws ParseException {

        CriteriaBuilder cb = em.getCriteriaBuilder();

        CriteriaUpdate<Users> cu = cb.createCriteriaUpdate(Users.class);
        Root<Users> rootUsers = cu.from(Users.class);

        cu.set(rootUsers.get("lastLogOut"), dateTimeService.localCurrentDate()).where(cb.equal(rootUsers.get("id"), loggedUserService.activeUserid()));

        em.createQuery(cu).executeUpdate();
    }

}
