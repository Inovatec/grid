/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.inovatec.grid.services.impl;

import br.com.inovatec.grid.dao.GradeDAO;
import br.com.inovatec.grid.dao.exceptions.CreateEntityException;
import br.com.inovatec.grid.dao.exceptions.ListEntityException;
import br.com.inovatec.grid.dao.exceptions.RemoveEntityException;
import br.com.inovatec.grid.dao.exceptions.SearchEntityException;
import br.com.inovatec.grid.dao.exceptions.UpdateEntityException;
import br.com.inovatec.grid.entidades.Escola;
import br.com.inovatec.grid.entidades.Grade;
import br.com.inovatec.grid.entidades.Professor;
import br.com.inovatec.grid.services.exceptions.ServiceException;
import br.com.inovatec.grid.services.GradeService;
import java.util.List;

/**
 *
 * @author zrobe
 */
public class GradeServiceImpl implements GradeService {
    
    private final GradeDAO gradeDAO;

    public GradeServiceImpl() {
        this.gradeDAO = new GradeDAO();
    }
    
    @Override
    public void save(Grade obj) throws ServiceException {
        try {
            this.gradeDAO.insert(obj);
        } catch (CreateEntityException ex) {
            throw new ServiceException(ex);
        }
    }

    @Override
    public Grade find(Long id) throws ServiceException {
        try {
            return this.gradeDAO.find(id);
        } catch (SearchEntityException ex) {
            throw new ServiceException(ex);
        }
    }

    @Override
    public void update(Grade obj) throws ServiceException {
        try {
            this.gradeDAO.update(obj);
        } catch (UpdateEntityException ex) {
            throw new ServiceException(ex);
        }
    }

    @Override
    public void remove(Grade obj) throws ServiceException {
        try {
            this.gradeDAO.remove(obj);
        } catch (RemoveEntityException ex) {
            throw new ServiceException(ex);
        }
    }

    @Override
    public List<Grade> findAll() throws ServiceException {
        try {
            return this.gradeDAO.findAll();
        } catch (ListEntityException ex) {
            throw new ServiceException(ex);
        }
    }
    
    public void gerarGrade() {
        
        
        
    }
    
}
