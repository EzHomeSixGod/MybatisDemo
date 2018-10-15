package com.ezhomesixgod.proxy;

import com.ezhomesixgod.Configuration;
import com.ezhomesixgod.dao.DefaultEzHomeSqlSession;
import com.ezhomesixgod.dao.EzHomeSqlSession;
import com.ezhomesixgod.excutor.DefaultEzHomeExcutor;
import com.ezhomesixgod.excutor.EzHomeExcutor;
import com.ezhomesixgod.mapper.MapperMethod;
import com.ezhomesixgod.mapper.ShopMapper;
import com.ezhomesixgod.mapper.ShopMapperXml;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author
 * @description
 * @createTime 2018-10-15 15:16
 */
public class MethodProxy implements InvocationHandler {

    private EzHomeSqlSession ezHomeSqlSession;

    public  MethodProxy(EzHomeSqlSession ezHomeSqlSession) {
        this.ezHomeSqlSession = ezHomeSqlSession;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if(Object.class.equals(method.getDeclaringClass())){
            method.invoke(this,args);
        }else{
            System.out.println("method name:"+method.getName());
            MapperMethod mapperMethod = Configuration.getSql(method.getName());
            System.out.println("----:"+mapperMethod);
            return mapperMethod.excute(method,mapperMethod.getSql());
        }
       return null;
    }
}
