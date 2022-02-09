package web;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.security.InvalidParameterException;

@WebFilter("/*")
public class UserFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        String method = ((HttpServletRequest) servletRequest).getMethod();
        String id = null;
        if (method.equals("GET")) {
            filterChain.doFilter(servletRequest, servletResponse);
        } else {
            id = servletRequest.getParameter("id");
        }
        if (id != null) {
            filterChain.doFilter(servletRequest, servletResponse);
        } else {
            throw new InvalidParameterException();
        }
        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {
    }
}
