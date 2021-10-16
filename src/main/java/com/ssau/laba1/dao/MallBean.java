package com.ssau.laba1.dao;

import com.ssau.laba1.model.MallEntity;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Stateless
@LocalBean
public class MallBean {
    @PersistenceContext
    private EntityManager em;

    public List<MallEntity> findAll() {
        Query findAll = em.createQuery("SELECT m FROM MallEntity m");
        return findAll.getResultList();
    }

    public MallEntity findById(Long id) {
        return em.find(MallEntity.class, id);
    }

    @Transactional
    public void insert(MallEntity m) {
        em.persist(m);
    }

    @Transactional
    public void update(MallEntity m) {
        em.merge(m);
    }

    @Transactional
    public void delete(Long id) {
        MallEntity m = em.find(MallEntity.class, id);
        if (m != null) {
            em.remove(m);
        }
    }
}
