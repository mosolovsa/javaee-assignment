package com.ssau.laba1.controller;

import com.ssau.laba1.dao.StoreBean;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "StoresDelServlet", urlPatterns = {"/del_stores"})
public class StoresDelServlet extends HttpServlet {
    @EJB
    private StoreBean storeBean;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
        long delete_id = Long.parseLong(req.getParameter("id"));
        // TODO: add error handling?
        storeBean.delete(delete_id);
        res.sendRedirect(req.getContextPath() + "/stores");
    }
}
