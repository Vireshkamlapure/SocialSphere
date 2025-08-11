<%@ page import = "java.util.List" %>

<%@ page import = "com.adtu.dao.PostDAO" %>
<%@ page import = "com.adtu.dao.CommentDAO" %>

<%@ page import = "com.adtu.dao.PostDAOImpl" %>
<%@ page import = "com.adtu.dao.CommentDAOImpl" %>

<%@ page import = "com.adtu.model.Post" %>
<%@ page import = "com.adtu.model.Comment" %>
<html>
<head>
    <title>All Posts</title>
    <style>
        body {
            font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
            background-color: #e6ecf0;
            padding: 40px 20px;
        }

           .top-bar {
                display: flex;
                justify-content: space-between;
                align-items: center;
                padding: 15px 30px;
                background-color: #f0f0f0;
                box-shadow: 0 2px 5px rgba(0,0,0,0.1);
                font-family: sans-serif;
            }

            .user-info {
                font-weight: bold;
                color: #333;
            }

            .top-bar a {
                text-decoration: none;
                background-color: #007BFF;
                color: white;
                padding: 10px 15px;
                border-radius: 5px;
                font-weight: bold;
                transition: background-color 0.3s;
            }

            .top-bar a:hover {
                background-color: #0056b3;
            }

        h1 {
            text-align: center;
            color: #079259;
            margin-bottom: 40px;
        }

        .post {
            background-color: #fff;
            padding: 20px 25px;
            border-radius: 12px;
            margin: 20px auto;
            max-width: 600px;
            box-shadow: 0 4px 10px rgba(0, 0, 0, 0.08);
            transition: transform 0.2s ease, box-shadow 0.2s ease;
        }

        .post:hover {
            transform: translateY(-5px);
            box-shadow: 0 6px 15px rgba(0, 0, 0, 0.15);
        }

        .post h3 {
            margin: 0;
            color: #333;
            font-size: 20px;
        }

        .post p {
            margin: 12px 0;
            color: #555;
            line-height: 1.6;
        }

        .user-id {
            font-size: 13px;
            color: #888;
            text-align: right;
            margin-top: 10px;
        }
    </style>
</head>
<body>

     <div class="top-bar">
            <div class="user-info">
                <%
                    String userName = request.getAttribute("userid").toString();
                %>
                Welcome, <a href="userProfile.html"><%= userName %></a>
            </div>
            <a href="createPost.html">Create New Post</a>


            <a href="LogOutServlet">Log-out</a>

        </div>

    <h1>Recent Posts</h1>

    <%
        List<Post> posts = (List<Post>) request.getAttribute("posts");
        List<Comment> comments = (List<Comment>) request.getAttribute("comments");
        for (Post post : posts) {
    %>
        <div class="post">
            <div class="user-id">— Posted On: <%= post.getDate()  %></div>
            <div class="user-id">— User ID: <%= post.getUid() %></div>
            <h3><%= post.getTitle() %></h3>
            <p><%= post.getContent() %></p>

            <% for(Comment comment : comments) {
            if( comment.getpID() == post.getPid() )
            {
            %>
            <p> <b>Comment : </b> : <%= comment.getContent() %> &nbsp&nbsp&nbsp <b>Made by</b> <%= comment.getuID() %> &nbsp&nbsp&nbsp   <b>Time</b> : <%= comment.getDate() %></P>

            <%
            }
            } %>
            <form action="createCommentServlet" method="post">
                <input type="hidden" name="postid" value="<%= post.getPid() %>" />
               <input type="text" name="comment" placeholder="Add a sweet Comment"/>
               <input type="submit" value="comment" name="operation"/>
            </form>
        </div>
    <%

        }
    %>
</body>
</html>
