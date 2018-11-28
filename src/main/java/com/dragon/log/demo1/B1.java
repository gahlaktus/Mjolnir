package com.dragon.log.demo1;

import javassist.ClassPool;
import javassist.CtClass;
import javassist.CtMethod;
import javassist.CtNewMethod;

/**
 * Created by huangzhibo on 25/04/2017.
 */
public class B1 {

    public static void main(String[] args) throws Exception{

        // 用于取得字节码类，必须在当前的classpath中，使用全称
        CtClass ctClass = ClassPool.getDefault().get("A");

        String mname = "method";

        CtMethod ctMethod = ctClass.getDeclaredMethod(mname);

        //
        String nname = mname + "$impl";
        ctMethod.setName(nname);

        CtMethod newMethod = CtNewMethod.copy(ctMethod, mname, ctClass, null);

        StringBuffer newCode = new StringBuffer();
        newCode.append("{\nlong start = System.currentTimeMillis();\n");

        newCode.append(nname+"($$);\n");
        newCode.append("System.out.println(\"Call to method "
                + mname
                + " took \" +\n (System.currentTimeMillis()-start) + "
                + "\" ms.\");\n");
        newCode.append("}");

        newMethod.setBody(newCode.toString());

        ctClass.addMethod(newMethod);

        A a = (A)ctClass.toClass().newInstance();
        a.method();

    }
}
