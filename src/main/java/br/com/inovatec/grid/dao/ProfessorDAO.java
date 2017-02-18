/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.inovatec.grid.dao;

import br.com.inovatec.grid.dao.exceptions.ListEntityException;
import br.com.inovatec.grid.entidades.Professor;
import java.util.List;

/**
 *
 * @author zrobe
 */
public class ProfessorDAO extends GenericDAO<Professor> {

    public ProfessorDAO() {
        super(Professor.class);
    }

    @Override
    public List<Professor> findAll() throws ListEntityException {
        return this.list("professor.findAll", null);
    }
    
}
