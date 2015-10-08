/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.hendrosteven.springboot.dao.jpa;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import org.hendrosteven.springboot.dao.ProdukDAO;
import org.hendrosteven.springboot.entity.Produk;
import org.springframework.stereotype.Repository;

/**
 *
 * @author hendro.tampake
 */
@Repository("produkDAO")
@Transactional
public class ProdukDAOImpl implements ProdukDAO {

    @PersistenceContext
    private EntityManager em;

    @Override
    public Produk insert(Produk produk) {
        this.em.persist(produk);
        return produk;
    }

    @Override
    public Produk update(Produk produk) {
        this.em.merge(produk);
        return produk;
    }

    @Override
    public void delete(Long id) {
        this.em.remove(this.em.find(Produk.class, id));
    }

    @Override
    public Produk getById(Long id) {
        return this.em.find(Produk.class, id);
    }

    @Override
    public List<Produk> getAll() {
        return this.em.createQuery("select p from Produk p").getResultList();
    }

}
