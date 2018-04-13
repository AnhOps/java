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
        return findAccountByUsernameNamedQuery(username);
    }

    /**
     * get an account by username using NamedQuery
     * Account.class -> hqlFindAccountByUsername
     * @param username
     * @return account
     */
    private Account findAccountByUsernameNamedQuery(String username) {
        Account account = sessionFactory.getCurrentSession()
            .createNamedQuery("hqlFindAccountByUsername", Account.class)
            .setParameter("username", username)
            .getSingleResult();
        return account;
    }

    /**
     * get an account by username using NamedNativeQuery
     * Account.class -> sqlFindAccountByUsername
     * @param username
     * @return account
     */
    private Account findAccountByUsernameNamedNativeQuery(String username) {
        Account account = (Account) sessionFactory.getCurrentSession()
            .getNamedNativeQuery("sqlFindAccountByUsername")
            .setParameter("username", username)
            .getSingleResult();
        return account;
    }
}
