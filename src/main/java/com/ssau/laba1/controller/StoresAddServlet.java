package com.ssau.laba1.controller;

import com.ssau.laba1.dao.StoreBean;
import com.ssau.laba1.model.StoreEntity;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "StoresAddServlet", urlPatterns = {"/add_stores"})
public class StoresAddServlet extends HttpServlet {
    @EJB
    private StoreBean storeBean;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
        if (req.getParameter("id") != null) {
            req.setAttribute("store", storeBean.findById(Long.parseLong(req.getParameter("id"))));
        }
        req.getRequestDispatcher("stores_add.jsp").forward(req, res);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
        String name = req.getParameter("name");
        if (!req.getParameter("id").equals("") && !req.getParameter("id").isEmpty()) {
            long update_id = Long.parseLong(req.getParameter("id"));
            StoreEntity store = storeBean.findById(update_id);
            store.setName(name);
            storeBean.update(store);
        } else {
            StoreEntity store = new StoreEntity();
            store.setName(name);
            storeBean.insert(store);
        }
        res.sendRedirect(req.getContextPath() + "/stores");
    }
}
