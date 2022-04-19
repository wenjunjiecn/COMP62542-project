package com.uom.cs.studentsystem.controller;

import com.uom.cs.studentsystem.model.Student;
import com.uom.cs.studentsystem.service.AuthService;
import com.uom.cs.studentsystem.utils.ConstantUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

/**
 * @author wenjunjie
 * @version 1.0
 */
@Controller
public class AuthController {
    @Autowired
    private AuthService authService;

    @RequestMapping("/")
    public String getHomePage(Model model, HttpServletRequest request) {
        Student student = (Student) request.getSession().getAttribute(ConstantUtils.USER_SESSION_KEY);
        if (student != null) {
            model.addAttribute("id", student.getId());
            model.addAttribute("name", student.getName());
            model.addAttribute("state", student.getState());
        }
        return "index";
    }

    @GetMapping("/login")
    public String getLoginPage(Model model) {
//        List<Product> listProducts = authService.listAll();
//        model.addAttribute("listProducts", listProducts);

        return "login";
    }

    @PostMapping("/login")
    public String login(@RequestParam(value = "id") String id, Model model, HttpServletRequest request) {
        Student student = authService.login(id);
        if (student == null) {
            model.addAttribute("error", "The id does not exist");
            return "login";
        }
        request.getSession().setAttribute(ConstantUtils.USER_SESSION_KEY, student);
        return "redirect:/";
    }

    @RequestMapping("/logout")
    public String logout(HttpServletRequest request) {
        request.getSession().removeAttribute(ConstantUtils.USER_SESSION_KEY);
        return "redirect:/login";
    }
}
