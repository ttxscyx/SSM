package com.cyx.ssm.service;

import com.cyx.ssm.pojo.Employee;
import com.github.pagehelper.PageInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface EmployeeService {
//查询所有员工信息
    List<Employee> getAllEmployee();
//获取员工的分页信息
    PageInfo<Employee> getEmployeePage(Integer pageNum);

    void deleteEmployee(Integer empId);

    void updateEmployee(Integer empId);

    Employee get(Integer empId);

    void save(Employee employee);

    void addemployee(Employee employee);
}
