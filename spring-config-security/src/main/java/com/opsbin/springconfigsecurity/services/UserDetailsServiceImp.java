package com.opsbin.springconfigsecurity.services;

import com.opsbin.springconfigsecurity.daos.UserDetailsDao;
import com.opsbin.springconfigsecurity.entities.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("userDetailsService")
public class UserDetailsServiceImp implements UserDetailsService {

    @Autowired
    private UserDetailsDao userDetailsDao;

    @Transactional(readOnly = true)
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Account account = userDetailsDao.findUserByUsername(username);
        UserBuilder builder = null;
        if (account != null) {

            builder = org.springframework.security.core.userdetails.User.withUsername(username);
            builder.disabled(!account.isEnabled());
            builder.password(account.getPassword());
            String[] authorities = account.getAuthorities()
                    .stream().map(a -> a.getAuthority()).toArray(String[]::new);

            builder.authorities(authorities);
        } else {
            throw new UsernameNotFoundException("Account not found.");
        }
        return builder.build();
    }
}
