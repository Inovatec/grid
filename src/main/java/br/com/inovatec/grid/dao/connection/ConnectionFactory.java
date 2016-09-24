/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.inovatec.grid.dao.connection;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author zrobe
 */
public class ConnectionFactory {
    
    private static ConnectionFactory instance;
    private EntityManager entityManager;

    private ConnectionFactory() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("br.com.inovatec_Grid_jar_1.0-SNAPSHOTPU");
        this.entityManager = emf.createEntityManager();
    }

    public static ConnectionFactory getInstance() {
        if (instance == null) {
            instance = new ConnectionFactory();
        }
        return instance;
    }

    public EntityManager getEntityManager() {
        return entityManager;
    }

    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }
    
}
