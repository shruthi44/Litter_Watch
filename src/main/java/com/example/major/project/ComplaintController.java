package com.example.major.project;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ComplaintController {

    @Autowired
    Complaint complaint;
    @Autowired
    ComplaintRepository repository;

    @GetMapping("/")
    public String start(Model model){
        model.addAttribute("complaintForm",complaint);
        return "welcome";
    }
   @PostMapping ("/")
public String start1(@RequestParam Complaint complaint,Model model){
        repository.save(complaint);

       // model.addAttribute("trackId",1);
return "welcome";
    }





}

