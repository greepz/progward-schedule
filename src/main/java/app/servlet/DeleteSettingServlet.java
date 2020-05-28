package app.servlet;

import app.facade.settings.DeleteSettings;
import app.facade.settings.GetSettings;
import app.repository.model.Setting;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "DeleteSettingServlet", urlPatterns = "/deleteSetting")
public class DeleteSettingServlet extends HttpServlet {

    private DeleteSettings deleteSettings;

    @Override
    public void init() throws ServletException {
        deleteSettings = new DeleteSettings();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String id = req.getParameter("id");

       deleteSettings.deleteFromJson(id);

      resp.sendRedirect("/hello/settings");

    }
}
