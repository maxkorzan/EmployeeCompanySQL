package com.max.employeecompanysql;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.*;

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

        //create "employees" blank set, add employee1, and add the set to company1
        Set<Employee> employees = new HashSet<>();
        employees.add(employee1);
        company1.setEmployees(employees);
        companyRepository.save(company1);

        //define and save "company" for employee1
        employee1.setCompany(company1);
        employeeRepository.save(employee1);

//////////////////////////////////////////////////////////////////////

        Company company = new Company();
        company.setName("Apple");
        Employee employee = new Employee();
        employee.setName("Steve Jobs");
        employee.setPosition("Visionary");

        employees = new HashSet<>();
        employees.add(employee);
        company.setEmployees(employees);
        companyRepository.save(company);

        employee.setCompany(company);
        employeeRepository.save(employee);

//////////////////////////////////////////////////////////////////////

        company = new Company();
        company.setName("Oracle");

        Employee employee3 = new Employee();
        employee3.setName("Jimmy Jones");
        employee3.setPosition("Full-Stack Developer");

        Employee employee4 = new Employee();
        employee4.setName("Kevin Smalls");
        employee4.setPosition("Project Manager");

        employees = new HashSet<>();
        employees.add(employee3);
        employees.add(employee4);

        company.setEmployees(employees);
        companyRepository.save(company);

        employee3.setCompany(company);
        employee4.setCompany(company);
        employeeRepository.save(employee3);
        employeeRepository.save(employee4);


//////////////////////////////////////////////////////////////////////

        company = new Company();
        company.setName("Panasonic");

        employee = new Employee();
        employee.setName("Tommy T-Steak");
        employee.setPosition("QA Tester");

        employees = new HashSet<>();
        employees.add(employee);
        company.setEmployees(employees);
        companyRepository.save(company);

        employee.setCompany(company);
        employeeRepository.save(employee);









//        //link company to employee
////        Set<Employee> employees = new HashSet<>();
//        employees.add(employee2);
//        employees.add(employee3);
//
//        company1.setEmployees(employees);
//        companyRepository.save(company1);
//        employee1.setCompany(company1);
//        employeeRepository.save(employee1);

//        employee1.setCompany(company1);
//        employeeRepository.save(employee1);

//////////////////////////////////////////////////////////////////////////////////////////////////////////
//        employee1 = new Employee();
//        employee1.setName("Captain Hook");
//        employee1.setPosition("Captain");
//        company1 = new Company();
//        company1.setName("Flying Dutchman Inc");
//        employee1.setCompany(company1);
//        Employee employee2 = new Employee();
//        employee2.setName("Smithers");
//        employee2.setPosition("First Mate");
////        company1 = new Company();
////        company1.setName("Flying Dutchman Inc");
//        employee2.setCompany(company1);
//        ArrayList<Employee> employees = new ArrayList<>();
//        Collections.addAll(employees,employee1,employee2);
//        Iterable<Employee> employeesIterable = employees;
//        employeeRepository.saveAll(employeesIterable);

//////////////////////////////////////////////////////////////////////////////////////////////////////////
//        employee1 = new Employee();
//        employee1.setName("Reggie Rocket");
//        employee1.setPosition("Rollerblades");
//        company1 = new Company();
//        company1.setName("Rocket Power");
//        employee1.setCompany(company1);
//        employeeRepository.save(employee1);
//
//        employee1 = new Employee();
//        employee1.setName("Spongebob Squarepants");
//        employee1.setPosition("Fry Cook");
//        company1 = new Company();
//        company1.setName("Krusty Krab");
//        employee1.setCompany(company1);
//        employeeRepository.save(employee1);

    }

}
