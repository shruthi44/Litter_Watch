package com.aw.complaint.system.business;

import com.aw.complaint.system.repository.ComplaintRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class ComplaintService {

    @Autowired
    ComplaintRepository complaintRepository;



    public Complaint trackComplaintById(Long id){
    Optional<Complaint> optionalComplaint=complaintRepository.findById(id);
    if (optionalComplaint.isPresent()){
        return optionalComplaint.get();
    }
         return null;
    }

    public void createComplaint(Complaint complaint) {
        complaint.setRegisteredDateTime(LocalDateTime.now());
        complaintRepository.save(complaint);
    }
    public void updateComplaint(Long id,String status) {
        Complaint complaint = trackComplaintById(id);
        complaint.setStatus(Status.valueOf(status));
        complaintRepository.save(complaint);
    }

   /* public List<Complaint> getComplaintByClientId(Long clientId){
        return complaintRepository.findAllByClientId(clientId);
    }*/
}
