package com.aw.complaint.system.business;


import com.aw.complaint.system.repository.ClientRepository;
import com.aw.complaint.system.repository.ComplaintRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.context.annotation.SessionScope;

import java.time.LocalDateTime;
import java.util.List;

@Service
@SessionScope
public class ClientService {
    @Autowired
    ClientRepository clientRepository;

    @Autowired
    ComplaintRepository complaintRepository;

    @Autowired
    ComplaintService complaintService;


    private Client client;
    public ClientService() {
    }
    public ClientService(Client client) {
        this.client = client;
    }
    public Client getClient() {
        return client;
    }
    public void signUp(Client clientInfo) {
        client = clientRepository.save(clientInfo);

    }
    public boolean logIn(String emailID) {
        List<Client> clientList = clientRepository.findByEmailId(emailID);
        if (clientList.size() > 0) {
            client = clientList.get(0);
            return true;
        }
        return false;
    }

    public long createComplaint(Complaint complaint) {
        complaint.setRegisteredDateTime(LocalDateTime.now());
        client.addComplaint(complaint);
        client = clientRepository.save(client);
        return client.getLastComplaint();
    }

   /* public void logOut(String emailID){
    }
*/
}
