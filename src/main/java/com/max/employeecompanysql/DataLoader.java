package com.max.employeecompanysql;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    @Autowired
    EmployeeRepository employeeRepository;

    @Autowired
    CompanyRepository companyRepository;

    @Override
    public void run(String... strings) throws Exception {

        //create company
        Company company1 = new Company();
        company1.setName("Microsoft");

        //create employee
        Employee employee1 = new Employee();
        employee1.setName("Bill Gates");
        employee1.setPosition("CEO");

        //link company to employee
        employee1.setCompany(company1);
        employeeRepository.save(employee1);

//////////////////////////////////////////////////////////////////////////////////////////////////////////
        employee1 = new Employee();
        employee1.setName("Captain Hook");
        employee1.setPosition("Captain");
        company1 = new Company();
        company1.setName("Flying Dutchman Inc");
        employee1.setCompany(company1);
        employeeRepository.save(employee1);
//
//        employee1 = new Employee();
//        employee1.setName("Smithers");
//        employee1.setPosition("First Mate");
////        company1 = new Company();
////        company1.setName("Flying Dutchman Inc");
//        employee1.setCompany(company1);
//        employeeRepository.save(employee1);

//////////////////////////////////////////////////////////////////////////////////////////////////////////
        employee1 = new Employee();
        employee1.setName("Reggie Rocket");
        employee1.setPosition("Rollerblades");
        company1 = new Company();
        company1.setName("Rocket Power");
        employee1.setCompany(company1);
        employeeRepository.save(employee1);

        employee1 = new Employee();
        employee1.setName("Spongebob Squarepants");
        employee1.setPosition("Fry Cook");
        company1 = new Company();
        company1.setName("Krusty Krab");
        employee1.setCompany(company1);
        employeeRepository.save(employee1);

    }

}
