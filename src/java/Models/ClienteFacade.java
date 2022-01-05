/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import Entities.Cliente;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.metamodel.SingularAttribute;

/**
 *
 * @author brsbr
 */
@Stateless
public class ClienteFacade extends AbstractFacade<Cliente> {

    @PersistenceContext(unitName = "elDorado_JSF_PFPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ClienteFacade() {
        super(Cliente.class);
    }
    
  
    public Cliente buscarPorCodigoCliente(String nombres, String direccion, String numeroDocumento){
        Cliente cli=null;
        
        try{
        cli = getEntityManager().createNamedQuery("buscarPorCodigoCliente", Cliente.class).setParameter("nombres", nombres).setParameter("direccion", direccion).setParameter("numeroDocumento", numeroDocumento).getSingleResult();
        }catch (Exception e){
        cli = null;
        }
  
    return cli;
  
   }
    
    /*@WebMethod(operationName = "read")
public String read(@WebParam(name = "NumeroDocumento") int NumeroDocumento){
    //read
  EntityManager em;
  EntityManagerFactory emf = Persistence.createEntityManagerFactory("elDorado_JSF_PFPU");
  em = emf.createEntityManager();
  em.getTransaction().begin();
 //////
  Cliente data = em.find(Cliente.class,NumeroDocumento);
  return data.getNombres();
}*/

    public Cliente buscarPorCodigoCliente(SingularAttribute<Cliente, String> nombres, SingularAttribute<Cliente, String> direccion, SingularAttribute<Cliente, String> numeroDocumento) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
}



