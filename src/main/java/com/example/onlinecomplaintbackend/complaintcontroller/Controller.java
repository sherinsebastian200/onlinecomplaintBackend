package com.example.onlinecomplaintbackend.complaintcontroller;

import com.example.onlinecomplaintbackend.dao.UserDao;
import com.example.onlinecomplaintbackend.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class Controller {
    @Autowired
    private UserDao dao;
    @CrossOrigin(origins = "*")
    @PostMapping(path = "/add",consumes = "application/json",produces = "application/json")
    public Map<String,String>AddUser(@RequestBody User u)
    {
        System.out.println(u.getAddress().toString());
        System.out.println(u.getName().toString());
        System.out.println(u.getEmail().toString());
        System.out.println(u.getUsername().toString());
        System.out.println(u.getPhone());
        System.out.println(u.getPassword().toString());
        System.out.println(u.getConfirm().toString());
        dao.save(u);
        HashMap<String,String> map=new HashMap<>();
        map.put("status","success");
        return map;
    }
    @CrossOrigin(origins = "*")
    @PostMapping(path = "/userlogin",consumes = "application/json",produces = "application/json")
    public Map<String,String> UserLogin(@RequestBody User u)
    {
        String email=u.getEmail().toString();
        String password=u.getPassword().toString();
        System.out.println(email);
        System.out.println(password);
        List<User> result=(List<User>) dao.UserLogin(u.getEmail(),u.getPassword());
        HashMap<String,String> map=new HashMap<>();
        if(result.size()==0)
        {
            map.put("status","failed");
        }
        else{
            int id=result.get(0).getId();
            map.put("userId",String.valueOf(id));
            map.put("status","success");
        }
        return map;
    }
    @CrossOrigin(origins = "*")
    @PostMapping(path = "/view",consumes = "application/json",produces = "application/json")
    public List<User> UserById(@RequestBody User u)
    {
        String id=String.valueOf(u.getId());
        System.out.println(id);
        return (List<User>) dao.UserById(u.getId());
    }
}
