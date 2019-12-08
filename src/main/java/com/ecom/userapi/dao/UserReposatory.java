package com.ecom.userapi.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ecom.userapi.entity.User;

@Repository
public interface UserReposatory extends JpaRepository<User, Long>{}
