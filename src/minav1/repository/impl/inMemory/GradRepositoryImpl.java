/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package minav1.repository.impl.inMemory;

import java.util.ArrayList;
import java.util.List;
import minav1.domain.Grad;
import minav1.repository.IGradRepository;

/**
 *
 * @author aleks
 */
public class GradRepositoryImpl implements IGradRepository{

    private List<Grad> gradovi;
    private static GradRepositoryImpl instanca;
    
    
    private GradRepositoryImpl() {
        gradovi = new ArrayList<Grad>();
    }

    public static GradRepositoryImpl getInstanca() {
        if(instanca == null)
            instanca = new GradRepositoryImpl();
        return instanca;
    }

    @Override
    public List<Grad> vratiSve() throws Exception {
        return gradovi;
    }

    @Override
    public Grad sacuvaj(Grad grad) throws Exception {
                
        if(gradovi.contains(grad))
            throw new Exception("Grad sa ID: "+grad.getId()+ " vec postoji u memoriji !");
        gradovi.add(grad);
        return grad;
    }

    @Override
    public Grad izmeni(Grad grad) throws Exception {
        for (Grad trenutniGrad : gradovi) {
            if(trenutniGrad.getId()==grad.getId()){
                trenutniGrad.setIme(grad.getIme());
                return trenutniGrad;
            }
        }
        throw new Exception("Grad sa trazenim ID ne postoji u memoriji !");
    }

    @Override
    public void izbrisi(Grad grad) throws Exception {
        if(!gradovi.remove(grad))
            throw new Exception("Grad sa trazenim ID ne postoji u memoriji !");
    }
    
    
    
    
}
