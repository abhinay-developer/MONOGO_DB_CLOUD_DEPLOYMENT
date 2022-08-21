package com.abhi.springboot.mongodb.cloud.repository;

import com.abhi.springboot.mongodb.cloud.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface UserRepository extends MongoRepository<User,String> {
    User findByEmailAndPassword(String email,String password);
}
