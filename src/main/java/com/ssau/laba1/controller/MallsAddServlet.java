package com.ssau.laba1.controller;

import com.ssau.laba1.dao.MallBean;
import com.ssau.laba1.model.MallEntity;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "MallsAddServlet", urlPatterns = {"/add_malls"})
public class MallsAddServlet extends HttpServlet {
    @EJB
    public MallBean mallBean;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
        if (req.getParameter("id") != null) {
            req.setAttribute("mall", mallBean.findById(Long.parseLong(req.getParameter("id"))));
        }
        req.getRequestDispatcher("malls_add.jsp").forward(req, res);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
        String name = req.getParameter("name");
        String address = req.getParameter("address");
        if (!req.getParameter("id").equals("") && !req.getParameter("id").isEmpty()) {
            long update_id = Long.parseLong(req.getParameter("id"));
            MallEntity mall = mallBean.findById(update_id);
            mall.setName(name);
            mall.setAddress(address);
            mallBean.update(mall);
        } else {
            MallEntity mall = new MallEntity();
            mall.setName(name);
            mall.setAddress(address);
            mallBean.insert(mall);
        }
        res.sendRedirect(req.getContextPath() + "/malls");
    }
}
