package com.adtu.servlets;

import com.adtu.dao.*;
import com.adtu.model.Comment;
import com.adtu.model.Post;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/HomeServlet")
public class HomeServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        UserDAO userDAO = new UserDAOImpl();
        HttpSession session = req.getSession(false);
        String userId =session.getAttribute("userid").toString();

        PostDAO postDAO = new PostDAOImpl();
        List<Post> posts;

        CommentDAO commentDAO = new CommentDAOImpl();
        List<Comment> comments ;

        posts = postDAO.view();

        comments = commentDAO.view();

        req.setAttribute("comments",comments);

        req.setAttribute("posts", posts);
        req.setAttribute("userid", userId);
        req.getRequestDispatcher("home.jsp").forward(req, resp);
    }
}
