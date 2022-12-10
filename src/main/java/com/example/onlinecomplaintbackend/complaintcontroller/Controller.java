package com.example.onlinecomplaintbackend.complaintcontroller;

import com.example.onlinecomplaintbackend.dao.UserDao;
import com.example.onlinecomplaintbackend.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;

@RestController
public class Controller {

    @Autowired
    UserDao dao;

    @CrossOrigin(origins = "*")
    @PostMapping(path = "/add",consumes = "application/json",produces = "application/json")
    public HashMap<String,String> add(@RequestBody User user) {
        HashMap<String, String> map = new HashMap<>();
        dao.save(user);
        map.put("status","success");
        return map;
    }

    @CrossOrigin(origins = "*")
    @PostMapping(path="/password",consumes = "application/json",produces = "application/json")
    public HashMap<String, String> password(@RequestBody User user){
        HashMap<String, String> map = new HashMap<>();
        List<User> users= dao.passwordUsers(user.getEmail(), user.getPassword());
        if (users.size() != 0) {
            map.put("id",String.valueOf( users.get(0).getId()));
            map.put("status","success");
        }else {
            map.put("status","failed");
        }
        return map;
    }
}

