/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.inovatec.grid.dao;

import br.com.inovatec.grid.dao.exceptions.ListEntityException;
import br.com.inovatec.grid.entidades.DisciplinaTurma;
import java.util.List;

/**
 *
 * @author zrobe
 */
public class DisciplinaTurmaDAO extends GenericDAO<DisciplinaTurma> {

    public DisciplinaTurmaDAO() {
        super(DisciplinaTurma.class);
    }

    @Override
    public List<DisciplinaTurma> findAll() throws ListEntityException {
        return this.list("disciplinaTurma.findAll", null);
    }
    
}
