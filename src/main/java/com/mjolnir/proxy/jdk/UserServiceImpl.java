package com.mjolnir.proxy.jdk;

/**
 * @author huangzhibo
 * @date 2018/8/27
 */
public class UserServiceImpl implements UserService {

    @Override
    public String getName(int id) {
        System.out.println("------getName------");
        return "Tom";
    }

    @Override
    public Integer getAge(int id) {
        System.out.println("------getAge------");
        return 12;
    }
}
