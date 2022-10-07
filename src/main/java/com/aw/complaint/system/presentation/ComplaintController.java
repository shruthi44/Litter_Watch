package com.aw.complaint.system.presentation;

import com.aw.complaint.system.business.ClientService;
import com.aw.complaint.system.business.Complaint;
import com.aw.complaint.system.business.ComplaintService;
import com.aw.complaint.system.business.Status;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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
       //clientService.createComplaint(complaint);
        complaint.setClient(clientService.getClient());
        complaintService.createComplaint(complaint);
        model.addAttribute("trackingId",complaint.getId());
        return "confirm-page";
    }
    @GetMapping("/show")
    public String showComplaintById(@RequestParam (name="trackingId", required = false) Long id, Model model) {
        model.addAttribute("complaint",complaintService.trackComplaintById(id));
        model.addAttribute("client",clientService.getClient());
        model.addAttribute("statusOptions", Status.values());
        return "showcomplain-page";
    }

    @PostMapping("/update")
    public String updateComplaint(@RequestParam Long id,@RequestParam (name="selectedStaus", required = true) String status, Model model) {
        complaintService.updateComplaint(id,status);
        model.addAttribute("trackingId",id);
        return "confirm-page";
    }

   /* @GetMapping("/listcomplaint")
    public String listAllComplaintByClientId(Model model) {
        List<Complaint> listOfComplaint = complaintService.getComplaintByClientId(clientService.getClient().getId());
        model.addAttribute("complaintList",listOfComplaint);
        model.addAttribute("client",clientService.getClient());
        model.addAttribute("statusOptions", Status.values());
        return "showcomplain-page";
    }*/

}

