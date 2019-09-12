package com.ltsk.whcg.sso;

import org.xml.sax.SAXException;

import net.sf.json.JSONObject;
import ssoagent.client.LocalLDAPValidator;
import ssoagent.client.ProxyTicketValidator;
import ssoagent.client.filter.AuthenFilter;
import ssoagent.client.filter.FilterRequestWrapper;
import ssoagent.exception.*;
import ssoagent.util.FixSizeHashMap;
import ssoagent.util.Util;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSession;
import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.net.ConnectException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.StringTokenizer;

/**
 * @author: Mr Wang
 * @date: 2019/3/13
 * @time: 17:20
 */


public class SuperviseFilter extends AuthenFilter {

    public static String CAS_FILTER_USER = "ssoclientagent.user";
    public static boolean IS_AUTOBYPASS = false;
    public static final String UTRUST_FILTER_NAME = "ssoclientagent.name";
    public static final String UTRUST_FILTER_ROLE = "ssoclientagent.role";
    public static final String UTRUST_FILTER_EMAIL = "ssoclientagent.email";
    public static final String UTRUST_FILTER_APPACCOUNT = "ssoclientagent.appaccount";
    public static final String UTRUST_FILTER_ATTRIBUTE = "ssoclientagent.attributes";
    public static final String UTRUST_FILTER_ACCOUNTSTATU = "ssoclientagent.accountstatu";
    public static final String UTRUST_FILTER_AUTHERRORCODE = "ssoclientagent.autherrorcode";
    public static final String UTRUST_FILTER_REALURL = "ssoclientagent.realurl";
    public static final String UTRUST_FILTER_PASSWORD = "ssoclientagent.password";
    public static final String UTRUST_FILTER_ERRORMESSAGE = "ssoclientagent.errorMessage";
    private static HashMap<String, String> nodesMap = null;
    public static FixSizeHashMap sessionMap = new FixSizeHashMap(50000);
    protected String encoding = null;
    private String casLogin;
    private String casValidate;
    private String invalidAuthenUrl;
    private String filtersString;
    private String returnUrl;
    private String nofilterurlStr;
    private String applicationLoginUrl;
    private String username;
    private String password;
    private String ldapUrl;
    private String ldapUser;
    private String ldapPassword;
    private String casAuthorizedProxy;
    int checkServerInterval = 30;
    private boolean wrapRequest;
    private boolean keepquerystring;
    String[] loginvisits;
    String[] nofilters;
    String[] nofilterurls;
    public static boolean ssoIsRunning = true;
    public static boolean isSingleLogout = false;
    private static long ssostatuchekpoint = System.currentTimeMillis();

    public SuperviseFilter() {
        super();
    }

    @Override
    public void init(FilterConfig config) throws ServletException {
        this.casLogin = "http://10.19.0.19/ssoserver/login/agentlogin";
        this.casValidate = "http://10.19.0.19/ssoserver/serviceValidate";
        this.invalidAuthenUrl = "";
        this.filtersString = "http://10.19.0.11:8888/supervise2/logout;http://10.19.0.11:8888/supervise2/checkLogin";
        this.nofilterurlStr = "http://10.19.0.11:8888/supervise2/logout;http://10.19.0.11:8888/supervise2/checkLogin";
        
        this.returnUrl = "http://10.19.0.11:8888/supervise2/index";
        //this.encoding = "";
        this.nofilters =new String[]{"http://10.19.0.11:8888/supervise2/*","*/ssologout.do","http://10.19.0.11:8888/supervise2/logout","http://10.19.0.8:8080/server/linklogin","http://10.19.0.8:80/*"};
        this.wrapRequest = false;
        this.keepquerystring = true;
        IS_AUTOBYPASS = false;
        isSingleLogout = false;
        String interval = "100";

        if (interval != null) {
            this.checkServerInterval = Integer.parseInt(interval);
        }

        if (this.filtersString != null) {
            this.nofilters = this.filtersString.split(";");
        }

        if (this.nofilterurlStr != null) {
            this.nofilterurls = this.nofilterurlStr.split(";");
        }
        

        /*this.applicationLoginUrl  = "http://127.0.0.1:8080/example/action.jsp";
        this.username = "username";
        this.password = "password";
        this.ldapUrl = "ldap://10.20.62.93:389";
        this.ldapUser = "Manager,dc=chinautrust,dc=com";
        this.ldapPassword = "password12345";*/
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain fc) throws ServletException, IOException {
        if (request instanceof HttpServletRequest && response instanceof HttpServletResponse) {
            if (((ServletRequest) request).getCharacterEncoding() == null && this.encoding != null && !"".equals(this.encoding)) {
                ((ServletRequest) request).setCharacterEncoding(this.encoding);
            }

            if (this.wrapRequest) {
                request = new FilterRequestWrapper((HttpServletRequest) request);
            }

            HttpSession session = ((HttpServletRequest) request).getSession();

            String ticket = ((ServletRequest) request).getParameter("ticket");
            if (session != null && session.getAttribute(CAS_FILTER_USER) != null) {
                fc.doFilter((ServletRequest) request, response);
            } else {
                String url = ((HttpServletRequest) request).getRequestURL().toString();
                String queryString = ((HttpServletRequest) request).getQueryString();
                if (queryString != null && !queryString.equals("")) {
                    url = url + "?" + queryString;
                }

                boolean ignore = false;
                String service;
                int var10;
                int var11;
                String[] var12;
                if (this.loginvisits != null && (ticket == null || ticket.equals(""))) {
                    var11 = (var12 = this.loginvisits).length;

                    for (var10 = 0; var10 < var11; ++var10) {
                        service = var12[var10];
                        if (Util.matched(service.trim(), url)) {
                            ignore = true;
                            break;
                        }
                    }
                }

                if (!ignore) {
                    ignore = false;
                    if (this.nofilters != null && (ticket == null || ticket.equals(""))) {
                        service = ((HttpServletRequest) request).getQueryString();
                        String[] var13;
                        int var24 = (var13 = this.nofilters).length;

                        for (var11 = 0; var11 < var24; ++var11) {
                            String filter = var13[var11];
                            if (Util.matched(filter.trim(), url) || service != null && Util.matched(filter.trim(), service)) {
                                ignore = true;
                                break;
                            }
                        }

                        if (ignore) {
                            fc.doFilter((ServletRequest) request, response);
                            return;
                        }
                    }

                    ignore = false;
                    if (this.nofilterurls != null && (ticket == null || ticket.equals(""))) {
                        var11 = (var12 = this.nofilterurls).length;

                        for (var10 = 0; var10 < var11; ++var10) {
                            service = var12[var10];
                            if (url.equalsIgnoreCase(service)) {
                                ignore = true;
                                break;
                            }
                        }

                        if (ignore) {
                            fc.doFilter((ServletRequest) request, response);
                            return;
                        }
                    }
                }

                if (ticket == null || ticket.equals("")) {
                    if (this.casLogin == null) {
                        throw new ServletException("When Filter protects pages that do not receive a 'ticket' parameter, it needs a ssoclientagent.loginUrl filter parameter");
                    }

                    ssoIsRunning = this.isServiceRuning(this.casLogin);
                    if (!IS_AUTOBYPASS || ssoIsRunning) {
                        service = this.getService((HttpServletRequest) request);
                        session.setAttribute("ssoclientagent.realurl", service);
                        if (this.returnUrl != null) {
                            service = URLEncoder.encode(this.returnUrl);
                        }

                        if (this.keepquerystring & queryString != null && !queryString.equals("")) {
                            service = URLEncoder.encode(this.returnUrl + "?" + queryString);
                        }

                        ((HttpServletResponse) response).sendRedirect(this.casLogin + "?service=" + service);
                        return;
                    }

                    boolean passConfigureIsOk = false;
                    if (this.applicationLoginUrl != null && !this.applicationLoginUrl.equals("") && Util.matched(this.applicationLoginUrl.trim(), url)) {
                        if (this.username != null && this.password != null && !this.username.trim().equals("") && !this.password.trim().equals("")) {
                            passConfigureIsOk = true;
                        } else {
                            session.setAttribute("ssoclientagent.errorMessage", "ssoconfig.properties配置的用户名密码不能为空");
                        }
                    }

                    if (!passConfigureIsOk) {
                        fc.doFilter((ServletRequest) request, response);
                        return;
                    }
                }

                service = null;

                try {
                    if (IS_AUTOBYPASS && !ssoIsRunning) {
                        Hashtable<String, String> connEvn = new Hashtable();
                        connEvn.put("ssoclientagent.ldapurl", this.ldapUrl);
                        connEvn.put("ssoclientagent.ldapuser", this.ldapUser);
                        connEvn.put("ssoclientagent.ldappass", this.ldapPassword);
                        service = this.getAuthenticatedUserFromLDAP((HttpServletRequest) request, connEvn);
                    } else {
                        service = this.getAuthenticatedUser((HttpServletRequest) request);
                    }
                } catch (ConnectException var14) {
                    var14.printStackTrace();
                    session.setAttribute("ssoclientagent.autherrorcode", "INTERNAL_ERROR");
                } catch (InvalidServiceException var15) {
                    var15.printStackTrace();
                    if (this.invalidAuthenUrl != null) {
                        session.setAttribute("ssoclientagent.autherrorcode", "INVALID_SERVICE");
                        ((HttpServletResponse) response).sendRedirect(this.invalidAuthenUrl);
                    } else {
                        this.redirecterrpage(response, "INVALID_SERVICE", var15.getMessage());
                    }

                    return;
                } catch (InvalidTicketException var16) {
                    if (this.invalidAuthenUrl != null) {
                        session.setAttribute("ssoclientagent.autherrorcode", "INVALID_TICKET");
                        ((HttpServletResponse) response).sendRedirect(this.invalidAuthenUrl);
                        return;
                    }

                    this.redirecterrpage(response, "INVALID_TICKET", var16.getMessage());
                    return;
                } catch (InternalErrorException var17) {
                    if (this.invalidAuthenUrl != null) {
                        session.setAttribute("ssoclientagent.autherrorcode", "INTERNAL_ERROR");
                        ((HttpServletResponse) response).sendRedirect(this.invalidAuthenUrl);
                    } else {
                        this.redirecterrpage(response, "INTERNAL_ERROR", var17.getMessage());
                    }

                    return;
                } catch (InvalidRequestException var18) {
                    if (this.invalidAuthenUrl != null) {
                        session.setAttribute("ssoclientagent.autherrorcode", "INTERNAL_ERROR");
                        ((HttpServletResponse) response).sendRedirect(this.invalidAuthenUrl);
                    } else {
                        this.redirecterrpage(response, "INVALID_REQUEST", var18.getMessage());
                    }

                    return;
                } catch (ServiceNotAllowedException var19) {
                    if (this.invalidAuthenUrl != null) {
                        session.setAttribute("ssoclientagent.autherrorcode", "SERVICE_NOALLOWAD");
                        ((HttpServletResponse) response).sendRedirect(this.invalidAuthenUrl);
                    } else {
                        this.redirecterrpage(response, "SERVICE_NOALLOWAD", var19.getMessage());
                    }

                    return;
                } catch (LocalLDAPAuthenException var20) {
                    session.setAttribute("ssoclientagent.autherrorcode", "LDAP_AUTHEN_ERROR");
                    if (this.invalidAuthenUrl == null) {
                        this.redirecterrpage(response, "SERVICE_NOALLOWAD", var20.getMessage());
                        return;
                    }

                    ((HttpServletResponse) response).sendRedirect(this.invalidAuthenUrl);
                }

                session.setAttribute(CAS_FILTER_USER, service);
                if (session != null && isSingleLogout) {
                    sessionMap.put(session.getId(), session);
                }

                fc.doFilter((ServletRequest) request, response);
            }
        } else {
            throw new ServletException("Filter protects only HTTP resources");
        }
    }

    @Override
    public void redirecterrpage(ServletResponse response, String errID, String errInfo) throws IOException {
        int index = this.casLogin.indexOf("/ssoserver/");
        if (index <= 0) {
            response.setCharacterEncoding("gbk");
            response.setContentType("text/html;charset=gbk");
            PrintWriter out = new PrintWriter(response.getOutputStream());
            out.println("<html>");
            out.println("<HEAD>");
            out.println("<title>错误信息</title>");
            out.println("<META http-equiv=Content-Type content=\"text/html; charset=gbk\">");
            out.println("<body>");
            out.println("<h1>认证错误</h1>");
            out.println("错误代码:" + errID);
            out.println("<br/>");
            out.println("错误详细信息:" + errInfo);
            out.println("</body>");
            out.println("</html>");
            out.close();
        } else {
            String host = this.casLogin.substring(0, index);
            response.setCharacterEncoding("gbk");
            response.setContentType("text/html;charset=gbk");
            String url = host + "/ssoserver/jsp/public/autherror.jsp?errcode=" + errID;
            ((HttpServletResponse) response).sendRedirect(url);
        }
    }

    @Override
    public void destroy() {
        super.destroy();
    }

    private String getAuthenticatedUser(HttpServletRequest request) throws ServletException, InvalidServiceException, InvalidTicketException, InternalErrorException, InvalidRequestException, ServiceNotAllowedException, IOException {
        ProxyTicketValidator pv = null;

        String proxy;
        try {
            pv = new ProxyTicketValidator();
            pv.setSingleLogout(isSingleLogout);
            pv.setCasValidateUrl(this.casValidate);
            if (nodesMap != null) {
                pv.setRealSSOHost((String) nodesMap.get(request.getParameter("nodename")));
            }

            pv.setServiceTicket(request.getParameter("ticket"));
            pv.setService(this.getService(request));
            pv.setSessionId(request.getSession().getId());
            pv.validate();
            if (!pv.isAuthenticationSuccesful()) {
                if ("INVALID_SERVICE".equals(pv.getErrorCode())) {
                    throw new InvalidServiceException("authentication error: " + pv.getErrorCode() + ": " + pv.getErrorMessage());
                } else if ("INTERNAL_ERROR".equals(pv.getErrorCode())) {
                    throw new InternalErrorException("authentication error: " + pv.getErrorCode() + ": " + pv.getErrorMessage());
                } else if ("INVALID_TICKET".equals(pv.getErrorCode())) {
                    throw new InvalidTicketException("authentication error: " + pv.getErrorCode() + ": " + pv.getErrorMessage());
                } else if ("INVALID_REQUEST".equals(pv.getErrorCode())) {
                    throw new InvalidRequestException("authentication error: " + pv.getErrorCode() + ": " + pv.getErrorMessage());
                } else if ("SERVICE_NOALLOWAD".equals(pv.getErrorCode())) {
                    throw new ServiceNotAllowedException("authentication error: " + pv.getErrorCode() + ": " + pv.getErrorMessage());
                } else {
                    throw new ServletException("SSO authentication error: " + pv.getErrorCode() + ": " + pv.getErrorMessage());
                }
            } else {
                if (pv.getProxyList().size() != 0) {
                    if (this.casAuthorizedProxy == null) {
                        throw new ServletException("this page does not accept proxied tickets");
                    }

                    boolean authorized = false;
                    proxy = (String) pv.getProxyList().get(0);
                    StringTokenizer casProxies = new StringTokenizer(this.casAuthorizedProxy);

                    while (casProxies.hasMoreTokens()) {
                        if (proxy.equals(casProxies.nextToken())) {
                            authorized = true;
                            break;
                        }
                    }

                    if (!authorized) {
                        throw new ServletException("unauthorized top-level proxy: '" + pv.getProxyList().get(0) + "'");
                    }
                }

                HttpSession session = request.getSession();
                session.setAttribute("ssoclientagent.appaccount", pv.getAppaccount());
                session.setAttribute("ssoclientagent.attributes", pv.getAttributes());
                return pv.getUser();
            }
        } catch (SAXException var6) {
            proxy = "";
            if (pv != null) {
                proxy = pv.getResponse();
            }

            throw new ServletException(var6 + " " + proxy);
        } catch (ParserConfigurationException var7) {
            throw new ServletException(var7);
        } catch (IOException var8) {
            throw var8;
        }
    }

    private String getAuthenticatedUserFromLDAP(HttpServletRequest request, Hashtable<String, String> connEvn) throws LocalLDAPAuthenException {
        String localUsername = request.getParameter(this.username);
        String localPassword = request.getParameter(this.password);
        if (localUsername != null && localPassword != null) {
            LocalLDAPValidator validator = new LocalLDAPValidator();
            validator.setLdapConnEnv(connEvn);
            validator.setUser(localUsername);
            validator.setPassword(localPassword);

            try {
                validator.validate();
                if (!validator.isAuthenticationSuccesful()) {
                    if ("LDAP_AUTHEN_ERROR".equals(validator.getErrorCode())) {
                        throw new LocalLDAPAuthenException("authentication error: " + validator.getErrorCode() + ": " + validator.getErrorMessage());
                    }
                } else {
                    HttpSession session = request.getSession();
                    session.setAttribute("ssoclientagent.email", validator.getEmail());
                    session.setAttribute("ssoclientagent.accountstatu", validator.getAccountstatu());
                    session.setAttribute("ssoclientagent.password", localPassword);
                    session.setAttribute(CAS_FILTER_USER, localUsername);
                    session.setAttribute("ssoclientagent.name", validator.getName());
                }

                return localUsername;
            } catch (Exception var7) {
                var7.printStackTrace();
                throw new LocalLDAPAuthenException("authentication error: " + var7.getMessage());
            }
        } else {
            throw new LocalLDAPAuthenException("authentication error: 用户名密码为空，请检查配置是否正确");
        }
    }

    private String getService(HttpServletRequest request) throws ServletException {
        return this.returnUrl != null ? URLEncoder.encode(this.returnUrl) : Util.getService(request);
    }

    private boolean isServiceRuning(String url) {
        url = url + "?action=checkactive";
        if (!ssoIsRunning && (System.currentTimeMillis() - ssostatuchekpoint) / 60000L < (long) this.checkServerInterval) {
            return ssoIsRunning;
        } else {
            InputStream in = null;

            try {
                System.setProperty("java.protocol.handler.pkgs", "javax.net.ssl");
                HostnameVerifier hv = new HostnameVerifier() {
                    public boolean verify(String urlHostName, SSLSession session) {
                        return urlHostName.equals(session.getPeerHost());
                    }
                };
                HttpsURLConnection.setDefaultHostnameVerifier(hv);
                URL u = new URL(url);
                in = u.openStream();
                ssostatuchekpoint = System.currentTimeMillis();
                ssoIsRunning = true;
                return true;
            } catch (IOException var13) {
                ssoIsRunning = false;
                System.err.println("链接不上单点登陆系统--" + url);
            } finally {
                try {
                    if (in != null) {
                        in.close();
                    }
                } catch (IOException var12) {
                }

            }

            return false;
        }
    }
}