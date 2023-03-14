package com.tool.soat.common.util;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @Description:
 * @Author: 凡子
 * @CreateTime: 2022/8/23 22:50
 * @File: AutoIncKey
 * @Software: IntelliJIDEA
 */

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface AutoIncKey {
}
