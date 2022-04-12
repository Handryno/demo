package com.example.demo;

import com.example.demo.dto.Employee;
import com.example.demo.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class DemoApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public void run(String... args) throws Exception {
        Employee employee = new Employee();
        employee.setFirstName("Handry");
        employee.setLastName("Novianto");
        employee.setEmail("handry@gmail.com");
        employeeRepository.save(employee);

        Employee employee1 = new Employee();
        employee1.setFirstName("Arles");
        employee1.setLastName("Octavianus");
        employee1.setEmail("Arles@gmail.com");
        employeeRepository.save(employee1);
    }
}
