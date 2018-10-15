package com.ezhomesixgod.dao;

import com.ezhomesixgod.excutor.DefaultEzHomeExcutor;
import com.ezhomesixgod.excutor.EzHomeExcutor;
import com.ezhomesixgod.proxy.MethodProxy;

import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author renyang
 * @description
 * @createTime 2018-10-15 16:26
 */
public class DefaultEzHomeSqlSession implements EzHomeSqlSession {

    @Override
    public <T> T getMapper(Class<?> mapperInterface) {
        ClassLoader classLoader = mapperInterface.getClassLoader();
        Class<?>[] interfaces = new Class[]{mapperInterface};

        return (T) Proxy.newProxyInstance(classLoader,interfaces,new MethodProxy(this));
    }
}
