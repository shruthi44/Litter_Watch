package com.aw.complaint.system.business;

import com.aw.complaint.system.repository.ComplaintRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ComplaintService {

    @Autowired
    ComplaintRepository complaintRepository;


    public void process(Complaint complaint) {
        complaintRepository.save(complaint);
    }

    public Complaint trackComplaintById(Long id){
    Optional<Complaint> optionalComplaint=complaintRepository.findById(id);
    if (optionalComplaint.isPresent()){
        return optionalComplaint.get();
    }
         return null;
    }
}
