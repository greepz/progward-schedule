package app.servlet.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebFilter(filterName = "SettingsFilter", urlPatterns = {"/settings", "/mentors"})
public class SettingsFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println(" filter Hello Mentors");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        servletResponse.setContentType("text/html; charset=UTF-8");


        PrintWriter pr = servletResponse.getWriter();
        System.out.println(" filter Hello Mentors preprocessing ");
        pr.println("<!Doctype html><html><head><title>Title</title></head>");
        filterChain.doFilter(servletRequest, servletResponse);

        pr.println("</html>");

    }

    @Override
    public void destroy() {

    }
}
