package com.ssau.laba1.controller;

import com.ssau.laba1.dao.MallBean;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "MallsServlet", urlPatterns = {"/malls"})
public class MallsServlet extends HttpServlet {
    @EJB
    private MallBean mallBean;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
        req.setAttribute("malls", mallBean.findAll());
        req.getRequestDispatcher("malls.jsp").forward(req, res);
    }
}
