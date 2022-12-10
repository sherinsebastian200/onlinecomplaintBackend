package com.example.onlinecomplaintbackend.dao;

import com.example.onlinecomplaintbackend.model.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserDao extends CrudRepository<User,Integer> {
    @Query(value = "SELECT `id`, `address`, `email`, `name`, `password`, `phoneno` FROM `user` WHERE `email`=:email AND `password`=:password",nativeQuery = true)

    List<User> passwordUsers(@Param("email") String email, @Param("password") String password);


}
