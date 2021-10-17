package com.ssau.laba1.controller;

import com.ssau.laba1.dao.MallBean;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "MallsDelServlet", urlPatterns = {"/del_malls"})
public class MallsDelServlet extends HttpServlet {
    @EJB
    public MallBean mallBean;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
        long delete_id = Long.parseLong(req.getParameter("id"));
        mallBean.delete(delete_id);
        res.sendRedirect(req.getContextPath() + "/malls");
    }
}
