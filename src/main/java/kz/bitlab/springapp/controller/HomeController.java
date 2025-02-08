package kz.bitlab.springapp.controller;

import kz.bitlab.springapp.db.DBManager;
import kz.bitlab.springapp.model.Student;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class HomeController {

    @GetMapping("/")
    public String getAllStudents(Model model) {
        model.addAttribute("students", DBManager.getAllStudents());
        return "index";
    }

    @GetMapping("/add-student")
    public String showAddStudentForm(Model model) {
        model.addAttribute("student", new Student());
        return "add-student";
    }

    @PostMapping("/add-student")
    public String addStudent(@ModelAttribute Student student) {
        DBManager.addStudent(student);
        return "redirect:/";
    }
}
