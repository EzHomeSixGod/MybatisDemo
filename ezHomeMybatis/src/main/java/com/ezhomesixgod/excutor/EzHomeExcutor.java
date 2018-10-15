package com.ezhomesixgod.excutor;

import java.lang.reflect.Method;

/**
 * @author
 * @description
 * @createTime 2018-10-13 13:59
 */
public interface EzHomeExcutor {
    <T> T excutor(String sql,Method method);
}
