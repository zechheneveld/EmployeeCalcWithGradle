package com.zech.EmployeeCalcWithGradle.controllers;

import com.zech.EmployeeCalcWithGradle.data.EmployeeRepository;
import com.zech.EmployeeCalcWithGradle.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
public class BaseController {

    @Autowired
    private EmployeeRepository employeeRepository;

    @RequestMapping("/getAllEmployees")
    public @ResponseBody
    List<Employee> getAllEmployees(){
        return employeeRepository.getAllEmployees();
    }

    @RequestMapping("/get/{id}")
    public @ResponseBody List<Employee> findEmployeeById(@PathVariable String id){
//        Employee foundEmployee = employeeRepository.findEmployeeById(id);
//
//        List<Employee> responseArray = new ArrayList<>();
//        responseArray.add(foundEmployee);
//
//        return responseArray;

        return employeeRepository.findEmployeeById(id);
    }

    @RequestMapping("/get2/{position}")
    public @ResponseBody List<Employee> findEmployeeByPosition(@PathVariable String position){

        return employeeRepository.findEmployeeByPosition(position);
    }

    @RequestMapping(value = "/add/employee", method = RequestMethod.POST)
    public @ResponseBody Employee postEmployee(@RequestBody Map<String, Object> payload){

//        return employeeRepository.addEmployee({
//                String.valueOf(payload.get("id")),
//                String.valueOf(payload.get("firstName")),
//                String.valueOf(payload.get("lastName")),
//                String.valueOf(payload.get("salary")),
//                String.valueOf(payload.get("position"))
//
//        });

        String newId = String.valueOf(payload.get("id"));
        String newFName = String.valueOf(payload.get("firstName"));
        String newLName = String.valueOf(payload.get("lastName"));
        String newSalary = String.valueOf(payload.get("salary"));
        String newPosition = String.valueOf(payload.get("position"));

        Employee newEmployee = new Employee(newId, newFName, newLName, newSalary, newPosition);

        employeeRepository.addEmployee(newEmployee);

        return newEmployee;
    }

    @RequestMapping("/")
    public String baseRoute(){
        return "index";
    }
}
