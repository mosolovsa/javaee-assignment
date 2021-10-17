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
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@WebServlet(name = "RelationsDelServlet", urlPatterns = {"/del_rels"})
public class RelationsDelServlet extends HttpServlet {
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
        List<StoreEntity> to_del = new ArrayList<>(mall.getStores());
        req.setAttribute("to_del", to_del);
        req.getRequestDispatcher("rels_del.jsp").forward(req, res);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
        long mall_id = Long.parseLong(req.getParameter("mall_id"));
        long store_id = Long.parseLong(req.getParameter("store_id"));

        MallEntity change = mallBean.findById(mall_id);
        StoreEntity added = storeBean.findById(store_id);
        added.getMalls().removeIf(m -> m.getId() == change.getId());
        change.getStores().removeIf(s -> s.getId() == added.getId());
            // это может стать очень затратным по времени при большом наборе данных
        mallBean.update(change);
        storeBean.update(added);

        res.sendRedirect(req.getContextPath() + "/malls");
    }
}
