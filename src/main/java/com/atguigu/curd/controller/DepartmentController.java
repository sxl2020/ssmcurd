package com.atguigu.curd.controller;

import com.atguigu.curd.bean.crud.Department;
import com.atguigu.curd.bean.Msg;
import com.atguigu.curd.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class DepartmentController {

    @Autowired
    DepartmentService departmentService;

    /*
    * @RequestBody的作用其实是将json格式的数据转为java对象
    * */
    @RequestMapping("/depts")
    @ResponseBody
    public Msg getDepts(){
        List<Department> list = departmentService.getDepts();

        return Msg.success().add("depts",list);
    }
}
