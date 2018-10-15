package com.ezhomesixgod.excutor;

import com.ezhomesixgod.annotation.EzHomeParam;
import com.ezhomesixgod.connection.ConnectionHolder;
import com.ezhomesixgod.mapper.MapperMethod;
import com.ezhomesixgod.mapper.ShopMapperXml;
import com.ezhomesixgod.util.BeanUtils;
import com.ezhomesixgod.util.ClassUtils;
import com.ezhomesixgod.util.ReflectionUtils;
import com.mysql.jdbc.MySQLConnection;
import com.sun.xml.internal.ws.api.model.MEP;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author
 * @description 默认执行器
 * @createTime 2018-10-13 14:00
 */
public class DefaultEzHomeExcutor implements EzHomeExcutor {



    @Override
    public  <T> T  excutor(String sql,Method method) {

        System.out.println("sql:"+sql);
        //通过method 获取sql
        Parameter[] parameter =method.getParameters();

        for(Parameter p:parameter){
            if(p.isAnnotationPresent(EzHomeParam.class)){
                EzHomeParam ezHomeParam = p.getAnnotation(EzHomeParam.class);
                String paramId  = ezHomeParam.value();
                if(! "".equals(paramId)){
                    System.out.println("paramId:"+paramId);

                }
            }
        }

        System.out.println("---method parameter types:"+method.getParameterTypes());
        String methodName = method.getName();
        Class resultType = method.getReturnType();
        Connection connection =null;
        PreparedStatement preparedStatement =null;
        ResultSet resultSet =null;

        try {
            connection = ConnectionHolder.getConnection();
            preparedStatement =connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();

            resultSet.next();
            Object object = BeanUtils.autoBean(resultType,resultSet);
            return (T) object;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

}
