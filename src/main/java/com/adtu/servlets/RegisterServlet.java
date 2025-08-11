package com.adtu.servlets;

import com.adtu.dao.UserDAO;
import com.adtu.dao.UserDAOImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import com.adtu.model.User;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet
{
    UserDAO userDAO = new UserDAOImpl();
    int res;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();

        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String email = req.getParameter("email");
        HttpSession session =req.getSession(true);


        res = userDAO.Register(new User(username,password,email));
        if (res == 0) {
            out.println("username already taken ");

        }
        else {
            out.println(res + " User Registered");
        }

        session.setAttribute("userid", username);

        req.getRequestDispatcher("HomeServlet").forward(req, resp);
    }
}
