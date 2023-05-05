package com.cyx.ssm.controller;

import com.cyx.ssm.mapper.EmployeeMapper;
import com.cyx.ssm.pojo.Employee;
import com.cyx.ssm.service.EmployeeService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/*查询所有的员工信息-->/employee-->get
/*获取员工的分页信息-->/employee/page/1-->get
/*根据id查询员工信息-->/employee/1-->get
/*跳转到添加页面-->/employee/to/add-->get
/*添加员工信息-->/employee-->post
/*修改员工信息-->/employee-->put
/*删除员工信息-->/employee/1-->delete
* */
@Controller
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private EmployeeMapper employeeMapper;
    @RequestMapping(value = "/employee/page/{pageNum}", method = RequestMethod.GET)
    public String getEmployeePage(@PathVariable("pageNum") Integer pageNum,Model model){
        //获取员工的分页信息
        PageInfo<Employee> page=employeeService.getEmployeePage(pageNum);
        //将分页数据共享在请求域中
        model.addAttribute("page",page);
        //跳转到employee_list.html
        return "employee_page";
    }

    @RequestMapping(value = "/employee", method = RequestMethod.GET)
    public String getAllEmployee(Model model){
        //查询所有的员工信息
        List<Employee> list = employeeService.getAllEmployee();
        //将员工信息在请求域中共享
        model.addAttribute("list", list);
        //跳转到employee_list.html
        return "employee_list";
    }
    @RequestMapping(value = "/deleteemployee/{empId}", method = RequestMethod.DELETE)
    public String deleteEmployee(@PathVariable("empId") Integer empId){
        System.out.println(empId);
        //删除某个员工信息
        employeeService.deleteEmployee(empId);
        //跳转到employee_list.html
        return "redirect:/employee/page/1";
    }
    @RequestMapping(value = "/updateemployee/{empId}", method = RequestMethod.GET)
    public String updateemployee(@PathVariable("empId") Integer empId,Model model){
        //修改某个员工信息
        Employee employee = employeeService.get(empId);
        //将员工信息在请求域中共享
        model.addAttribute("employee",employee);
        //跳转到employee_update.html
        return "employee_update";
    }
    @RequestMapping(value = "/updatesemployee/{empId}", method = RequestMethod.PUT)
    public String updatesemployee(Employee employee){
        System.out.println(employee);
        employeeService.save(employee);
        return "redirect:/employee/page/1";
    }
    @RequestMapping("/addemployee")
    public String addemployee(Employee employee){
        employeeService.addemployee(employee);
        return "redirect:/employee/page/1";
    }
}
