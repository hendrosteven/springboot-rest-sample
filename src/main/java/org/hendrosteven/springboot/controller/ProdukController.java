/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.hendrosteven.springboot.controller;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.hendrosteven.springboot.dao.ProdukDAO;
import org.hendrosteven.springboot.entity.Produk;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author hendro.tsampake
 */
@RestController
@RequestMapping("/produk")
public class ProdukController {

    @Autowired
    private ProdukDAO produkDAO;
    @Autowired
    private HttpServletRequest req;

    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.ACCEPTED)
    public Produk insert() {
        String kode = req.getParameter("kode");
        String nama = req.getParameter("nama");
        double harga = Double.valueOf(req.getParameter("harga"));
        Produk produk = new Produk();
        produk.setKode(kode);
        produk.setNama(nama);
        produk.setHarga(harga);
        return produkDAO.insert(produk);
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.OK)
    public Produk update() {
        long id = Long.valueOf(req.getParameter("id"));
        String kode = req.getParameter("kode");
        String nama = req.getParameter("nama");
        double harga = Double.valueOf(req.getParameter("harga"));
        Produk produk = new Produk();
        produk.setId(id);
        produk.setKode(kode);
        produk.setNama(nama);
        produk.setHarga(harga);
        return produkDAO.update(produk);
    }

    @RequestMapping(value = "/update", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public void delete() {
        long id = Long.valueOf(req.getParameter("id"));
        produkDAO.delete(id);
    }

    @RequestMapping(value = "/getbyid", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public Produk getById() {
        long id = Long.valueOf(req.getParameter("id"));
        return produkDAO.getById(id);
    }

    @RequestMapping(value = "/getll", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public List<Produk> getAll() {
        return produkDAO.getAll();
    }
}
