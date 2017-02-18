/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.inovatec.grid.services.impl;

import br.com.inovatec.grid.dao.DiaAulaDAO;
import br.com.inovatec.grid.dao.exceptions.CreateEntityException;
import br.com.inovatec.grid.dao.exceptions.ListEntityException;
import br.com.inovatec.grid.dao.exceptions.RemoveEntityException;
import br.com.inovatec.grid.dao.exceptions.SearchEntityException;
import br.com.inovatec.grid.dao.exceptions.UpdateEntityException;
import br.com.inovatec.grid.entidades.DiaAula;
import br.com.inovatec.grid.services.exceptions.ServiceException;
import br.com.inovatec.grid.services.DiaAulaService;
import java.util.List;

/**
 *
 * @author zrobe
 */
public class DiaAulaServiceImpl implements DiaAulaService {
    
    private final DiaAulaDAO diaAulaDAO;

    public DiaAulaServiceImpl() {
        this.diaAulaDAO = new DiaAulaDAO();
    }
    
    @Override
    public void save(DiaAula obj) throws ServiceException {
        try {
            this.diaAulaDAO.insert(obj);
        } catch (CreateEntityException ex) {
            throw new ServiceException(ex);
        }
    }

    @Override
    public DiaAula find(Long id) throws ServiceException {
        try {
            return this.diaAulaDAO.find(id);
        } catch (SearchEntityException ex) {
            throw new ServiceException(ex);
        }
    }

    @Override
    public void update(DiaAula obj) throws ServiceException {
        try {
            this.diaAulaDAO.update(obj);
        } catch (UpdateEntityException ex) {
            throw new ServiceException(ex);
        }
    }

    @Override
    public void remove(DiaAula obj) throws ServiceException {
        try {
            this.diaAulaDAO.remove(obj);
        } catch (RemoveEntityException ex) {
            throw new ServiceException(ex);
        }
    }

    @Override
    public List<DiaAula> findAll() throws ServiceException {
        try {
            return this.diaAulaDAO.findAll();
        } catch (ListEntityException ex) {
            throw new ServiceException(ex);
        }
    }
    
}
