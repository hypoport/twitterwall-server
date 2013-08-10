package de.hypoport.twitterwall;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class AppConfigurationServlet extends HttpServlet {

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    String server = req.getServerName() + ":" + req.getServerPort();
    String cfg = "appConfiguration.searchUrl = 'http://" + server + "/search';";

    resp.setContentType("application/javascript");
    PrintWriter writer = resp.getWriter();
    writer.write(cfg);
    writer.close();
  }
}
