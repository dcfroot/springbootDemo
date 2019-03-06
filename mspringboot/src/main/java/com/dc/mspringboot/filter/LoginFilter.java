package com.dc.mspringboot.filter;

import com.dc.mspringboot.constants.ConstantsBase;
import com.dc.mspringboot.pojo.SysUser;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @Description: 登录过滤器，过滤session中"user"不存在的用户
 * @auther: dcf
 * @date: 2019/2/21
 */
@WebFilter(filterName = "LoginFilter",urlPatterns = "/views/*")
public class LoginFilter implements Filter {
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        System.out.println("------进入过滤器------");
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;
        HttpSession session = httpRequest.getSession();
        String path = httpRequest.getRequestURI();
        if (path != null && path.indexOf(".html") > 0) {
            // 获得登录的用户信息
            SysUser user = (SysUser) session.getAttribute(ConstantsBase.SESSION_USER);
            if (user == null) {
                httpResponse.sendRedirect(((HttpServletRequest) request).getContextPath()+"/login.html");
            }
        }
        chain.doFilter(request, response);
    }

    public void destroy() {
        System.out.println("------销毁过滤器------");
    }
}
