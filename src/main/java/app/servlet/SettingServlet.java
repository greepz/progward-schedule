package app.servlet;

import app.facade.settings.GetSettings;
import app.repository.model.Setting;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "SettingsServlet", urlPatterns = "/settings")
public class SettingServlet extends HttpServlet {

    private GetSettings settings;

    @Override
    public void init() throws ServletException {
        super.init();
        settings = new GetSettings();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setContentType("text/html; charset=UTF-8");
        List<Setting> list = settings.fromJson();

        resp.getWriter().println(convertToHtml(list));


    }

    private String convertToHtml(List<Setting> list) {
        StringBuilder builder = new StringBuilder();
        builder.append("<!Doctype html><html><head><title>Settings</title><body><table>");
        for (Setting setting: list){
            builder.append("<tr>");
            builder
                    .append("<td>"+setting.getId()+"</td>")
                    .append("<td>"+setting.getName()+"</td>")
                    .append("<td>"+setting.getValue()+"</td>");
            builder.append("</tr>");

        }
        builder.append("</table></body></html>");
        return builder.toString();
    }

    @Override
    public void destroy() {
        super.destroy();
        settings = null;
    }
}
