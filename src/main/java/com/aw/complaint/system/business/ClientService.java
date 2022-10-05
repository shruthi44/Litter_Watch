package com.aw.complaint.system.business;


import com.aw.complaint.system.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientService {

    @Autowired
    ClientRepository clientRepository;

    private Client client;

    public ClientService() {
    }
    public ClientService(Client client) {
        this.client = client;
    }


    public Client getClient() {
        return client;
    }

    public void signUp(Client clientObj) {
        client = clientRepository.save(clientObj);

    }

    public void logIn(String emailID) {
        List<Client> clientList = clientRepository.findByEmailId(emailID);
        if (clientList.size() > 0) {
            client = clientList.get(0);
        }
    }
}
