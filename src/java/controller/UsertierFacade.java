/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.EMFListener;
import dao.Usertier;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author BavarianHotdog
 */
@Stateless
public class UsertierFacade extends AbstractFacade<Usertier> {

    @PersistenceContext(unitName = "DAR-AMISPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public UsertierFacade() {
        super(Usertier.class);
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
    public List<Usertier> findByQuery(String q, Class<Usertier> resultClass, String parameter, Object value){
        return super.findByQuery(q, resultClass, parameter, value);
    }
}
