/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

/**
 *
 * @author BavarianHotdog
 */
public abstract class AbstractFacade<T> {
    private Class<T> entityClass;
    

    public AbstractFacade(Class<T> entityClass) {
        this.entityClass = entityClass;
    }

    protected abstract EntityManager getEntityManager();
    public abstract void closeEntityManager();
    public abstract void setEntityManager();
    
    public void create(T entity) {
        
            setEntityManager();
            getEntityManager().getTransaction().begin();
            getEntityManager().persist(entity);
            getEntityManager().getTransaction().commit();
            closeEntityManager();
        
    }
    public void edit(T entity) {
        
            setEntityManager();
            getEntityManager().getTransaction().begin();
            getEntityManager().merge(entity);
            getEntityManager().getTransaction().commit();
            closeEntityManager();
        
    }
    public void remove(T entity) {
        
            setEntityManager();
            getEntityManager().getTransaction().begin();
            getEntityManager().remove(getEntityManager().merge(entity));
            getEntityManager().getTransaction().commit();
            closeEntityManager();
        
    }
    public T find(Object id) {
        Object c = null;
        
            setEntityManager();
            c = getEntityManager().find(entityClass, id);
            closeEntityManager();
        
        return (T) c;
        
    }
    public List<T> findAll() {
        List<T> t = null;
        
       
            setEntityManager();

            javax.persistence.criteria.CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();
            cq.select(cq.from(entityClass));
            t = getEntityManager().createQuery(cq).getResultList();

            closeEntityManager();
        
        
        return t;
    }
    public List<T> findRange(int[] range) {
        List<T> t = null;
        
        
            setEntityManager();

            javax.persistence.criteria.CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();
            cq.select(cq.from(entityClass));
            javax.persistence.Query q = getEntityManager().createQuery(cq);
            q.setMaxResults(range[1] - range[0] + 1);
            q.setFirstResult(range[0]);

            t = q.getResultList();

            closeEntityManager();
       
        
        return t;
    }

    public int count() {
        int i = 0;
        
        
            setEntityManager();

            javax.persistence.criteria.CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();
            javax.persistence.criteria.Root<T> rt = cq.from(entityClass);
            cq.select(getEntityManager().getCriteriaBuilder().count(rt));
            javax.persistence.Query q = getEntityManager().createQuery(cq);
            i = ((Long) q.getSingleResult()).intValue();
            closeEntityManager();
        
        return i;
    }
    
    //uncomment when ready to implement
    //change T in Class<T> to which class should be returned
    //usually it's the inheriting class
    public List<T> findByQuery(String q, Class<T> resultClass, 
            String parameter, Object value){
        List<T> t = null;
        TypedQuery tq;
        
        
            setEntityManager();
            tq = getEntityManager().createNamedQuery(q, resultClass);
            tq.setParameter(parameter, value);
            t = tq.getResultList();
            closeEntityManager();
        
        return t;
    }
    
}