/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.inovatec.grid.services.interfaces;

import br.com.inovatec.grid.entidades.Usuario;
import br.com.inovatec.grid.services.exceptions.ServiceException;

/**
 *
 * @author zrobe
 */
public interface UsuarioService extends GenericService<Usuario>{
    
    public Usuario authenticate(String login, String senha) throws ServiceException;
    
}
