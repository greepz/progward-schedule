package app.servlet;

import app.facade.settings.AddSetting;
import app.repository.model.Setting;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "AddSettingServlet", urlPatterns = "/settings/add")
public class AddSettingServlet extends HttpServlet {

   // private AddSetting addSetting;
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html; charset=UTF-8");
        //Setting setting = parseRequest(req);
       // addSetting.inJsonFile(setting);
        resp.getWriter().println("YES");
    }

    private Setting parseRequest(HttpServletRequest req) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void destroy() {
        super.destroy();
//        addSetting = null;
    }

    @Override
    public void init() throws ServletException {
        super.init();
//        addSetting = new AddSetting();
    }
}
