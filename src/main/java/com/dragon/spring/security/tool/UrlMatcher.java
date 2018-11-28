package com.dragon.spring.security.tool;

/**
 * Created by huangzhibo on 27/03/2017.
 */
public interface UrlMatcher {
    Object compile(String paramString);
    boolean pathMatchesUrl(Object paramObject, String paramString);
    String getUniversalMatchPattern();
    boolean requiresLowerCaseUrl();
}
