package com.cyx.mybatis.mapper;

import com.cyx.mybatis.pojo.User;
import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface SelectMapper {
/*根据id查询用户信息*/
    User getUserById(@Param("id") Integer id);
/*查询所有的用户信息*/
    List<User> getAllUser();
/*查询用户的总数量*/
    Integer getCount();
/*根据id查询用户信息为map集合*/
    Map<String,Object> getUserByIdtoMap(@Param("id") Integer id);
/*查询所有的用户信息为map集合
* 若查询的数据有多条时，并且要将每条数据转换为map集合
* 此时有两种解决方案：
* 1、将mappper接口方法的返回值设置为泛型是map的list集合
* List<Map<String,Object>> getAllUserToMap();
* 最终结果：{password=123456, gender=男, id=4, age=18, email=12345@qq.com, username=admin}
* 2、可以将每条数据转换的map集合放在一个大的map，但是必须要通过@MapKey注解
* 将查询的某个字段的值作为大的map的键
*  @MapKey("id")
    Map<String,Object> getAllUserToMap();
* */

    //List<Map<String,Object>> getAllUserToMap();
    @MapKey("id")
    Map<String,Object> getAllUserToMap();
}
