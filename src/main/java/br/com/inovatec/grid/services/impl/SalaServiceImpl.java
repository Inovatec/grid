/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.inovatec.grid.services.impl;

import br.com.inovatec.grid.dao.SalaDAO;
import br.com.inovatec.grid.dao.exceptions.CreateEntityException;
import br.com.inovatec.grid.dao.exceptions.ListEntityException;
import br.com.inovatec.grid.dao.exceptions.RemoveEntityException;
import br.com.inovatec.grid.dao.exceptions.SearchEntityException;
import br.com.inovatec.grid.dao.exceptions.UpdateEntityException;
import br.com.inovatec.grid.entidades.Sala;
import br.com.inovatec.grid.services.exceptions.ServiceException;
import br.com.inovatec.grid.services.SalaService;
import java.util.List;

/**
 *
 * @author zrobe
 */
public class SalaServiceImpl implements SalaService {
    
    private final SalaDAO salaDAO;

    public SalaServiceImpl() {
        this.salaDAO = new SalaDAO();
    }
    
    @Override
    public void save(Sala obj) throws ServiceException {
        try {
            this.salaDAO.insert(obj);
        } catch (CreateEntityException ex) {
            throw new ServiceException(ex);
        }
    }

    @Override
    public Sala find(Long id) throws ServiceException {
        try {
            return this.salaDAO.find(id);
        } catch (SearchEntityException ex) {
            throw new ServiceException(ex);
        }
    }

    @Override
    public void update(Sala obj) throws ServiceException {
        try {
            this.salaDAO.update(obj);
        } catch (UpdateEntityException ex) {
            throw new ServiceException(ex);
        }
    }

    @Override
    public void remove(Sala obj) throws ServiceException {
        try {
            this.salaDAO.remove(obj);
        } catch (RemoveEntityException ex) {
            throw new ServiceException(ex);
        }
    }

    @Override
    public List<Sala> findAll() throws ServiceException {
        try {
            return this.salaDAO.findAll();
        } catch (ListEntityException ex) {
            throw new ServiceException(ex);
        }
    }
    
}
