package com.aw.complaint.system;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ComplaintController {


    @Autowired
    ComplaintRepository repository;

    @GetMapping("/")
    public String getComplaintPage() {
        return "complaint-page";
    }

    @PostMapping("/")
    public String createComplaint(@RequestParam String place ,@RequestParam String description,Model model) {
        Complaint complaint = new Complaint(place,description);
        repository.save(complaint);
        System.out.println("Complaint id"+complaint.getId());

        model.addAttribute("trackingId",complaint.getId());
        return "confirm-page";
    }


}

