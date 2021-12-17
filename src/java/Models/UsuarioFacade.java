/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import Entities.Usuario;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author brsbr
 */
@Stateless
public class UsuarioFacade extends AbstractFacade<Usuario> {

    @PersistenceContext(unitName = "elDorado_JSF_PFPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public UsuarioFacade() {
        super(Usuario.class);
    }
    
    public Usuario validarUsuario(String login, String password){
    Usuario usu = null;
    
    try{
    usu = getEntityManager().createNamedQuery("Usuario.validarUsuario", Usuario.class).setParameter("login", login).setParameter("password", password).getSingleResult();
    }catch(Exception e){
    usu = null;
    }
    return usu;
    }
    
}
