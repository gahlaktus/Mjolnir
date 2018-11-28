package com.dragon.spring.security;

import org.springframework.dao.DataAccessException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by huangzhibo on 27/03/2017.
 */
public class MyUserDetailService implements UserDetailsService{

    //登陆验证时，通过username获取用户的所有权限信息，
    //并返回User放到spring的全局缓存SecurityContextHolder中，以供授权器使用
    @Override
    public UserDetails loadUserByUsername(String username)
            throws UsernameNotFoundException, DataAccessException {
        Collection<GrantedAuthority> auths=new ArrayList<GrantedAuthority>();

        SimpleGrantedAuthority auth2=new SimpleGrantedAuthority("ROLE_ADMIN");
        SimpleGrantedAuthority auth1=new SimpleGrantedAuthority("ROLE_USER");

        if(username.equals("lcy")){
            auths=new ArrayList<GrantedAuthority>();
            auths.add(auth1);
            auths.add(auth2);
        }

        User user = new User(username, "lcy", true, true, true, true, auths);
        return user;
    }
    /**
     * 通过MyUserDetailService拿到用户信息后，authenticationManager对比用户的密码（即验证用户），
     * 然后这个AuthenticationProcessingFilter拦截器就过咯。
     */
}
