/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.EMFListener;
import dao.Fundcluster;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author BavarianHotdog
 */
@Stateless
public class FundclusterFacade extends AbstractFacade<Fundcluster> {

    @PersistenceContext(unitName = "DAR-AMISPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public FundclusterFacade() {
        super(Fundcluster.class);
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
    public List<Fundcluster> findByQuery(String q, Class<Fundcluster> resultClass, String parameter, Object value){
        return super.findByQuery(q, resultClass, parameter, value);
    }
    
}
