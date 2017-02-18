/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.inovatec.grid.dao;

import br.com.inovatec.grid.dao.exceptions.ListEntityException;
import br.com.inovatec.grid.entidades.Sala;
import java.util.List;

/**
 *
 * @author zrobe
 */
public class SalaDAO extends GenericDAO<Sala> {

    public SalaDAO() {
        super(Sala.class);
    }

    @Override
    public List<Sala> findAll() throws ListEntityException {
        return this.list("sala.findAll", null);
    }
    
}
