package com.ssau.laba1.dao;

import com.ssau.laba1.model.StoreEntity;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

@Stateless
@LocalBean
public class StoreBean {
    @PersistenceContext
    private EntityManager em;

    public List<StoreEntity> findAll() {
        Query findAll = em.createQuery("SELECT s FROM StoreEntity s");
        return findAll.getResultList();
    }

    public StoreEntity findById(Long id) {
        return em.find(StoreEntity.class, id);
    }

    @Transactional
    public void insert(StoreEntity s) {
        em.persist(s);
    }

    @Transactional
    public void update(StoreEntity s) { em.merge(s); }

    @Transactional
    public void delete(Long id) {
        StoreEntity s = em.find(StoreEntity.class, id);
        if (s != null) {
//            s.getMalls().forEach(r -> {
//                r.getStores().remove(s);
//            });
            em.createNativeQuery("DELETE FROM relations WHERE store_id = " + id).executeUpdate();
            em.remove(s);
        }
    }
}
