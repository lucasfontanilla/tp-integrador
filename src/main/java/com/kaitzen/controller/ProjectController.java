package com.kaitzen.controller;

import com.kaitzen.model.Project;
import com.kaitzen.service.ClientService;
import com.kaitzen.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/project")
public class ProjectController {
    @Autowired
    ProjectService projectService;
    @Autowired
    ClientService clientService;

    @GetMapping
    public String index(Model model) {
        List<Project> projects = projectService.findAll();
        model.addAttribute("projects", projects);
        return "/project/index";
    }

    @PostMapping("/new")
    public String create(Model model, @RequestParam("name") String name, @RequestParam("date") Date date, @RequestParam("clientId") Long clientId) {
        model.addAttribute("clients", clientService.findAll());
        model.addAttribute("projects", projectService.findAll());
        return "redirect:/project";
    }

    @PostMapping("/edit")
    public String edit(Model model, @RequestParam("projectId") Long id, @RequestParam("name") String name, @RequestParam("date") Date date, @RequestParam("client") Long clientId) {

        projectService.save(id, name, date, clientId);
        return "redirect:/project";
    }

    @PostMapping("/delete")
    public String delete(Model model, @RequestParam("projectId") Long id) {
        projectService.delete(id);
        model.addAttribute("projects", projectService.findAll());
        return "redirect:/project";
    }

}