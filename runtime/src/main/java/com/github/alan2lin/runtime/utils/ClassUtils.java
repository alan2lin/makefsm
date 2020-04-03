

package com.github.alan2lin.runtime.utils;

import java.lang.reflect.*;

/**
 * @Description: TODO
 * @Author: alan2lin
 * @Date: 2020/3/19 19:26
 * @Version V1.0
 */
public class ClassUtils {

   public static <T> T createInstanceOfGenericType(Class clazz){
       return  createInstanceOfGenericType(clazz,0);

   }

   /**
    *  创建泛型类的 参数化类型的 实例，不考虑参数的版本
    * @param clazz
    * @param index
    * @param <T>
    * @return
    */
   public static <T> T createInstanceOfGenericType(Class clazz,int index){
      try{
         TypeVariable[] aa = clazz.getTypeParameters();
         Type superClass = clazz.getGenericSuperclass();
          Type type = ((ParameterizedType) superClass).getActualTypeArguments()[index];
          Class<?> rawClazz = getRawType(type);
          return (T) rawClazz.newInstance();
      }catch (Exception e){
          e.printStackTrace();
      }
      return null;
   }

   // type不能直接实例化对象，通过type获取class的类型，然后实例化对象
   public static Class<?> getRawType(Type type) {
      if (type instanceof Class) {
         return (Class) type;
      } else if (type instanceof ParameterizedType) {
         ParameterizedType parameterizedType = (ParameterizedType) type;
         Type rawType = parameterizedType.getRawType();
         return (Class) rawType;
      } else if (type instanceof GenericArrayType) {
         Type componentType = ((GenericArrayType) type).getGenericComponentType();
         return Array.newInstance(getRawType(componentType), 0).getClass();
      } else if (type instanceof TypeVariable) {
         return Object.class;
      } else if (type instanceof WildcardType) {
         return getRawType(((WildcardType) type).getUpperBounds()[0]);
      } else {
         String className = type == null ? "null" : type.getClass().getName();
         throw new IllegalArgumentException("Expected a Class, ParameterizedType, or GenericArrayType, but <" + type + "> is of type " + className);
      }
   }
}
