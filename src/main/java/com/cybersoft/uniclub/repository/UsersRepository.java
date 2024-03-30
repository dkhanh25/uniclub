package com.cybersoft.uniclub.repository;

import com.cybersoft.uniclub.entity.UsersEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsersRepository extends JpaRepository<UsersEntity,Integer> {
    UsersEntity findByEmail(String username);
}
