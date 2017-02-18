/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.inovatec.grid.services.impl;

import br.com.inovatec.grid.dao.DisciplinaDAO;
import br.com.inovatec.grid.dao.exceptions.CreateEntityException;
import br.com.inovatec.grid.dao.exceptions.ListEntityException;
import br.com.inovatec.grid.dao.exceptions.RemoveEntityException;
import br.com.inovatec.grid.dao.exceptions.SearchEntityException;
import br.com.inovatec.grid.dao.exceptions.UpdateEntityException;
import br.com.inovatec.grid.entidades.Disciplina;
import br.com.inovatec.grid.services.exceptions.ServiceException;
import br.com.inovatec.grid.services.DisciplinaService;
import java.util.List;

/**
 *
 * @author zrobe
 */
public class DisciplinaServiceImpl implements DisciplinaService {
    
    private final DisciplinaDAO disciplinaDAO;

    public DisciplinaServiceImpl() {
        this.disciplinaDAO = new DisciplinaDAO();
    }
    
    @Override
    public void save(Disciplina obj) throws ServiceException {
        try {
            this.disciplinaDAO.insert(obj);
        } catch (CreateEntityException ex) {
            throw new ServiceException(ex);
        }
    }

    @Override
    public Disciplina find(Long id) throws ServiceException {
        try {
            return this.disciplinaDAO.find(id);
        } catch (SearchEntityException ex) {
            throw new ServiceException(ex);
        }
    }

    @Override
    public void update(Disciplina obj) throws ServiceException {
        try {
            this.disciplinaDAO.update(obj);
        } catch (UpdateEntityException ex) {
            throw new ServiceException(ex);
        }
    }

    @Override
    public void remove(Disciplina obj) throws ServiceException {
        try {
            this.disciplinaDAO.remove(obj);
        } catch (RemoveEntityException ex) {
            throw new ServiceException(ex);
        }
    }

    @Override
    public List<Disciplina> findAll() throws ServiceException {
        try {
            return this.disciplinaDAO.findAll();
        } catch (ListEntityException ex) {
            throw new ServiceException(ex);
        }
    }
    
}
