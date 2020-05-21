package app.servlet.session;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.PrintWriter;

@WebServlet(name = "SecondServlet", urlPatterns = "/secondservlet")
public class SecondServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) {
        try{

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        HttpSession session=request.getSession(false);
        String n=(String)session.getAttribute("uname");
        out.print("Hello "+n);

        out.close();

    }catch(Exception e){System.out.println(e);}
    }
}
