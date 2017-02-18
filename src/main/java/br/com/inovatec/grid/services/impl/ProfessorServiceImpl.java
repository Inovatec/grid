/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.inovatec.grid.services.impl;

import br.com.inovatec.grid.dao.ProfessorDAO;
import br.com.inovatec.grid.dao.exceptions.CreateEntityException;
import br.com.inovatec.grid.dao.exceptions.ListEntityException;
import br.com.inovatec.grid.dao.exceptions.RemoveEntityException;
import br.com.inovatec.grid.dao.exceptions.SearchEntityException;
import br.com.inovatec.grid.dao.exceptions.UpdateEntityException;
import br.com.inovatec.grid.entidades.Professor;
import br.com.inovatec.grid.services.exceptions.ServiceException;
import br.com.inovatec.grid.services.ProfessorService;
import java.util.List;

/**
 *
 * @author zrobe
 */
public class ProfessorServiceImpl implements ProfessorService {
    
    private final ProfessorDAO professorDAO;

    public ProfessorServiceImpl() {
        this.professorDAO = new ProfessorDAO();
    }
    
    @Override
    public void save(Professor obj) throws ServiceException {
        try {
            this.professorDAO.insert(obj);
        } catch (CreateEntityException ex) {
            throw new ServiceException(ex);
        }
    }

    @Override
    public Professor find(Long id) throws ServiceException {
        try {
            return this.professorDAO.find(id);
        } catch (SearchEntityException ex) {
            throw new ServiceException(ex);
        }
    }

    @Override
    public void update(Professor obj) throws ServiceException {
        try {
            this.professorDAO.update(obj);
        } catch (UpdateEntityException ex) {
            throw new ServiceException(ex);
        }
    }

    @Override
    public void remove(Professor obj) throws ServiceException {
        try {
            this.professorDAO.remove(obj);
        } catch (RemoveEntityException ex) {
            throw new ServiceException(ex);
        }
    }

    @Override
    public List<Professor> findAll() throws ServiceException {
        try {
            return this.professorDAO.findAll();
        } catch (ListEntityException ex) {
            throw new ServiceException(ex);
        }
    }
    
}
