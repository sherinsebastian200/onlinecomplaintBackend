package com.example.onlinecomplaintbackend.complaintcontroller;

import com.example.onlinecomplaintbackend.dao.ComplaintDao;
import com.example.onlinecomplaintbackend.model.Complaint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class Complaintcontroller {

    @Autowired
    private ComplaintDao dao;
    @CrossOrigin(origins = "*")
    @PostMapping(path = "/addComplaint",consumes = "application/json",produces = "application/json")
    public Map<String,String> addComplaint(@RequestBody Complaint c)
    {
        HashMap<String,String> map=new HashMap<>();
        dao.save(c);
        map.put("status","success");
        return map;
    }
    @CrossOrigin(origins = "*")
    @GetMapping(path = "/viewall")
    public List<Map<String,String>> ViewAllComplaint()
    {
        return (List<Map<String,String>>) dao.ViewAllComplaint();
    }

    @CrossOrigin(origins = "*")
    @PostMapping(path = "/mycomplaint",consumes = "application/json",produces = "application/json")
    public List<Complaint> ViewMyComplaint(@RequestBody Complaint c)
    {
        return (List<Complaint>) dao.ViewMyComplaint(c.getUserId());
    }

}




