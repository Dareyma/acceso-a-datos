package com.pokemon.service.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.pokemon.converter.EquipoConverter;
import com.pokemon.entity.EquipoEntity;
import com.pokemon.model.EquipoModel;
import com.pokemon.repository.EquipoJpaRepository;
import com.pokemon.service.EquipoService;

@Service("equipoServiceImpl")
public class EquipoServiceImpl implements EquipoService{

	 	@Autowired
	    @Qualifier("equipoRepository")
	    private EquipoJpaRepository equipoJpaRepository;
	    
	 	@Autowired
	    private DozerBeanMapper dozer;
	 	
		 @Autowired
		 @Qualifier("equipoConverter")
		 private EquipoConverter equipoConverter;
	    
	 	 @Override
	     public List<EquipoModel> listEquipo() {
	         List<EquipoEntity> listaEquipo=equipoJpaRepository.findAll();
	         List<EquipoModel> listaCModel=new ArrayList<>();
	         listaEquipo.forEach(a->{
	        	 EquipoModel equipoModel=transform(a);
	             listaCModel.add(equipoModel);
	         });
	         
	         Collections.sort(listaCModel, (EquipoModel c1, EquipoModel c2) -> c1.getNombre().compareTo(c2.getNombre()));
	         
	         return listaCModel;
	     }

	     @Override
	     public EquipoModel addEquipo(EquipoModel equipoModel) {
	    	 EquipoEntity equipo=transform(equipoModel);
	         return transform(equipoJpaRepository.save(equipo));
	     }
	  
	     @Override
		    public EquipoModel updateEquipo(int id){
	    	 EquipoModel equipoModel = new EquipoModel();
	    	 EquipoEntity equipo = equipoJpaRepository.findById(id);
	    	 equipoJpaRepository.deleteById(id);
	    	 equipoModel = equipoConverter.entity2model(equipo);
		        return equipoModel;
		    } 

	     @Override
	     public int removeEquipo(int id) {
	    	 equipoJpaRepository.deleteById(id);
	         return 0;
	     }
	     
	     
	     @Override
	     public EquipoEntity transform(EquipoModel equipoModel) {
	         return dozer.map(equipoModel, EquipoEntity.class);
	     }
	     
	     @Override
	     public EquipoModel transform(EquipoEntity equipo) {
	         return dozer.map(equipo, EquipoModel.class);
	     }

}
