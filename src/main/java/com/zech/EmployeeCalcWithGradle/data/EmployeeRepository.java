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

//    public List<Employee> findEmployeeById(String id){
//        List<Employee> foundEmployees = new ArrayList<>();
//        for(Employee kittyFoo : employeeList){
//            if (kittyFoo.getId().equalsIgnoreCase(id)){
//                foundEmployees.add(kittyFoo);
//                return foundEmployees;
//            }
//        }
//        return foundEmployees;
    public List<Employee> findEmployeeById(String id) {

        List<Employee> employeeId = new ArrayList<>();

        for (Employee kittyFoo : employeeList) {
            if (kittyFoo.getId().equalsIgnoreCase(id)) {
                employeeId.add(kittyFoo);
            }
        }
        return employeeId;
    }

    public List<Employee> findEmployeeByPosition(String position){

        List<Employee> employeePosition = new ArrayList<>();

        for(Employee kittyPoo : employeeList){
            if(kittyPoo.getPosition().equalsIgnoreCase(position)){
                employeePosition.add(kittyPoo);
            }
        }

        return employeePosition;

    }
}
