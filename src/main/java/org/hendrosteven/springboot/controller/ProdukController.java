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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
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
    public Produk insert(@RequestBody Produk produk) {
        return produkDAO.insert(produk);
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.OK)
    public Produk update(@RequestBody Produk produk) {
        return produkDAO.update(produk);
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public boolean delete(@PathVariable("id") long id) {
        produkDAO.delete(id);
        return true;
    }

    @RequestMapping(value = "/getbyid/{id}", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public Produk getById(@PathVariable("id") long id) {
        return produkDAO.getById(id);
    }

    @RequestMapping(value = "/getall", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public List<Produk> getAll() {
        return produkDAO.getAll();
    }
}
