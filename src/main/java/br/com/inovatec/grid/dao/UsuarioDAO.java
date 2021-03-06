/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.inovatec.grid.dao;

import br.com.inovatec.grid.dao.exceptions.AuthenticationException;
import br.com.inovatec.grid.dao.exceptions.ListEntityException;
import br.com.inovatec.grid.entidades.Usuario;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author zrobe
 */
public class UsuarioDAO extends GenericDAO<Usuario> {

    public UsuarioDAO() {
        super(Usuario.class);
    }

    @Override
    public List<Usuario> findAll() throws ListEntityException {
        return this.list("usuario.findAll", null);
    }
    
    public Usuario autenticar(String login, String senha) throws AuthenticationException {
        Map<String, Object> params = new HashMap<>();
        params.put("login", login);
        params.put("senha", senha);
        try {
            List<Usuario> usuarios = this.list("usuario.authenticate", params);
            if (!usuarios.isEmpty()) {
                return usuarios.get(0);
            } else {
                throw new AuthenticationException();
            }
        } catch (ListEntityException ex) {
            throw new AuthenticationException(ex);
        }
    }
    
}
