package com.pokemon.service.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.pokemon.converter.EntrenadorConverter;
import com.pokemon.entity.EntrenadorEntity;
import com.pokemon.model.EntrenadorModel;
import com.pokemon.repository.EntrenadorJpaRepository;
import com.pokemon.service.EntrenadorService;

@Service("entrenadorServiceImpl")
public class EntrenadorServiceImpl implements EntrenadorService{

	 @Autowired
	    @Qualifier("entrenadorRepository")
	    private EntrenadorJpaRepository entrenadorJpaRepository;
	    
	 @Autowired
	    private DozerBeanMapper dozer;
	 
	 @Autowired
	 @Qualifier("entrenadorConverter")
	 private EntrenadorConverter entrenadorConverter;
	    
	    @Override
	    public List<EntrenadorModel> listEntrenador() {
	        List<EntrenadorEntity> listaEntrenador=entrenadorJpaRepository.findAll();
	        List<EntrenadorModel> listaEModel=new ArrayList<>();
	        listaEntrenador.forEach(a->{
	        	EntrenadorModel entrenadorModel=transform(a);
	            listaEModel.add(entrenadorModel);
	        });
	        
	        Collections.sort(listaEModel, (EntrenadorModel c1, EntrenadorModel c2) -> c1.getNombre().compareTo(c2.getNombre()));
	        
	        return listaEModel;
	    }

	    @Override
	    public EntrenadorModel addEntrenador(EntrenadorModel entrenadorModel) {
	    	EntrenadorEntity entrenador=transform(entrenadorModel);
	        return transform(entrenadorJpaRepository.save(entrenador));
	    }
	 
	    @Override
	    public EntrenadorModel updateEntrenador(int id){
	    	EntrenadorModel entrenadorModel = new EntrenadorModel();
	    	EntrenadorEntity entrenador = entrenadorJpaRepository.findById(id);
	    	entrenadorJpaRepository.deleteById(id);
	    	entrenadorModel = entrenadorConverter.entity2model(entrenador);
	        return entrenadorModel;
	    } 

	    @Override
	    public int removeEntrenador(int id) {
	    	entrenadorJpaRepository.deleteById(id);
	        return 0;
	    }
	    
	    
	    @Override
	    public EntrenadorEntity transform(EntrenadorModel entrenadorModel) {
	        return dozer.map(entrenadorModel, EntrenadorEntity.class);
	    }
	    
	    @Override
	    public EntrenadorModel transform(EntrenadorEntity entrenador) {
	        return dozer.map(entrenador, EntrenadorModel.class);
	    }
}
