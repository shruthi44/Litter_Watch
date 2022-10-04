package com.aw.complaint.system.presentation;

import com.aw.complaint.system.business.Complaint;
import com.aw.complaint.system.business.ComplaintService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ComplaintController {


    @Autowired
    ComplaintService complaintService;

    @GetMapping("/")
    public String getComplaintPage(Model model) {
        model.addAttribute("complaint",new Complaint());
        return "complaint-page";
    }

    @PostMapping("/create")
    public String createComplaint(@ModelAttribute Complaint complaint, Model model) {
       complaintService.process(complaint);

        model.addAttribute("trackingId",complaint.getId());
        return "confirm-page";
    }

}

