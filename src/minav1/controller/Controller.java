/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package minav1.controller;

import java.util.List;
import minav1.domain.Grad;
import minav1.repository.impl.inMemory.GradRepositoryImpl;
import minav1.service.impl.GradServiceImpl;
import minav1.service.IGradService;

/**
 *
 * @author aleks
 */
public class Controller {
    
    private IGradService gradService;
    
    
    private static Controller instance;
    private Controller(){
        gradService = new GradServiceImpl(GradRepositoryImpl.getInstanca());
    }
    public static Controller getInstance() {
        if(instance == null)
            instance  = new Controller();
        return instance;
    }
    
    public Grad sacuvajGrad(Grad grad) throws Exception{
        return gradService.sacuvaj(grad);
    }
    public Grad izmeniGrad(Grad grad) throws Exception{
        return gradService.izmeni(grad);
    }
    public void obrisiGrad(Grad grad) throws Exception{
        gradService.izbrisi(grad);
    }
    public List<Grad> vratiSveGradove() throws Exception{
        return gradService.vratiSve();
    }
    
}
