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
    return sessionFactory.getCurrentSession().get(Account.class, username);
  }
}
