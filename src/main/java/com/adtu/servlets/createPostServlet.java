package com.adtu.servlets;

import com.adtu.dao.PostDAO;
import com.adtu.dao.PostDAOImpl;
import com.adtu.model.Post;
import com.adtu.model.User;
import com.adtu.util.DBUtil;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDate;

@WebServlet("/createPostServlet")
public class createPostServlet extends HttpServlet {
    PostDAO postDAO = new PostDAOImpl();
//    User user = new User();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();

        String title = req.getParameter("title");
        String content = req.getParameter("content");
        LocalDate myObj = LocalDate.now();
        HttpSession session = req.getSession(false);
        String userId = session.getAttribute("userid").toString();

        int res = postDAO.createPost(new Post(0,title,content,myObj,userId));
        out.println(res+" posted.");

        req.getRequestDispatcher("HomeServlet").forward(req, resp);

    }
}
