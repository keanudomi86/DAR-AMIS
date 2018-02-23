/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.EMFListener;
import dao.Pr;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author BavarianHotdog
 */
@Stateless
public class PrFacade extends AbstractFacade<Pr> {

    @PersistenceContext(unitName = "DAR-AMISPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public PrFacade() {
        super(Pr.class);
    }
    @Override
    public void closeEntityManager() {
        em.close();
    }

    @Override
    public void setEntityManager() {
        em = EMFListener.createEntityManager();
    }
    
    @Override
    public List<Pr> findByQuery(String q, Class<Pr> resultClass, String parameter, Object value){
        return super.findByQuery(q, resultClass, parameter, value);
    }
    
}
