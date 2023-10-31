/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package minav1.service;

import java.util.List;
import minav1.domain.Grad;

/**
 *
 * @author aleks
 */
public interface IGradService {
    List<Grad> vratiSve() throws Exception;
    Grad sacuvaj(Grad grad)throws Exception;
    Grad izmeni(Grad grad)throws Exception;
    void izbrisi(Grad grad)throws Exception;
}
