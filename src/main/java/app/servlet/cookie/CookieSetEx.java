package app.servlet.cookie;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "cookieset", urlPatterns = "/setcookie")
public class CookieSetEx extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html; charset=UTF-8");
        Cookie[] cookies = req.getCookies();
        for (Cookie cook:cookies){
            if (cook.getName().equals("name")){
                resp.getWriter().println("Привет, "+cook.getValue());
            }
        }
        resp.getWriter().println("<html><head></head><body><form action='/hello/cookie1'><input type='text'name='name'/><input type='submit' value='Отправить'/></form></body></html>");
    }
}
