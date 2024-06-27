/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.itgarden.ERP.globalConfiguration.audit;

import com.itgarden.ERP.module.user.ripository.UsersRepository;
import com.itgarden.ERP.module.user.services.UserComponent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.AuditorAware;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;

/**
 *
 * @author User
 */
class AuditorAwareImpl implements AuditorAware<String> {

    @Autowired
    UsersRepository usersRepository;

    @Autowired
    UserComponent userComponent;

    @Override
    public String getCurrentAuditor() {
        //return Optional.of("anonymous");

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        if (auth == null || !auth.isAuthenticated()) {
            return"anonymous";
        }

       User user = (User) auth.getPrincipal();
//
//        Users users = usersRepository.findByEmail(user.getUsername());
        return user.getUsername();
    }

}
