package web;

import model.User;

import javax.servlet.*;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class UserServlet extends HttpServlet {

    List<User> list = List.of(new User("Vova", 12), new User("Kolia", 11));

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String parameter1 = req.getParameter("id");
        String parameter2 = req.getParameter("names");
        if (parameter1 != null && parameter2 != null) {
            list.add(new User(parameter2, Integer.parseInt(parameter1)));
        }
        }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Cookie cookie = new Cookie("cookie", "Coo");
        resp.getWriter().write(cookie.getMaxAge());
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String Sid = req.getParameter("id");

        int id = Integer.parseInt(Sid);
        for (User user : list) {
            if (user.getId() == id) {
                list.remove(user);
            }
        }
        resp.getWriter().write(Sid);

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cookie cookie = new Cookie("cookie", "Coo");
        resp.addCookie(cookie);
        resp.getWriter().write(cookie.getMaxAge());

        String parameter = req.getParameter("id");
        if (parameter == null) {
            resp.getWriter().write(String.valueOf(list));
        } else {
            for (User user : list) {
                if (user.getId() == Integer.parseInt(parameter))
                    resp.getWriter().write(String.valueOf(user));
            }
        }
        resp.sendRedirect("https://www.youtube.com");
    }
}
