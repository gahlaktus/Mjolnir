//package com.reflect;
//
//import java.lang.reflect.Field;
//import java.lang.reflect.Method;
//import java.lang.reflect.ParameterizedType;
//import java.lang.reflect.Type;
//import java.util.ArrayList;
//import java.util.List;
//
///**
// * @author huangzhibo
// * @date 01/07/2017
// */
//public class ReflectDemo1 {
//
//    public static void main(String[] args) {
//        ADTO adto = new ADTO();
//        List<EoGirlFriendDTO> eoGirlFriendDTOS = new ArrayList<>();
//        eoGirlFriendDTOS.add(new EoGirlFriendDTO());
//        eoGirlFriendDTOS.add(new EoGirlFriendDTO());
//        adto.setEoGirlFriends(eoGirlFriendDTOS);
//        iterateClass(adto);
//    }
//
//    private static void iterateClass(Object object) {
//
//        String objName = object.getClass().getSimpleName();
//        Field[] fields = object.getClass().getDeclaredFields();
//        List<String> methodNameList = new ArrayList<String>();
//        Method[] allMethods = object.getClass().getMethods();
//
//        for (Method method : allMethods) {
//            methodNameList.add(method.getName());
//        }
//
//        for (Field field : fields) {
//            String fieldName = field.getName();
//            String methodName = field.getName().substring(0, 1).toUpperCase() + field.getName().substring(1);
//            Method m;
//            String typeName = field.getType().getSimpleName();
//            System.out.println(typeName);
//            try {
//                String getMethod = "get" + methodName;
//                if (methodNameList.contains(getMethod)) {
//                    m = object.getClass().getMethod(getMethod);
//                    Object value = m.invoke(object);
//                    if (typeName.equalsIgnoreCase("list")){
//                        Type gType = field.getGenericType();
//                        ParameterizedType pType = (ParameterizedType)gType;
//                        System.out.println(pType.getActualTypeArguments()[0]);
//                        iterateClass(pType.getActualTypeArguments()[0]);
////                        for (Object object : value){
////
////                        }
//                    }
//                    boolean chainFlag = (fieldName.toUpperCase().contains("DTO")) && null != value;
//                    if (chainFlag) {
//                        iterateClass(value);
//                    }
//                }
//            }catch (Exception e){
//                e.printStackTrace();
//            }
//        }
//    }
//}
