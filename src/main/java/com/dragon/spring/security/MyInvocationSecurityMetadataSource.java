package com.dragon.spring.security;

import com.dragon.spring.security.tool.AntUrlPathMatcher;
import com.dragon.spring.security.tool.UrlMatcher;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;

import java.util.*;

/**
 * Created by huangzhibo on 27/03/2017.
 */
public class MyInvocationSecurityMetadataSource implements FilterInvocationSecurityMetadataSource{

    private UrlMatcher urlMatcher = new AntUrlPathMatcher();
    private static Map<String, Collection<ConfigAttribute>> resourceMap = null;

    //tomcat启动时实例化一次
    public MyInvocationSecurityMetadataSource() {
        loadResourceDefine();
    }
    //tomcat开启时加载一次，加载所有url和权限（或角色）的对应关系

    /**
     * 其中loadResourceDefine方法不是必须的，这个只是加载所有的资源与权限的对应关系并缓存起来，
     * 避免每次获取权限都访问数据库（提高性能），然后getAttributes根据参数（被拦截url）返回权限集合。
     *
     * 这种缓存的实现其实有一个缺点，因为loadResourceDefine方法是放在构造器上调用的，
     * 而这个类的实例化只在web服务器启动时调用一次，那就是说loadResourceDefine方法只会调用一次，
     * 如果资源和权限的对应关系在启动后发生了改变，那么缓存起来的就是脏数据.
     */
    private void loadResourceDefine() {
        //这里面也可以，写一个数据库链接，查询sql，自行打开session。
        // 在启动时候，那个dao可能都还没加载，所以这里需要读者自己写sessionFactory，自己写hql或sql
        resourceMap = new HashMap<String, Collection<ConfigAttribute>>();
        Collection<ConfigAttribute> atts = new ArrayList<ConfigAttribute>();
        ConfigAttribute ca = new SecurityConfig("ROLE_USER");
        atts.add(ca);
        resourceMap.put("/index.jsp", atts);
        Collection<ConfigAttribute> attsno =new ArrayList<ConfigAttribute>();
        ConfigAttribute cano = new SecurityConfig("ROLE_NO");
        attsno.add(cano);
        resourceMap.put("/other.jsp", attsno);
    }

    //参数是要访问的url，返回这个url对于的所有权限（或角色）
    @Override
    public Collection<ConfigAttribute> getAttributes(Object object) throws IllegalArgumentException {
        /**
         * 允许资源和权限的对应关系改变
         * 就不需要loadResourceDefine方法了
         * 直接在getAttributes方法里面调用dao（这个是加载完，后来才会调用的，所以可以使用dao），
         * 通过被拦截url获取数据库中的所有权限，封装成Collection<ConfigAttribute>返回就行了。
         */
        // 将参数转为url
        String url = ((FilterInvocation)object).getRequestUrl();
        Iterator<String> ite = resourceMap.keySet().iterator();
        while (ite.hasNext()) {
            String resURL = ite.next();
            if (urlMatcher.pathMatchesUrl(resURL, url)) {
                return resourceMap.get(resURL);
            }
        }
        return null;
    }
    @Override
    public boolean supports(Class<?>clazz) {
        return true;
    }
    @Override
    public Collection<ConfigAttribute> getAllConfigAttributes() {
        return null;
    }
}
