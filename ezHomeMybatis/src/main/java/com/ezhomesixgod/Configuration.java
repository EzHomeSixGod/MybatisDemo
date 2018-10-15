package com.ezhomesixgod;

import com.ezhomesixgod.excutor.DefaultEzHomeExcutor;
import com.ezhomesixgod.mapper.MapperMethod;
import com.ezhomesixgod.mapper.ShopMapper;
import com.ezhomesixgod.mapper.ShopMapperXml;
import com.ezhomesixgod.proxy.MethodProxy;
import com.ezhomesixgod.util.ClassUtils;

import java.lang.reflect.Method;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import static com.ezhomesixgod.mapper.ShopMapperXml.mappedSql;

/**
 * @author renyang
 * @description
 * @createTime 2018-10-15 15:29
 */
public class Configuration {

    //class --->方法
    public static Map<String,Method> methodMap =new ConcurrentHashMap<>();

    static {



        String resultType="com.ezhomesixgod.entity.Shop";
        String sql = "select name,id,head from tb_shop where id=#{id}";

        mappedSql.put("findShopById",sql);

        Class shopClass = ClassUtils.loadClass(ShopMapper.class.getName());
        try {
            Method[] method =shopClass.getMethods();
            for(Method m : method){
                methodMap.put(m.getName(),m);

                if(mappedSql.containsKey(m.getName())){
                    mappedSql.put(m.getName(),sql);
                }

            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static MapperMethod getSql(String methodName){
        Method method  =  methodMap.get(methodName);
        System.out.println("getSql methodName:"+methodName);
        System.out.println("getSql method:"+method);
        return new MapperMethod(method,mappedSql.get(method.getName()));

    }

}
