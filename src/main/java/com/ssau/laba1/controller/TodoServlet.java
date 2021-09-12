package com.ssau.laba1.controller;

import com.ssau.laba1.model.TodoEntity;

//  TODO: remove
//      DEBUG
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.SQLException;
//import java.util.Properties;

import java.io.*;

import java.util.List;

import javax.servlet.http.*;
import javax.servlet.annotation.*;

import javax.persistence.*;

import com.ssau.laba1.model.TodoEntity;

@WebServlet(name = "todoServlet", value = "/todo")
public class TodoServlet extends HttpServlet {
    private String message;

    public void init() {
        message = "List of todos:<br/>";
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");

//  TODO: remove
//      DEBUG
//        try {
//            Class.forName("org.postgresql.Driver");
//        } catch (ClassNotFoundException e) {
//            throw new IOException("class not found");
//        }

//  TODO: remove
//      DEBUG
//        String url = "jdbc:postgresql://db:5432/postgres";
//        Properties props = new Properties();
//        props.setProperty("user", "postgres");
//        props.setProperty("password", "postgres");
////        props.setProperty("ssl", "true");
//        try {
//            Connection db = DriverManager.getConnection(url, props);
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("todos");
        EntityManager entityManager = emf.createEntityManager();

        List<TodoEntity> all = entityManager.createQuery("Select t from TodoEntity t").getResultList();
        for (TodoEntity v : all) {
            message += v.toString(); //TODO: stringbuilder?
            message += "<br/>";
        }

        // Hello
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>" + message + "</h1>");
        out.println("</body></html>");
    }

    public void destroy() {
    }
}