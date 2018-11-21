package com.kaitzen.controller;

import com.kaitzen.model.Client;
import com.kaitzen.model.Employee;
import com.kaitzen.service.ClientService;
import com.kaitzen.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @GetMapping
    public String index(Model model){
        List<Employee> employees = employeeService.findAll();
        model.addAttribute("employees", employees);

        return "/employee/index";
//    }
//    @PostMapping("/new")
//    public String create(@RequestParam(value = "clientName") String name){
//        clientService.create(name);
//        return "redirect:/client";
//    }
//
//
//    @PostMapping("/edit")
//    public String edit(@RequestParam(value = "clientId") Long id, @RequestParam(value = "clientName") String name) {
//        clientService.save(id, name);
//        return "redirect:/client";
//
//    }
//
//    @PostMapping("/delete")
//    public String delete(@RequestParam(value = "clientId") Long id){
//        clientService.delete(id);
//        return "redirect:/client";
    }
}
