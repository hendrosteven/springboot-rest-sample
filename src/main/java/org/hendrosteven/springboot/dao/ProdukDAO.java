/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.hendrosteven.springboot.dao;

import java.util.List;
import org.hendrosteven.springboot.entity.Produk;

/**
 *
 * @author hendro.tampake
 */
public interface ProdukDAO {
    public Produk insert(Produk produk);
    public Produk update(Produk produk);
    public void delete(Long id);
    public Produk getById(Long id);
    public List<Produk> getAll();
}
