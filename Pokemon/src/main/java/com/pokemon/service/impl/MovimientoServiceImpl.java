package com.pokemon.service.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.pokemon.converter.MovimientoConverter;
import com.pokemon.entity.MovimientoEntity;
import com.pokemon.model.MovimientoModel;
import com.pokemon.repository.MovimientoJpaRepository;
import com.pokemon.service.MovimientoService;

@Service("movimientoServiceImpl")
public class MovimientoServiceImpl implements MovimientoService{

	 @Autowired
	    @Qualifier("movimientoRepository")
	    private MovimientoJpaRepository movimientoJpaRepository;
	    
	 @Autowired
	    private DozerBeanMapper dozer;
	 
	 @Autowired
	 @Qualifier("movimientoConverter")
	 private MovimientoConverter movimientoConverter;
	    
	 @Override
	    public List<MovimientoModel> listMovimiento() {
	        List<MovimientoEntity> listaMovimiento=movimientoJpaRepository.findAll();
	        List<MovimientoModel> listaCModel=new ArrayList<>();
	        listaMovimiento.forEach(a->{
	        	MovimientoModel movimientoModel=transform(a);
	            listaCModel.add(movimientoModel);
	        });
	        
	        Collections.sort(listaCModel, (MovimientoModel c1, MovimientoModel c2) -> c1.getNombre().compareTo(c2.getNombre()));
	        
	        return listaCModel;
	    }

	    @Override
	    public MovimientoModel addMovimiento(MovimientoModel movimientoModel) {
	    	MovimientoEntity movimiento=transform(movimientoModel);
	        return transform(movimientoJpaRepository.save(movimiento));
	    }

	   
	    @Override
	    public MovimientoModel updateMovimiento(int id){
	    	MovimientoModel movimientoModel = new MovimientoModel();
	        MovimientoEntity movimiento = movimientoJpaRepository.findById(id);
	        movimientoJpaRepository.deleteById(id);
	        movimientoModel = movimientoConverter.entity2model(movimiento);
	        return movimientoModel;
	    } 

	    @Override
	    public int removeMovimiento(int id) {
	    	movimientoJpaRepository.deleteById(id);
	        return 0;
	    }
	    
	    
	    @Override
	    public MovimientoEntity transform(MovimientoModel movimientoModel) {
	        return dozer.map(movimientoModel, MovimientoEntity.class);
	    }
	    
	    @Override
	    public MovimientoModel transform(MovimientoEntity movimiento) {
	        return dozer.map(movimiento, MovimientoModel.class);
	    }
}
