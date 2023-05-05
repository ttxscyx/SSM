package com.cyx.mybatis.mapper;

import com.cyx.mybatis.pojo.Emp;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface DynamicSQLMapper {
/*多条件查询*/
    List<Emp> getEmpBycondition(Emp emp);
/*测试choose、when、otherwise*/
    List<Emp> getEmpByChoose(Emp emp);
/*批量添加员工信息*/
    void insertMoreEmp(@Param("emps") List<Emp> emps);
/*批量删除员工信息*/
    void deletMoreEmp(@Param("empIds") Integer[] empIds);
}
