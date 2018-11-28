package com.dragon;

import javassist.*;

import java.io.IOException;

/**
 * @author huangzhibo
 * @date 17/08/2017
 */
public class JCracker {

    public static void main(String[] args) throws NotFoundException, CannotCompileException, IOException{

        ClassPool pool = ClassPool.getDefault();

        pool.insertClassPath("/Users/huangzhibo/Desktop/jprofiler");

        CtClass cc = pool.get("com.ejt.framework.e.c");

        CtClass[] param = new CtClass[3];
        param[0] = pool.get("java.lang.String");
        param[1] = pool.get("java.lang.String");
        param[2] = pool.get("java.lang.String");

        assert cc != null;
        CtMethod method = cc.getDeclaredMethod("a", param);

        assert method != null;
        method.setBody("{return 1;}");

        cc.writeFile("/Users/huangzhibo/Desktop/modified");
    }

}
