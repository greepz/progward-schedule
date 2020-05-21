package app.servlet.cookie;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "cookie1", urlPatterns = "/cookie1")
public class Cookie1 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html; charset=UTF-8");
        if (req.getParameter("name") != null){
            Cookie cookie = new Cookie("name", req.getParameter("name"));
            resp.addCookie(cookie);
            resp.getWriter().println("Привет, "+cookie.getValue());
        } else{
            Cookie[] cookies = req.getCookies();
            for (Cookie cook:cookies){
                if (cook.getName().equals("name")){
                    resp.getWriter().println("Привет, "+cook.getValue());
                }
            }
        }







    }
}
