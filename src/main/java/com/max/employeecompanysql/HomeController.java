package com.max.employeecompanysql;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
public class HomeController {

    @Autowired
    EmployeeRepository employeeRepository;

    @Autowired
    CompanyRepository companyRepository;

    @RequestMapping("/")
    public String index(Model model) {
        //create employee
        Employee employee = new Employee();
        employee.setName("Bill Gates");
        employee.setPosition("CEO");

        //create company
        Company company = new Company();
        company.setName("Microsoft");
        companyRepository.save(company);
        //link company to employee
        employee.setCompany(company);
        employeeRepository.save(employee);

        //pull all employees into model and display "index" template
        model.addAttribute("employees", employeeRepository.findAll());
        return "list";
    }


        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//        @RequestMapping("/")
//        public String listEmployees(Model model){
//            model.addAttribute("employees", employeeRepository.findAll());
//            return "list";
//        }

        @GetMapping("/addCompany")
        public String formCompany(Model model){
            model.addAttribute("company", new Company());
            return "formCompany";
        }

        @PostMapping("/processCompany")
        public String processForm(@Valid Company company, BindingResult result){
            if (result.hasErrors()){
                return "formCompany";
            }
            companyRepository.save(company);
            return "redirect:/";
        }

        @GetMapping("/addEmployee")
        public String formEmployee(Model model){
            model.addAttribute("employee", new Employee());
            model.addAttribute("companies", companyRepository.findAll());
            return "formEmployee";
        }

        @PostMapping("/processEmployee")
        public String processForm(@Valid Employee employee, BindingResult result, @RequestParam("company") Long id){
            if (result.hasErrors()){
                return "formEmployee";
            }
            Company company = companyRepository.findById(id).get();
            employee.setCompany(company);
            employeeRepository.save(employee);
            return "redirect:/";
        }

        @RequestMapping("/detail/{id}")
        public String showEmployee(@PathVariable("id") long id, Model model) {
            model.addAttribute("employee", employeeRepository.findById(id).get());
            return "show";
        }

        @RequestMapping("/update/{id}")
        public String updateEmployee(@PathVariable("id") long id, Model model) {
            model.addAttribute("employee", employeeRepository.findById(id).get());
            return "formEmployee";
        }

        @RequestMapping("/delete/{id}")
        public String delEmployee(@PathVariable("id") long id, Model model) {
            employeeRepository.deleteById(id);
            return "redirect:/";
        }





    }