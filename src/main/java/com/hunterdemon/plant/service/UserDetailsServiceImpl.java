package com.hunterdemon.plant.service;

import com.hunterdemon.plant.detail.UserDatail;
import com.hunterdemon.plant.model.UserInfor;
import com.hunterdemon.plant.repository.UserReponstory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    UserReponstory userReponstory;

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        try{
            UserInfor user = userReponstory.GetUserByUsername(username).get(0);
            return UserDatail.build(user);
        }catch (Exception ex){
            throw new UsernameNotFoundException(username);
        }


    }
}
