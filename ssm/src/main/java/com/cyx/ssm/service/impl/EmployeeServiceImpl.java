package com.cyx.ssm.service.impl;

import com.cyx.ssm.mapper.EmployeeMapper;
import com.cyx.ssm.pojo.Employee;
import com.cyx.ssm.service.EmployeeService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService {
    private static Map<Integer, Employee> employees = null;
    @Autowired
    private EmployeeMapper employeeMapper;

    @Override
    public List<Employee> getAllEmployee() {
        return employeeMapper.getAllEmployee();
    }

    @Override
    public PageInfo<Employee> getEmployeePage(Integer pageNum) {
        //开启分页功能
        PageHelper.startPage(pageNum,5);
        //查询所有的员工信息
        List<Employee> list = employeeMapper.getAllEmployee();
        //获取分页相关数据
        PageInfo<Employee> page=new PageInfo<>(list,5);
        return page;
    }

    @Override
    public void deleteEmployee(Integer empId) {
        /*employees.remove(empId);*/
        employeeMapper.deleteEmployee(empId);
    }
    @Override
    public Employee get(Integer empId) {

        return employeeMapper.get(empId);
    }

    @Override
    public void save(Employee employee) {
        employeeMapper.save(employee);
    }

    @Override
    public void addemployee(Employee employee) {
        employeeMapper.addemployee(employee);
    }

    @Override
    public void updateEmployee(Integer empId) {
        employeeMapper.updateEmployee(empId);
    }




}
