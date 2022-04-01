package com.uom.cs.studentsystem.controller;

import com.uom.cs.studentsystem.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author wenjunjie
 * @version 1.0
 */
@Controller
public class AuthController {
    @Autowired
    private AuthService authService;

    @RequestMapping("/")
    public String viewHomePage(Model model) {
//        List<Product> listProducts = authService.listAll();
//        model.addAttribute("listProducts", listProducts);

        return "index";
    }

    @RequestMapping("/login")
    public String login(Model model) {
//        List<Product> listProducts = authService.listAll();
//        model.addAttribute("listProducts", listProducts);

        return "login";
    }
}
