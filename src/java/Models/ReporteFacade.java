/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import Entities.Reporte;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author brsbr
 */
@Stateless
public class ReporteFacade extends AbstractFacade<Reporte> {

    @PersistenceContext(unitName = "elDorado_JSF_PFPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ReporteFacade() {
        super(Reporte.class);
    }
    
}
