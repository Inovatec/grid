/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.inovatec.grid.dao;

import br.com.inovatec.grid.dao.exceptions.ListEntityException;
import br.com.inovatec.grid.entidades.Disciplina;
import java.util.List;

/**
 *
 * @author zrobe
 */
public class DisciplinaDAO extends GenericDAO<Disciplina> {

    public DisciplinaDAO() {
        super(Disciplina.class);
    }

    @Override
    public List<Disciplina> findAll() throws ListEntityException {
        return this.list("disciplina.findAll", null);
    }
    
}
