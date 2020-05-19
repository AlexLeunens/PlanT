package com.fjord.plant.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.security.core.GrantedAuthority;
import java.util.ArrayList;
import java.util.List;
import javax.transaction.Transactional;

import com.fjord.plant.Model.User;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UserService userService;

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {
        User user = userService.findUserByEmail(name);

        return buildUserForAuthentication(user);
    }

    private UserDetails buildUserForAuthentication(User user) {
        List<GrantedAuthority> grantedAuthorities = new ArrayList<>(); // for now, we don't have roles

        return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(), true, true,
                true, true, grantedAuthorities);
    }
}