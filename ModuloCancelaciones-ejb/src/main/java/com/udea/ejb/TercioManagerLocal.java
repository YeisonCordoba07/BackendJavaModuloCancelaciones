/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.udea.ejb;

import com.udea.modelo.Tercio;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author YEISON
 */
@Local
public interface TercioManagerLocal {

    List<Tercio> getTercio();
    
}
