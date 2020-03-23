
package com.alan2lin.runtime.intf;

/**
 * @Description: 事件枚举类的统一接口
 * @Author: alan2lin
 * @Date: 2020/3/20 17:29
 * @Version V1.0
 */
public interface  EnumInterface<T extends Enum<?>> {

    public String getName();
    public String getValue();

    public static <T extends Enum<?>> T getFromTypeName(String name,Class<T> clazz){
        if (!clazz.isEnum()) {
            return null;
        }
        try {
            T[] enumConstants = clazz.getEnumConstants();
            for (T ec : enumConstants) {
                if (((Enum<?>) ec).name().equals(name)) {
                    return ec;
                }
            }
            return null;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
