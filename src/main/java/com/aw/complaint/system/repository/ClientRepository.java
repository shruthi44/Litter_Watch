package com.aw.complaint.system.repository;

import com.aw.complaint.system.business.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {

    @Query("select c from Client c where c.emailId = ?1")
    List<Client> findByEmailId(String emailID);

    @Query("select c from Client c where c.password = ?1")
    List<Client> findClientByPassword(String password);

    List<Client> findByEmailIdAndPassword(String emailId,String password);

}
