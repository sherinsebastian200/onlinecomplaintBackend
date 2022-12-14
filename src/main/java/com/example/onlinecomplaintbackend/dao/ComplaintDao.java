package com.example.onlinecomplaintbackend.dao;

import com.example.onlinecomplaintbackend.model.Complaint;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Map;

public interface ComplaintDao extends CrudRepository<Complaint,Integer> {

    @Query(value = "SELECT `id`, `address`, `email`, `name`, `password`, `phoneno`, `phone`, `username` FROM `user` u JOIN complaints c ON u.id = c.user_id",nativeQuery = true)
    List<Map<String,String>>ViewAllComplaint();


    @Query(value = "SELECT `id`, `complaints`, `user_id` FROM `complaints` WHERE `user_id`=:user_id",nativeQuery = true)
    List<Complaint>ViewMyComplaint(@Param("user_id") Integer user_id);


}
