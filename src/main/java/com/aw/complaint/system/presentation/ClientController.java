package com.aw.complaint.system.presentation;

import com.aw.complaint.system.business.Client;
import com.aw.complaint.system.business.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ClientController {

    @Autowired
    ClientService clientService;

    @GetMapping("/login")
    public String home(Model model) {
        Client client_login = new Client();
        model.addAttribute("client_emailId",client_login.getEmailId());
        model.addAttribute("client_isAdmin",client_login.isAdmin());
        return "homepage";
    }

    @PostMapping("/login")
    public String home(@RequestParam("emailId") String emailId,Model model) {

        if(clientService.logIn(emailId)){
            return "redirect:/complaint";
        }else {
            return "redirect:/login";
        }
        //model.addAttribute("client-namePost",name2);
    }

    @GetMapping("/signup")
    public String signUp(Model model) {
        model.addAttribute("client",new Client());
        return "signuppage";
    }

    @PostMapping("/signup")
    public String logIn(@ModelAttribute Client client, Model model) {
        clientService.signUp(client);
        return "redirect:/login";
    }



}
