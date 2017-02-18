/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.inovatec.grid.services.impl;

import br.com.inovatec.grid.dao.TurmaDAO;
import br.com.inovatec.grid.dao.exceptions.CreateEntityException;
import br.com.inovatec.grid.dao.exceptions.ListEntityException;
import br.com.inovatec.grid.dao.exceptions.RemoveEntityException;
import br.com.inovatec.grid.dao.exceptions.SearchEntityException;
import br.com.inovatec.grid.dao.exceptions.UpdateEntityException;
import br.com.inovatec.grid.entidades.Turma;
import br.com.inovatec.grid.services.exceptions.ServiceException;
import br.com.inovatec.grid.services.TurmaService;
import java.util.List;

/**
 *
 * @author zrobe
 */
public class TurmaServiceImpl implements TurmaService {
    
    private final TurmaDAO turmaDAO;

    public TurmaServiceImpl() {
        this.turmaDAO = new TurmaDAO();
    }
    
    @Override
    public void save(Turma obj) throws ServiceException {
        try {
            this.turmaDAO.insert(obj);
        } catch (CreateEntityException ex) {
            throw new ServiceException(ex);
        }
    }

    @Override
    public Turma find(Long id) throws ServiceException {
        try {
            return this.turmaDAO.find(id);
        } catch (SearchEntityException ex) {
            throw new ServiceException(ex);
        }
    }

    @Override
    public void update(Turma obj) throws ServiceException {
        try {
            this.turmaDAO.update(obj);
        } catch (UpdateEntityException ex) {
            throw new ServiceException(ex);
        }
    }

    @Override
    public void remove(Turma obj) throws ServiceException {
        try {
            this.turmaDAO.remove(obj);
        } catch (RemoveEntityException ex) {
            throw new ServiceException(ex);
        }
    }

    @Override
    public List<Turma> findAll() throws ServiceException {
        try {
            return this.turmaDAO.findAll();
        } catch (ListEntityException ex) {
            throw new ServiceException(ex);
        }
    }
    
}
