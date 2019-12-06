/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import org.apache.commons.codec.digest.DigestUtils;

/**
 *
 * @author fabricio
 */
public class Utils {

  public static String textoParaMd5(String texto) throws Exception {
    return DigestUtils.md5Hex(texto);
  }
}
