/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.inovatec.grid.services.impl;

import br.com.inovatec.grid.dao.UsuarioDAO;
import br.com.inovatec.grid.dao.exceptions.AuthenticationException;
import br.com.inovatec.grid.dao.exceptions.CreateEntityException;
import br.com.inovatec.grid.dao.exceptions.ListEntityException;
import br.com.inovatec.grid.dao.exceptions.RemoveEntityException;
import br.com.inovatec.grid.dao.exceptions.SearchEntityException;
import br.com.inovatec.grid.dao.exceptions.UpdateEntityException;
import br.com.inovatec.grid.entidades.Usuario;
import br.com.inovatec.grid.services.exceptions.ServiceException;
import br.com.inovatec.grid.services.UsuarioService;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author zrobe
 */
public class UsuarioServiceImpl implements UsuarioService {
    
    private final UsuarioDAO usuarioDAO;

    public UsuarioServiceImpl() {
        this.usuarioDAO = new UsuarioDAO();
    }
    
    @Override
    public void save(Usuario obj) throws ServiceException {
        try {
            this.usuarioDAO.insert(obj);
        } catch (CreateEntityException ex) {
            throw new ServiceException(ex);
        }
    }

    @Override
    public Usuario find(Long id) throws ServiceException {
        try {
            return this.usuarioDAO.find(id);
        } catch (SearchEntityException ex) {
            throw new ServiceException(ex);
        }
    }

    @Override
    public void update(Usuario obj) throws ServiceException {
        try {
            this.usuarioDAO.update(obj);
        } catch (UpdateEntityException ex) {
            throw new ServiceException(ex);
        }
    }

    @Override
    public void remove(Usuario obj) throws ServiceException {
        try {
            this.usuarioDAO.remove(obj);
        } catch (RemoveEntityException ex) {
            throw new ServiceException(ex);
        }
    }

    @Override
    public List<Usuario> findAll() throws ServiceException {
        try {
            return this.usuarioDAO.findAll();
        } catch (ListEntityException ex) {
            throw new ServiceException(ex);
        }
    }

    @Override
    public Usuario authenticate(String login, String senha) throws ServiceException {
        try {
            return this.usuarioDAO.autenticar(login, senha);
        } catch (AuthenticationException ex) {
            throw new ServiceException(ex);
        }
    }
    
}
