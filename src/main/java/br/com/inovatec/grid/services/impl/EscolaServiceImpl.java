/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.inovatec.grid.services.impl;

import br.com.inovatec.grid.dao.EscolaDAO;
import br.com.inovatec.grid.dao.exceptions.CreateEntityException;
import br.com.inovatec.grid.dao.exceptions.ListEntityException;
import br.com.inovatec.grid.dao.exceptions.RemoveEntityException;
import br.com.inovatec.grid.dao.exceptions.SearchEntityException;
import br.com.inovatec.grid.dao.exceptions.UpdateEntityException;
import br.com.inovatec.grid.entidades.Escola;
import br.com.inovatec.grid.services.exceptions.ServiceException;
import br.com.inovatec.grid.services.EscolaService;
import java.util.List;

/**
 *
 * @author zrobe
 */
public class EscolaServiceImpl implements EscolaService {
    
    private final EscolaDAO escolaDAO;

    public EscolaServiceImpl() {
        this.escolaDAO = new EscolaDAO();
    }
    
    @Override
    public void save(Escola obj) throws ServiceException {
        try {
            this.escolaDAO.insert(obj);
        } catch (CreateEntityException ex) {
            throw new ServiceException(ex);
        }
    }

    @Override
    public Escola find(Long id) throws ServiceException {
        try {
            return this.escolaDAO.find(id);
        } catch (SearchEntityException ex) {
            throw new ServiceException(ex);
        }
    }

    @Override
    public void update(Escola obj) throws ServiceException {
        try {
            this.escolaDAO.update(obj);
        } catch (UpdateEntityException ex) {
            throw new ServiceException(ex);
        }
    }

    @Override
    public void remove(Escola obj) throws ServiceException {
        try {
            this.escolaDAO.remove(obj);
        } catch (RemoveEntityException ex) {
            throw new ServiceException(ex);
        }
    }

    @Override
    public List<Escola> findAll() throws ServiceException {
        try {
            return this.escolaDAO.findAll();
        } catch (ListEntityException ex) {
            throw new ServiceException(ex);
        }
    }

    @Override
    public Escola get() throws ServiceException {
        try {
            return this.escolaDAO.get();
        } catch (SearchEntityException ex) {
            throw new ServiceException(ex);
        }
    }
    
}
