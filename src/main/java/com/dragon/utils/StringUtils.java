package com.dragon.utils;

import java.lang.reflect.Field;

/**
 * Created by huangzhibo on 17/04/2017.
 */
public class StringUtils {
    public static void main(String[] args) {
        DisposalApplyInfo info = new DisposalApplyInfo();
        Field[] fields = info.getClass().getDeclaredFields();
        for (int i = 0; i < fields.length; i++) {
            //System.out.print("成员变量" + i + "类型 : " + fields[i].getType().getName());
            //System.out.print("\t成员变量" + i + "变量名: " + fields[i].getName() + "\t");

            //System.out.print("#" + fields[i].getName() + "#,");
//            System.out.println("\""+fields[i].getName()+"\""+":"+fields[i].getName()+",");
//            System.out.println("\""+fields[i].getName()+"\""+":"+"$(\"#"+fields[i].getName()+"\")"+".val()"+",");

            //System.out.print("cldi."+fields[i].getName().toUpperCase()+",");


        }
        //System.out.println(info.getClass().getCanonicalName());

        IOWarehouseHistory vetDetail = new IOWarehouseHistory();
        Field[] declaredFields = vetDetail.getClass().getDeclaredFields();
        for (int i = 0; i < declaredFields.length; i++) {
            System.out.print(declaredFields[i].getName().toUpperCase()+",");
            //System.out.print("#" + declaredFields[i].getName() + "#,");
        }
    }

}
