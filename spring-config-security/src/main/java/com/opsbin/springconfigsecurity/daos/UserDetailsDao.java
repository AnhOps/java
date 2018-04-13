package com.opsbin.springconfigsecurity.daos;

import com.opsbin.springconfigsecurity.entities.Account;

public interface UserDetailsDao {
    Account findUserByUsername(String username);
}
