/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.inovatec.grid.services.impl;

import br.com.inovatec.grid.dao.AulaDAO;
import br.com.inovatec.grid.dao.exceptions.CreateEntityException;
import br.com.inovatec.grid.dao.exceptions.ListEntityException;
import br.com.inovatec.grid.dao.exceptions.RemoveEntityException;
import br.com.inovatec.grid.dao.exceptions.SearchEntityException;
import br.com.inovatec.grid.dao.exceptions.UpdateEntityException;
import br.com.inovatec.grid.entidades.Aula;
import br.com.inovatec.grid.services.exceptions.ServiceException;
import br.com.inovatec.grid.services.AulaService;
import java.util.List;

/**
 *
 * @author zrobe
 */
public class AulaServiceImpl implements AulaService {
    
    private final AulaDAO aulaDAO;

    public AulaServiceImpl() {
        this.aulaDAO = new AulaDAO();
    }
    
    @Override
    public void save(Aula obj) throws ServiceException {
        try {
            this.aulaDAO.insert(obj);
        } catch (CreateEntityException ex) {
            throw new ServiceException(ex);
        }
    }

    @Override
    public Aula find(Long id) throws ServiceException {
        try {
            return this.aulaDAO.find(id);
        } catch (SearchEntityException ex) {
            throw new ServiceException(ex);
        }
    }

    @Override
    public void update(Aula obj) throws ServiceException {
        try {
            this.aulaDAO.update(obj);
        } catch (UpdateEntityException ex) {
            throw new ServiceException(ex);
        }
    }

    @Override
    public void remove(Aula obj) throws ServiceException {
        try {
            this.aulaDAO.remove(obj);
        } catch (RemoveEntityException ex) {
            throw new ServiceException(ex);
        }
    }

    @Override
    public List<Aula> findAll() throws ServiceException {
        try {
            return this.aulaDAO.findAll();
        } catch (ListEntityException ex) {
            throw new ServiceException(ex);
        }
    }
    
}
