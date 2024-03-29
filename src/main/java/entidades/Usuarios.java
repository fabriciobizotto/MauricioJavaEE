/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author fabricio
 */
@Entity
@Table(name = "usuarios")
@XmlRootElement
@NamedQueries({
  @NamedQuery(name = "Usuarios.findAll", query = "SELECT u FROM Usuarios u")
  , @NamedQuery(name = "Usuarios.findById", query = "SELECT u FROM Usuarios u WHERE u.id = :id")
  , @NamedQuery(name = "Usuarios.findByEmail", query = "SELECT u FROM Usuarios u WHERE u.email = :email")
  , @NamedQuery(name = "Usuarios.findBySenha", query = "SELECT u FROM Usuarios u WHERE u.senha = :senha")
  , @NamedQuery(name = "Usuarios.findByDthrcadastro", query = "SELECT u FROM Usuarios u WHERE u.dthrcadastro = :dthrcadastro")})
public class Usuarios implements Serializable {

  private static final long serialVersionUID = 1L;
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Basic(optional = false)
  @Column(name = "id")
  private Integer id;
  // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
  @Basic(optional = false)
  @NotNull
  @Size(min = 1, max = 255)
  @Column(name = "email")
  private String email;
  @Basic(optional = false)
  @NotNull
  @Size(min = 1, max = 100)
  @Column(name = "senha")
  private String senha;
  @Basic(optional = false)
  @NotNull
  @Lob
  @Size(min = 1, max = 65535)
  @Column(name = "nome")
  private String nome;
  @Basic(optional = false)
//  @NotNull
  @Column(name = "dthrcadastro")
  @Temporal(TemporalType.TIMESTAMP)
  private Date dthrcadastro;

  public Usuarios() {
  }

  public Usuarios(Integer id) {
    this.id = id;
  }

  public Usuarios(Integer id, String email, String senha, String nome, Date dthrcadastro) {
    this.id = id;
    this.email = email;
    this.senha = senha;
    this.nome = nome;
    this.dthrcadastro = dthrcadastro;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getSenha() {
    return senha;
  }

  public void setSenha(String senha) throws Exception {
    this.senha = utils.Utils.textoParaMd5(senha);
  }

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public Date getDthrcadastro() {
    return dthrcadastro;
  }

  public void setDthrcadastro(Date dthrcadastro) {
    this.dthrcadastro = dthrcadastro;
  }

  @Override
  public int hashCode() {
    int hash = 0;
    hash += (id != null ? id.hashCode() : 0);
    return hash;
  }

  @Override
  public boolean equals(Object object) {
    // TODO: Warning - this method won't work in the case the id fields are not set
    if (!(object instanceof Usuarios)) {
      return false;
    }
    Usuarios other = (Usuarios) object;
    if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "entidades.Usuarios[ id=" + id + " ]";
  }
  
}
