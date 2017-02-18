/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.inovatec.grid.services.impl;

import br.com.inovatec.grid.dao.DisciplinaTurmaDAO;
import br.com.inovatec.grid.dao.exceptions.CreateEntityException;
import br.com.inovatec.grid.dao.exceptions.ListEntityException;
import br.com.inovatec.grid.dao.exceptions.RemoveEntityException;
import br.com.inovatec.grid.dao.exceptions.SearchEntityException;
import br.com.inovatec.grid.dao.exceptions.UpdateEntityException;
import br.com.inovatec.grid.entidades.DisciplinaTurma;
import br.com.inovatec.grid.services.exceptions.ServiceException;
import br.com.inovatec.grid.services.DisciplinaTurmaService;
import java.util.List;

/**
 *
 * @author zrobe
 */
public class DisciplinaTurmaServiceImpl implements DisciplinaTurmaService {
    
    private final DisciplinaTurmaDAO disciplinaTurmaDAO;

    public DisciplinaTurmaServiceImpl() {
        this.disciplinaTurmaDAO = new DisciplinaTurmaDAO();
    }
    
    @Override
    public void save(DisciplinaTurma obj) throws ServiceException {
        try {
            this.disciplinaTurmaDAO.insert(obj);
        } catch (CreateEntityException ex) {
            throw new ServiceException(ex);
        }
    }

    @Override
    public DisciplinaTurma find(Long id) throws ServiceException {
        try {
            return this.disciplinaTurmaDAO.find(id);
        } catch (SearchEntityException ex) {
            throw new ServiceException(ex);
        }
    }

    @Override
    public void update(DisciplinaTurma obj) throws ServiceException {
        try {
            this.disciplinaTurmaDAO.update(obj);
        } catch (UpdateEntityException ex) {
            throw new ServiceException(ex);
        }
    }

    @Override
    public void remove(DisciplinaTurma obj) throws ServiceException {
        try {
            this.disciplinaTurmaDAO.remove(obj);
        } catch (RemoveEntityException ex) {
            throw new ServiceException(ex);
        }
    }

    @Override
    public List<DisciplinaTurma> findAll() throws ServiceException {
        try {
            return this.disciplinaTurmaDAO.findAll();
        } catch (ListEntityException ex) {
            throw new ServiceException(ex);
        }
    }
    
}
