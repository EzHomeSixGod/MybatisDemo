package com.ezhomesixgod.dao;

import com.ezhomesixgod.Configuration;
import com.ezhomesixgod.excutor.EzHomeExcutor;
import com.ezhomesixgod.mapper.MapperMethod;

/**
 * @author renyang
 * @description
 * @createTime 2018-10-15 16:19
 */
public interface EzHomeSqlSession {
    <T> T getMapper(Class<?> clazz);
}
