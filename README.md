# SocialSphere

## SocialSphere – A Facebook-like Social Media Web App
### 📌 Project Overview
SocialSphere is a simple, text-based social media platform built using Java Servlets, JSP, and JDBC.
It mimics basic Facebook functionality, allowing users to register, log in, create posts, view posts, and comment on them — all stored in a MySQL database.

This project demonstrates the core concepts of Java EE, JDBC, and web application development using the Model-View-Controller (MVC) pattern.

---

### 🎯 Features
* User Registration – Create an account with username, password, and email.

* User Login – Authenticate users with credentials.

* Create Post – Logged-in users can publish text posts with a title and content.

* View All Posts – See posts from all users in reverse chronological order.

* Comment on Posts – Engage with posts by adding comments.

* Logout and session handling. 

---

| Layer          | Technology Used    |
| -------------- | ------------------ |
| **Frontend**   | HTML, CSS          |
| **Backend**    | Java Servlets, JSP |
| **Database**   | MySQL (via JDBC)   |
| **Build Tool** | Maven              |
| **Server**     | Apache Tomcat 11   |
| **IDE**        | IntelliJ IDEA      |

---

### ⚙️ Setup & Installation
1️⃣ Prerequisites
* Java JDK 17+

* Apache Tomcat 11

* MySQL Server

* IntelliJ IDEA (or Eclipse)

* Maven

2️⃣ Database Setup 

1. Create a database in MySQL:

```shell 
  CREATE DATABASE socialsphere;
```
2. Create required tables:

```shell
  CREATE TABLE users (
    id INT PRIMARY KEY AUTO_INCREMENT,
    username VARCHAR(50) UNIQUE NOT NULL,
    password VARCHAR(255) NOT NULL,
    email VARCHAR(100) NOT NULL
);

CREATE TABLE posts (
    id INT PRIMARY KEY AUTO_INCREMENT,
    user_id INT,
    title VARCHAR(100),
    content TEXT,
    timestamp TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (user_id) REFERENCES users(id)
);

CREATE TABLE comments (
    id INT PRIMARY KEY AUTO_INCREMENT,
    post_id INT,
    user_id INT,
    content TEXT,
    timestamp TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (post_id) REFERENCES posts(id),
    FOREIGN KEY (user_id) REFERENCES users(id)
);
```
3. Clone and Build Project

```shell
  git clone https://github.com/Vireshkamlapure/SocialSphere.git
cd SocialSphere
mvn clean install
```
4. Deploy to Tomcat
+ Copy the generated .war file from target/ into Tomcat’s webapps/ folder.
+ Start Tomcat and visit:
```shell
  http://localhost:8080/SocialSphere
``` 
