package com.zech.EmployeeCalcWithGradle.data;

import com.zech.EmployeeCalcWithGradle.model.Employee;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class EmployeeRepository {

    private List<Employee> employeeList = new ArrayList<>();

    public List<Employee> getAllEmployees(){
        return employeeList;
    }

    public void addEmployee(Employee employee){
        employeeList.add(employee);
    }

    public Employee findEmployeeById(String id){
        for(Employee kittyFoo : employeeList){
            if (kittyFoo.getId().equalsIgnoreCase(id)){
                return kittyFoo;
            }
        }
        return null;
    }

    public Employee findEmployeeByPosition(String position){

        //Create a List
        //In the loop, add to the list
        //Return the list

        for(Employee kittyPoo : employeeList){
            if (kittyPoo.getPosition().equalsIgnoreCase(position)){
                return kittyPoo;
            }
        }
        return null;
    }
}
