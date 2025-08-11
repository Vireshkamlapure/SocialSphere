package com.adtu.servlets;

import com.adtu.dao.CommentDAO;
import com.adtu.dao.CommentDAOImpl;
import com.adtu.model.Comment;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;

@WebServlet("/createCommentServlet")
public class createCommentServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();

        CommentDAO commentDAO = new CommentDAOImpl();

        HttpSession session = req.getSession(true);
        String userId =session.getAttribute("userid").toString();

        int postId = Integer.parseInt(req.getParameter("postid"));
        String content = req.getParameter("comment");
        LocalDate myObj = LocalDate.now();

        int res = commentDAO.createComment(new Comment(0,postId , session.getAttribute("userid").toString(), content, myObj));
        out.println(res+" commented.");

        session.setAttribute("userid",session.getAttribute("userid").toString() );

        req.getRequestDispatcher("HomeServlet").forward(req, resp);

//        resp.sendRedirect("home.jsp");

    }
}
