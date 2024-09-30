package com.salesianostriana.dam.monumentos.service;

import com.salesianostriana.dam.monumentos.model.Monumento;
import com.salesianostriana.dam.monumentos.repository.MonumentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MonumentoService {

    @Autowired
    private MonumentoRepository monumentoRepository;

    public List<Monumento> mostrarMonumentos(){
        return monumentoRepository.findAll();
    }

    public Monumento guardarMonumento(Monumento monumento){
        return monumentoRepository.save(monumento);
    }

    public Monumento editarMonumento(Long id, Monumento monumento){
        Monumento m = null;
        Optional<Monumento> monumentoAEditar = monumentoRepository.findById(id);
        if(!monumentoAEditar.isEmpty()){
            m = monumentoAEditar.get();
            m = monumentoRepository.save(monumento);
            return m;
        }else {
            return null;
        }
    }

    public void eliminarMonumento(Long id){
        monumentoRepository.deleteById(id);
    }



}
