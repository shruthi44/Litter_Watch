package com.aw.complaint.system.presentation;

import com.aw.complaint.system.business.ClientService;
import com.aw.complaint.system.business.Complaint;
import com.aw.complaint.system.business.ComplaintService;
import com.aw.complaint.system.repository.ComplaintRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class ComplaintController {
    @Autowired
    ComplaintService complaintService;
    @Autowired
    ClientService clientService;

    @GetMapping("/complaint")
    public String getComplaintPage(Model model) {
        model.addAttribute("complaint",new Complaint());
        return "complaint-page";
    }
    @PostMapping("/create")
    public String createComplaint(@ModelAttribute Complaint complaint, Model model) {
        long trackingId= clientService.createComplaint(complaint);
        model.addAttribute("trackingId",trackingId);
        return "confirm-page";
    }
    @GetMapping("/show")
    public String showComplaintById(@RequestParam (name="trackingId") Long id, Model model) {
        model.addAttribute("complain",complaintService.trackComplaintById(id));
        return "showcomplain-page";
    }
    @GetMapping("/view")
    public String viewComplaints(Model model){
        List<Complaint> complaintList =complaintService.viewComplaints(clientService.getClient().getEmailId());
        model.addAttribute("viewcomplaints",complaintList);
        return "view-client-complaints";
    }

    @GetMapping("/viewall")
    public String viewAllComplaints(Model model){
        List<Complaint> allComplaintList =complaintService.viewAllComplaints();
        model.addAttribute("viewallcomplaints",allComplaintList);
        return "view-all-complaints";
    }


}

