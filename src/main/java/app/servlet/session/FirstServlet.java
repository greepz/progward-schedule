package app.servlet.session;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.PrintWriter;

@WebServlet(name = "firstservlet", urlPatterns = "/firstservlet")
public class FirstServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response){
        try{


            response.setContentType("text/html");
            PrintWriter out = response.getWriter();

            if (request.getParameter("userName") != null){
                String n=request.getParameter("userName");
                out.println("Welcome "+n);

                HttpSession session=request.getSession();
                session.setAttribute("uname",n);

                out.print("<a href='secondservlet'>visit</a>");
            }else{
                HttpSession session=request.getSession();


                out.println("Welcome "+session.getAttribute("uname"));
                out.print("<a href='secondservlet'>visit</a>");
            }


            out.close();

        }catch(Exception e){System.out.println(e);}
    }

}
