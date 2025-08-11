package com.adtu.servlets;

import com.adtu.dao.UserDAO;
import com.adtu.dao.UserDAOImpl;
import com.adtu.model.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/signInServlet")
public class signInServlet extends HttpServlet {
    UserDAO userDAO = new UserDAOImpl();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();

        String username = req.getParameter("username");
        String password = req.getParameter("password");

        HttpSession session =req.getSession(true);

        if(username == null && password == null){
            resp.sendRedirect("http://localhost:8080/SocialSphere/login.html");
            return;
        }
        if (!username.isBlank()) {
            User sendingUser = new User();
            sendingUser.setUid(username);
            sendingUser.setPassword(password);
            User user = userDAO.login(sendingUser);
            if (user.getUid() == null){
                resp.sendRedirect("http://localhost:8080/SocialSphere/login.html");
                return;
            }

            session.setAttribute("userid", user.getUid());
            req.getRequestDispatcher("HomeServlet").forward(req, resp);
        }

    }
}
