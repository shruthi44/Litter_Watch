package com.aw.complaint.system.repository;

import com.aw.complaint.system.business.Complaint;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ComplaintRepository extends JpaRepository<Complaint,Long> {
    @Query(value="select * from complaint join client on client.id= complaint.client_id where client.email_id = ?1",nativeQuery = true)
    List<Complaint> findAllByClientNativeQuery(String emailId);

   // List<Complaint> findAllComplaintsByEmailId();




    //Complaint findById();
}
