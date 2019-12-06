package com.atguigu.curd.service;

import com.atguigu.curd.bean.crud.Employee;
import com.atguigu.curd.bean.crud.EmployeeExample;
import com.atguigu.curd.bean.Msg;
import com.atguigu.curd.dao.EmployeeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class EmployeeService {

    @Autowired
    EmployeeMapper employeeMapper;

    /*
     * 根据id查询员工信息
     * */
    public Employee getEmp(int id){
        Employee emp = employeeMapper.selectByPrimaryKey(id);
        return emp;
    }

    /**
     * 查询所有员工
     * */
    public List<Employee> getAll(){
        return employeeMapper.selectByExampleWithDept(null);
    }

    public Msg saveEmp(Employee employee){
        employeeMapper.insertSelective(employee);
        return Msg.success();
    }

    /**
     * 员工更新
     * @param employee
     */
    public void updateEmp(Employee employee) {
        // TODO Auto-generated method stub
        employeeMapper.updateByPrimaryKeySelective(employee);
    }

    /*
    * 员工删除
    * @param id
    * */
    public void deleteEmp(Integer id){
        employeeMapper.deleteByPrimaryKey(id);
    }

    /*
    * 批量删除员工
    * @Parma del_ids
    * */
    public void deleteBatch(List<Integer> del_ids){
        EmployeeExample example = new EmployeeExample();
        EmployeeExample.Criteria criteria = example.createCriteria();
        criteria.andEmpIdIn(del_ids);
        employeeMapper.deleteByExample(example);
    }

    /*
    * 检查用户名是否可用
    * */
    public boolean checkUser(String empName){
        EmployeeExample example = new EmployeeExample();
        EmployeeExample.Criteria criteria = example.createCriteria();
        criteria.andEmpNameEqualTo(empName);
        long count = employeeMapper.countByExample(example);
        return count ==0;
    }
}
