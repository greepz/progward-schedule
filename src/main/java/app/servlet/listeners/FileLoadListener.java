package app.servlet.listeners;

import app.repository.model.Client;
import app.repository.model.Mentor;
import app.repository.model.Role;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.util.List;
import java.util.logging.Logger;

import static app.repository.loader.Loader.*;

@WebListener("FileLoadListener")
public class FileLoadListener implements ServletContextListener {
    private final static Logger LOGGER = Logger.getLogger(FileLoadListener.class.getName());
    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        LOGGER.info("Загрузка файлов с данными!");
        load();
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {

    }
}
