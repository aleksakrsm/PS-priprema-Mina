/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package minav1.service.impl;

import java.util.List;
import minav1.domain.Grad;
import minav1.repository.IGradRepository;
import minav1.service.IGradService;

/**
 *
 * @author aleks
 */
public class GradServiceImpl implements IGradService{

    private IGradRepository gradRepository;

    public GradServiceImpl(IGradRepository gradRepository) {
        this.gradRepository = gradRepository;
    }
    
    @Override
    public List<Grad> vratiSve() throws Exception {
        return gradRepository.vratiSve();
    }

    @Override
    public Grad sacuvaj(Grad grad) throws Exception {
        return gradRepository.sacuvaj(grad);
    }

    @Override
    public Grad izmeni(Grad grad) throws Exception {
        return gradRepository.izmeni(grad);
    }

    @Override
    public void izbrisi(Grad grad) throws Exception {
        gradRepository.izbrisi(grad);
    }
    
}
