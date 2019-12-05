/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceUnit;

/**
 *
 * @author fabricio
 */
public abstract class EntityManagerUtil {

  @PersistenceContext(unitName = "mauricioPU")
  protected EntityManager em;
}
