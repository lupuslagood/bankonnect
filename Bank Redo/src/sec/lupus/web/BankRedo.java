package sec.lupus.web;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;


public class BankRedo extends HttpServlet {

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String user = req.getParameter("username");
        req.setAttribute("usr", user);
        RequestDispatcher view = req.getRequestDispatcher("test.jsp");
        view.forward(req, resp);

    }
}
