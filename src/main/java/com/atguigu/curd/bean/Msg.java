package com.atguigu.curd.bean;

import java.util.HashMap;
import java.util.Map;

public class Msg {
    //状态码 100成功;200失败
    private int code;
    //提示信息
    private String msg;

    // 返回给客户端的信息
    private Map<String,Object> extend = new HashMap<>();

    public static Msg success(){
        Msg result = new Msg();
        result.setCode(100);
        result.setMsg("处理成功！");
        return  result;
    }

    public static Msg fail(){
        Msg result = new Msg();
        result.setCode(200);
        result.setMsg("处理失败！");
        return  result;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Msg add(String key,Object value){
        this.getExtend().put(key,value);
        return this;
    }

    public Map<String, Object> getExtend() {
        return extend;
    }

    public void setExtend(Map<String, Object> extend) {
        this.extend = extend;
    }
}
