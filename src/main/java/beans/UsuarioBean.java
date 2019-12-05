/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import entidades.Usuarios;
import java.io.Serializable;
import java.util.List;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import utils.EntityManagerUtil;

/**
 *
 * @author fabricio
 */
@Stateless
@LocalBean
public class UsuarioBean extends EntityManagerUtil implements Serializable {

  public List<Usuarios> getUsuarios() {
    return em.createNamedQuery("Usuarios.findAll").getResultList();
  }

  public void salvar(Usuarios usuario) throws Exception {
    System.out.println(em);
    em.merge(usuario);
  }

  public void excluir(Usuarios usuario) throws Exception{
    Usuarios u = em.merge(usuario);
    em.remove(u);
  }
}
