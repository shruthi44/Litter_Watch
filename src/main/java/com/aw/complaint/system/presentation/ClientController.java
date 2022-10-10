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

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("client_emailId",new Client().getEmailId());
        return "homepage";
    }

    @PostMapping("/")
    public String home(@RequestParam("emailId") String emailId,@RequestParam("emailId") String password,Model model) {
        clientService.logIn(emailId,password);
        //model.addAttribute("client-namePost",name2);
        return "redirect:/complaint-page";
    }

    @GetMapping("/signup")
    public String signUp(Model model) {
        model.addAttribute("client",new Client());
        return "signuppage";
    }

    @PostMapping("/signup")
    public String logIn(@ModelAttribute Client client, Model model) {
        clientService.signUp(client);
        return "redirect:/";
    }



}
