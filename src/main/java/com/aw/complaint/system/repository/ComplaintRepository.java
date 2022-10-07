package com.aw.complaint.system.repository;

import com.aw.complaint.system.business.Complaint;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ComplaintRepository extends JpaRepository<Complaint,Long> {
    List<Complaint> findAllByClientId(Long clientId);

    //Complaint findById();
}
