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

       req.setAttribute("settings", list);

       req.setAttribute("hello", "Hello World");

       req.getRequestDispatcher("settings.jsp").forward(req, resp);

    }



    @Override
    public void destroy() {
        super.destroy();
        settings = null;
    }
}
