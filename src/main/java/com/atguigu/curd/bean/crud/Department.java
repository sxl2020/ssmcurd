package com.atguigu.curd.bean.crud;

public class Department {
    private Integer deptId;

    private String deptName;

    public Department(){
        super();
    }
    public Department(String deptName){
        this.deptName = deptName;
    }
    public Department(int id,String deptName){
        this.deptId = id;
        this.deptName = deptName;
    }

    public Integer getDeptId() {
        return deptId;
    }

    public void setDeptId(Integer deptId) {
        this.deptId = deptId;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName == null ? null : deptName.trim();
    }
}