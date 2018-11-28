//package com.sourceCode.springSecurity;
//
//import org.springframework.beans.factory.InitializingBean;
//import org.springframework.security.core.AuthenticationException;
//import org.springframework.security.web.AuthenticationEntryPoint;
//import org.springframework.util.Assert;
//
//import javax.servlet.ServletException;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//
//
///**
// * Used by the <code>ExceptionTranslationFilter</code> to commence authentication via the JA-SIG Central
// * Authentication Service (CAS).
// * <p>
// * The user's browser will be redirected to the JA-SIG CAS enterprise-wide login page.
// * This page is specified by the <code>loginUrl</code> property. Once login is complete, the CAS login page will
// * redirect to the page indicated by the <code>service</code> property. The <code>service</code> is a HTTP URL
// * belonging to the current application. The <code>service</code> URL is monitored by the {@link CasAuthenticationFilter},
// * which will validate the CAS login was successful.
// *
// * @author Ben Alex
// * @author Scott Battaglia
// * @version $Id: CasAuthenticationEntryPoint.java 3928 2009-10-07 14:43:55Z ltaylor $
// */
//public class CasAuthenticationEntryPoint implements AuthenticationEntryPoint, InitializingBean {
//    //~ Instance fields ================================================================================================
//    private ServiceProperties serviceProperties;
//
//    private String loginUrl;
//
//    /**
//     * Determines whether the Service URL should include the session id for the specific user.  As of CAS 3.0.5, the
//     * session id will automatically be stripped.  However, older versions of CAS (i.e. CAS 2), do not automatically
//     * strip the session identifier (this is a bug on the part of the older server implementations), so an option to
//     * disable the session encoding is provided for backwards compatibility.
//     *
//     * By default, encoding is enabled.
//     */
//    private boolean encodeServiceUrlWithSessionId = true;
//
//    //~ Methods ========================================================================================================
//
//    public void afterPropertiesSet() throws Exception {
//        Assert.hasLength(this.loginUrl, "loginUrl must be specified");
//        Assert.notNull(this.serviceProperties, "serviceProperties must be specified");
//    }
//
//    public void commence(final HttpServletRequest servletRequest, final HttpServletResponse response,
//            final AuthenticationException authenticationException) throws IOException, ServletException {
//
//        final String urlEncodedService = CommonUtils.constructServiceUrl(null, response, this.serviceProperties.getService(), null, this.serviceProperties.getArtifactParameter(), this.encodeServiceUrlWithSessionId);
//        final String redirectUrl = CommonUtils.constructRedirectUrl(this.loginUrl, this.serviceProperties.getServiceParameter(), urlEncodedService, this.serviceProperties.isSendRenew(), false);
//
//        response.sendRedirect(redirectUrl);
//    }
//
//    /**
//     * The enterprise-wide CAS login URL. Usually something like
//     * <code>https://www.mycompany.com/cas/login</code>.
//     *
//     * @return the enterprise-wide CAS login URL
//     */
//    public String getLoginUrl() {
//        return this.loginUrl;
//    }
//
//    public ServiceProperties getServiceProperties() {
//        return this.serviceProperties;
//    }
//
//    public void setLoginUrl(final String loginUrl) {
//        this.loginUrl = loginUrl;
//    }
//
//    public void setServiceProperties(final ServiceProperties serviceProperties) {
//        this.serviceProperties = serviceProperties;
//    }
//
//    public void setEncodeServiceUrlWithSessionId(final boolean encodeServiceUrlWithSessionId) {
//        this.encodeServiceUrlWithSessionId = encodeServiceUrlWithSessionId;
//    }
//}
