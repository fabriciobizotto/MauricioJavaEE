package controller;

import beans.UsuarioBean;
import entidades.Usuarios;
import java.util.Date;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

@ManagedBean
@ViewScoped
public class UsuarioMB {

  @EJB
  private UsuarioBean bean;
  private Usuarios usuario;
  private List<Usuarios> lista;

  public UsuarioMB() {

  }

  @PostConstruct
  public void postConstruct() {
    limpar();
    listar();
  }

  public void salvar() {
    try {
      System.out.println(usuario);
      bean.salvar(usuario);
      this.limpar();
      this.listar();
    } catch (Exception ex) {
      FacesContext facesContext = FacesContext.getCurrentInstance();
      FacesMessage facesMessage = new FacesMessage(ex.getMessage());
      facesContext.addMessage(null, facesMessage);
    }
  }

  public void excluir() {
    try {
      System.out.println(usuario);
      bean.excluir(usuario);
      this.listar();
    } catch (Exception ex) {
      FacesContext facesContext = FacesContext.getCurrentInstance();
      FacesMessage facesMessage = new FacesMessage(ex.getMessage());
      facesContext.addMessage(null, facesMessage);
    }
  }
  
  public void prepararEditar(Usuarios usuario) {
    try {
      System.out.println(usuario);
      this.usuario = usuario;
    } catch (Exception ex) {
      FacesContext facesContext = FacesContext.getCurrentInstance();
      FacesMessage facesMessage = new FacesMessage(ex.getMessage());
      facesContext.addMessage(null, facesMessage);
    }
  }

  private void limpar() {
    usuario = new Usuarios();
    usuario.setDthrcadastro(new Date());
  }

  public void listar() {
    lista = bean.getUsuarios();
  }

  public List<Usuarios> getLista() {
    return lista;
  }

  public void setLista(List<Usuarios> lista) {
    this.lista = lista;
  }

  public Usuarios getUsuario() {
    return usuario;
  }

  public void setUsuario(Usuarios usuario) {
    this.usuario = usuario;
  }

}
