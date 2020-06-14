package com.pokemon.service.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.pokemon.converter.TipoConverter;
import com.pokemon.entity.TipoEntity;
import com.pokemon.model.TipoModel;
import com.pokemon.repository.TipoJpaRepository;
import com.pokemon.service.TipoService;

@Service("tipoServiceImpl")
public class TipoServiceImpl implements TipoService{

	 @Autowired
	    @Qualifier("tipoRepository")
	    private TipoJpaRepository tipoJpaRepository;
	    
	 @Autowired
	    private DozerBeanMapper dozer;
	 
	 @Autowired
	 @Qualifier("tipoConverter")
	 private TipoConverter tipoConverter;
	    
	 @Override
	    public List<TipoModel> listTipo() {
	        List<TipoEntity> listaTipo=tipoJpaRepository.findAll();
	        List<TipoModel> listaCModel=new ArrayList<>();
	        listaTipo.forEach(a->{
	        	TipoModel tipoModel=transform(a);
	            listaCModel.add(tipoModel);
	        });
	        
	        Collections.sort(listaCModel, (TipoModel c1, TipoModel c2) -> c1.getNombre().compareTo(c2.getNombre()));
	        
	        return listaCModel;
	    }

	    @Override
	    public TipoModel addTipo(TipoModel tipoModel) {
	    	TipoEntity tipo=transform(tipoModel);
	        return transform(tipoJpaRepository.save(tipo));
	    }
	 
	    @Override
	    public TipoModel updateTipo(int id){
	    	TipoModel tipoModel = new TipoModel();
	    	TipoEntity tipo = tipoJpaRepository.findById(id);
	    	tipoJpaRepository.deleteById(id);
	    	tipoModel = tipoConverter.entity2model(tipo);
	        return tipoModel;
	    } 

	    @Override
	    public int removeTipo(int id) {
	    	tipoJpaRepository.deleteById(id);
	        return 0;
	    }
	    
	    
	    @Override
	    public TipoEntity transform(TipoModel tipoModel) {
	        return dozer.map(tipoModel, TipoEntity.class);
	    }
	    
	    @Override
	    public TipoModel transform(TipoEntity tipo) {
	        return dozer.map(tipo, TipoModel.class);
	    }
}
