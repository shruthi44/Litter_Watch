package com.aw.complaint.system.presentation;

import com.aw.complaint.system.business.Complaint;
import com.aw.complaint.system.business.ComplaintService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ComplaintController {


    @Autowired
    ComplaintService complaintService;

    @GetMapping("/")
    public String getComplaintPage() {
        return "complaint-page";
    }

    @PostMapping("/")
    public String createComplaint(@RequestParam String place ,@RequestParam String description,Model model) {
       Complaint complaint = new Complaint(place,description);
       complaintService.process(complaint);
        
        model.addAttribute("trackingId",complaint.getId());
        return "confirm-page";
    }


}

