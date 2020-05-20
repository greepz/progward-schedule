package app.servlet;

import app.facade.settings.GetMentors;
import app.repository.model.Mentor;
import app.repository.model.Setting;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;


@WebServlet(name = "MentorServlet", urlPatterns = "/mentors")
public class MentorServlet extends HttpServlet {
    private final static Logger LOGGER = Logger.getLogger(MentorServlet.class.getName());
    private GetMentors mentors;

    @Override
    public void init() throws ServletException {

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        LOGGER.log(Level.INFO, "Init mentors");
        mentors = new GetMentors();
        List<Mentor> list = mentors.fromJson();
       resp.getWriter().println(convertToHtml(list));
    }

    private String convertToHtml(List<Mentor> list) {
        StringBuilder builder = new StringBuilder();
        builder.append("<body><table cellpadding=\"0\" cellspacing=\"0\" border=\"1\">");
        builder.append("<tr><th>ID</th><th>Name</th><th>Email</th></tr>");
        for (Mentor mentor: list){
            builder.append("<tr>");
            builder
                    .append("<td>"+mentor.getId()+"</td>")
                    .append("<td>"+mentor.getName()+"</td>")
                    .append("<td>"+mentor.getEmail()+"</td>");
            builder.append("</tr>");

        }
        builder.append("</table></body>");
        return builder.toString();
    }
}
