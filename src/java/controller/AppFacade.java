/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.App;
import database.EMFListener;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Myles Mempin
 */
@Stateless
public class AppFacade extends AbstractFacade<App> {
    @PersistenceContext(unitName = "DARAMISPU")
    private EntityManager em;

    public AppFacade() {
        super(App.class);
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    @Override
    public void closeEntityManager() {
        em.close();
    }

    @Override
    public void setEntityManager() {
        em = EMFListener.createEntityManager();
    }
    
}
