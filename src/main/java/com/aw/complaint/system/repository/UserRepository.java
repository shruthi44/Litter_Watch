package com.aw.complaint.system.repository;

import com.aw.complaint.system.business.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<Client, Long> {

    @Query("select u from Client u where u.userName = ?1")
    List<Client> findByUserName(String name);
}
