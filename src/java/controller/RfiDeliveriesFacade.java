/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.RfiDeliveries;
import database.EMFListener;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Myles Mempin
 */
@Stateless
public class RfiDeliveriesFacade extends AbstractFacade<RfiDeliveries> {
    @PersistenceContext(unitName = "DARAMISPU")
    private EntityManager em;

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

    public RfiDeliveriesFacade() {
        super(RfiDeliveries.class);
    }
    
}
