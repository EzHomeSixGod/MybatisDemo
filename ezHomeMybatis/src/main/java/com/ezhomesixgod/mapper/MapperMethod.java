package com.ezhomesixgod.mapper;

import com.ezhomesixgod.excutor.DefaultEzHomeExcutor;
import com.ezhomesixgod.excutor.EzHomeExcutor;

import java.lang.reflect.Method;

/**
 * @author renyang
 * @description
 * @createTime 2018-10-15 15:22
 */
public class MapperMethod {

    private Method method;

    private String sql;

    private EzHomeExcutor ezHomeExcutor =new DefaultEzHomeExcutor();

    public Method getMethod() {
        return method;
    }

    public void setMethod(Method method) {
        this.method = method;
    }

    public String getSql() {
        return sql;
    }

    public void setSql(String sql) {
        this.sql = sql;
    }

    public MapperMethod(Method method, String sql){
        this.method =method;
        this.sql =sql;
    }

    public Object excute(Method method,String sql){
        System.out.println("MapperMethod sql:" +sql+";method:"+method);
        return ezHomeExcutor.excutor(sql,method);
    }

}
