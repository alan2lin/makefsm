
package com.alan2lin.runtime.intf;

/**
 * @Description: TODO
 * @Author: alan2lin
 * @Date: 2020/3/20 17:29
 * @Version V1.0
 */
public interface  EnumInterface<T extends Enum<?>> {

    public String getText();

    public static <T extends Enum<?>> T getFromTypeName(String text,Class<T> clazz){
        if (!clazz.isEnum()) {
            return null;
        }
        try {
            T[] enumConstants = clazz.getEnumConstants();
            for (T ec : enumConstants) {
                if (((Enum<?>) ec).name().equals(text)) {
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
