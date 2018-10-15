package com.ezhomesixgod.mapper;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author renyang
 * @description
 * @createTime 2018-10-15 11:38
 */
public class ShopMapperXml {
    public static String namespace="";

    public static Map<String,MapperMethod> methodSqlMap =new ConcurrentHashMap<>();

    public static Map<String,String> mappedSql =new ConcurrentHashMap<>();
    static {
        mappedSql.put("findShopById","select name,id,head from tb_shop where id=#{id}");
    }


    public static MapperMethod getMethodSql(String name){
        return methodSqlMap.get(name);
    }
}
