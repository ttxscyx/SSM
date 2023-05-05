package com.cyx.ssm.mapper;

import com.cyx.ssm.pojo.Employee;

import java.util.List;

public interface EmployeeMapper {

    /*
     * 查询所有的员工信息
     */
    List<Employee> getAllEmployee();

    void deleteEmployee(Integer empId);

    Employee get(Integer empId);

    void updateEmployee(Integer empId);

    void save(Employee employee);

    void addemployee(Employee employee);
}
