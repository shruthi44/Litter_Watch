package com.aw.complaint.system.presentation;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SiteController {

    @GetMapping("/about-us")
    public String aboutUs() {
        return "about-us";
    }

    @GetMapping("/articles")
    public String articles() {
        return "articles";
    }

    @GetMapping("/sitemap")
    public String sitemap() {
        return "sitemap";
    }

    @GetMapping("/testpage")
    public String testpage() {
        return "testpage";
    }

    @GetMapping("/")
    public String homepage() {
        return "homepage";
    }
}
