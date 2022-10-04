package com.aw.complaint.system.business;


import com.aw.complaint.system.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    Client client;

    public UserService() {
    }
    public UserService(Client client) {
        this.client = client;
    }


    public Client getUser() {
        return client;
    }

    public void signUp(Client client) {
        client =userRepository.save(client);

    }

    public void logIn(String name) {
        List<Client> clientList = userRepository.findByUserName(name);
        if (clientList.size() > 0) {
            client = clientList.get(0);
        }
    }
}
