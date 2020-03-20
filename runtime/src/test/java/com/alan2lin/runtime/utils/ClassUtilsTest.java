package com.alan2lin.runtime.utils;

import org.junit.Assert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @Description: TODO
 * @Author: alan2lin
 * @Date: 2020/3/20 10:15
 * @Version V1.0
 */
class ClassUtilsTest {


    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void createInstanceOfGenericType() {

        UtilA<Long> utilA = new UtilA<>();
        Long dynamic = (Long) ClassUtils.createInstanceOfGenericType(utilA.getClass());
        utilA.setDynamicInstace(dynamic);

        Assert.assertEquals(dynamic.longValue(),0);;

    }
}
