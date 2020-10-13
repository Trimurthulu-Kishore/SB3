package com.iiht.eva.interviewtkr.dto;

import  com.iiht.eva.interviewtkr.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Integer> {

}
