package app.servlet.session;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "loginservlet", urlPatterns = "/servletlogin")
public class LoginServlet extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html; charset=UTF-8");
        resp.getWriter().println("<form action=\"/hello/firstservlet\"> Name:<input type=\"text\" name=\"userName\"/><br/> <input type=\"submit\" value=\"go\"/> </form>  ");
    }
}
