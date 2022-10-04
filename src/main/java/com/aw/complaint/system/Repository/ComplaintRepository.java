package com.aw.complaint.system.Repository;

import com.aw.complaint.system.Business.Complaint;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ComplaintRepository extends JpaRepository<Complaint,Long> {
}
