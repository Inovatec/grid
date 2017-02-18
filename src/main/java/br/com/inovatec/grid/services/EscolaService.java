/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.inovatec.grid.services;

import br.com.inovatec.grid.entidades.Escola;
import br.com.inovatec.grid.services.exceptions.ServiceException;

/**
 *
 * @author zrobe
 */
public interface EscolaService extends GenericService<Escola>{
    
    public Escola get() throws ServiceException;
    
}
