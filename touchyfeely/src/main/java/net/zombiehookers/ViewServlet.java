package net.zombiehookers;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import net.zombiehookers.Data2Image;

public class ViewServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Data2Image random = new Data2Image();
	random.Creator(40.015,-105.2,40);
	req.getRequestDispatcher("/WEB-INF/jsp/view.jsp").forward(req, resp);
    }
}
