package com.opsbin.springconfigsecurity.daos.impl;

import com.opsbin.springconfigsecurity.daos.UserDetailsDao;
import com.opsbin.springconfigsecurity.entities.Account;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserDetailsDaoImp implements UserDetailsDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public Account findUserByUsername(String username) {
        String sql = "SELECT * FROM accounts ac INNER JOIN authorities au ON ac.account_id = au.account_id WHERE ac.username = :username";
        Account acc = sessionFactory.getCurrentSession()
                .createNativeQuery(sql, Account.class)
                .setParameter("username", username)
                .uniqueResult();
        return acc;
    }
}
