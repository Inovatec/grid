/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.inovatec.grid.dao;

import br.com.inovatec.grid.dao.connection.ConnectionFactory;
import br.com.inovatec.grid.dao.exceptions.CreateEntityException;
import br.com.inovatec.grid.dao.exceptions.EntityNotFoundException;
import br.com.inovatec.grid.dao.exceptions.ListEntityException;
import br.com.inovatec.grid.dao.exceptions.RemoveEntityException;
import br.com.inovatec.grid.dao.exceptions.SearchEntityException;
import br.com.inovatec.grid.dao.exceptions.UpdateEntityException;
import br.com.inovatec.grid.dao.interfaces.DAOJpa;
import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author zrobe
 * @param <T>
 */
public abstract class GenericDAO<T> implements DAOJpa<T> {

    private Class entityClass;
    private final EntityManager em;

    public GenericDAO(Class entityClass) {
        this.entityClass = entityClass;
        this.em = ConnectionFactory.getInstance().getEntityManager();
    }

    public Class getEntityClass() {
        return entityClass;
    }

    public void setEntityClass(Class entityClass) {
        this.entityClass = entityClass;
    }

    public EntityManager getEm() {
        return em;
    }

    @Override
    public void insert(T obj) throws CreateEntityException {
        try {
            this.em.getTransaction().begin();
            this.em.persist(obj);
            this.em.getTransaction().commit();
        } catch (Exception ex) {
            this.em.getTransaction().rollback();
            throw new CreateEntityException(ex);
        }
    }

    @Override
    public T find(Long id) throws SearchEntityException {
        try {
            return (T) this.em.find(this.entityClass, id);
        } catch (NullPointerException ex) { // Caso nao seja retornado nenhum objeto
            throw new SearchEntityException(new EntityNotFoundException());
        } catch (Exception ex) {
            throw new SearchEntityException(ex);
        }
    }

    @Override
    public void update(T obj) throws UpdateEntityException {
        try {
            this.em.getTransaction().begin();
            this.em.merge(obj);
            this.em.getTransaction().commit();
        } catch (Exception ex) {
            this.em.getTransaction().rollback();
            throw new UpdateEntityException(ex);
        }
    }

    @Override
    public void remove(T obj) throws RemoveEntityException {
        try {
            this.em.getTransaction().begin();
            this.em.remove(obj);
            this.em.getTransaction().commit();
        } catch (Exception ex) {
            this.em.getTransaction().rollback();
            throw new RemoveEntityException(ex);
        }
    }

    @Override
    public List<T> list(String query, Map<String, Object> params) throws ListEntityException {
        try {
            Query namedQuery = this.em.createNamedQuery(query, this.entityClass);
            if (params != null) {
                params.forEach((k, v) -> {
                    namedQuery.setParameter(k, v);
                });
            }
            return namedQuery.getResultList();
        } catch (Exception ex) {
            throw new ListEntityException(ex);
        }
    }

    /**
     * Metodo a ser implementado pelas classes filhas para que seja garantida a
     * funcionalidade de listagem de todas as entidades presentes no banco de
     * dados
     *
     * @return
     * @throws ListEntityException
     */
    public abstract List<T> findAll() throws ListEntityException;

}
