package com.infinitelambda.demo;

import com.infinitelambda.demo.entity.Employee;
import com.infinitelambda.demo.repository.EmployeeRepo;
import java.util.Optional;

import com.infinitelambda.demo.service.impl.EmployeePaymentServiceImpl;
import com.infinitelambda.demo.service.impl.EmployeeServiceImpl;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner {

    private final EmployeeRepo employeeRepo;

    private final EmployeeServiceImpl EmployeeServiceImpl;

    private final EmployeePaymentServiceImpl EmployeePaymentServiceImpl;

    public DemoApplication(EmployeeRepo employeeRepo, EmployeeServiceImpl EmployeeServiceImpl, EmployeePaymentServiceImpl EmployeePaymentServiceImpl) {
        this.employeeRepo = employeeRepo;
        this.EmployeeServiceImpl = EmployeeServiceImpl;
        this.EmployeePaymentServiceImpl = EmployeePaymentServiceImpl;
    }

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        EmployeeServiceImpl.createEmployee("Employee 1");
        EmployeeServiceImpl.createEmployee("Employee 2");
        EmployeeServiceImpl.findAllEmployee();
        EmployeeServiceImpl.updateEmployee(2L, "Assia");
        EmployeeServiceImpl.findAllEmployee();
        EmployeeServiceImpl.removeEmployee(2L);
        EmployeeServiceImpl.findAllEmployee();
        EmployeeServiceImpl.createEmployee("Raya");
        EmployeeServiceImpl.updateEmployee(3L, "Employee 3");
        EmployeeServiceImpl.createEmployee("Employee 4");
        EmployeeServiceImpl.findAllEmployee();
        EmployeeServiceImpl.removeEmployee(4L);
        EmployeeServiceImpl.findAllEmployee();
        EmployeeServiceImpl.removeEmployee(4L);
        EmployeePaymentServiceImpl.updateEmployeeSalary(1L, 1000L);
        EmployeePaymentServiceImpl.updateEmployeeSalary(3L, 2000L);
        EmployeePaymentServiceImpl.findAllEmployeeSalaries();
        EmployeePaymentServiceImpl.sumAllEmployeeSalaries();
    }
}
