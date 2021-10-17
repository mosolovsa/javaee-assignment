package com.ssau.laba1.controller;

import com.ssau.laba1.dao.MallBean;
import com.ssau.laba1.dao.StoreBean;
import com.ssau.laba1.model.MallEntity;
import com.ssau.laba1.model.StoreEntity;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@WebServlet(name = "RelationsAddServlet", urlPatterns = {"/add_rels"})
public class RelationsAddServlet extends HttpServlet {
    @EJB
    public MallBean mallBean;
    @EJB
    public StoreBean storeBean;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
        long mall_id = Long.parseLong(req.getParameter("mall_id"));
        MallEntity mall = mallBean.findById(mall_id);
        req.setAttribute("mall", mall);
        List<StoreEntity> to_add = storeBean.findAll();
        to_add = to_add
                .stream()
                .filter(s -> {
                    for (StoreEntity already_has : mall.getStores()) {
                        if (s.getId() == already_has.getId()) {
                            return false;
                        }
                    }
                    return true;
                }).collect(Collectors.toList());
        req.setAttribute("to_add", to_add);
        req.getRequestDispatcher("rels_add.jsp").forward(req, res);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
        long mall_id = Long.parseLong(req.getParameter("mall_id"));
        long store_id = Long.parseLong(req.getParameter("store_id"));

        MallEntity change = mallBean.findById(mall_id);
        StoreEntity added = storeBean.findById(store_id);
        added.getMalls().add(change);
        change.getStores().add(added);
        mallBean.update(change);
        storeBean.update(added);

        res.sendRedirect(req.getContextPath() + "/malls");
    }
}