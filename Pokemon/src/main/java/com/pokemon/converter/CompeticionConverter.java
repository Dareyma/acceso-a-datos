package com.pokemon.converter;

import org.springframework.stereotype.Component;

import com.pokemon.entity.CompeticionEntity;
import com.pokemon.model.CompeticionModel;

@Component("competicionConverter")
public class CompeticionConverter {

    //Entity --> Model
        public CompeticionModel entity2model(CompeticionEntity competicion) {
            CompeticionModel competicionModel=new CompeticionModel();
            competicionModel.setId(competicion.getId());
            competicionModel.setNombre(competicion.getNombre());
            competicionModel.setFecha(competicion.getFecha());
            competicionModel.setLugar(competicion.getLugar());
            return competicionModel;
        }
        
        public CompeticionEntity model2entity(CompeticionModel competicionModel) {
            CompeticionEntity competicion=new CompeticionEntity();
            competicion.setId(competicionModel.getId());
            competicion.setNombre(competicionModel.getNombre());
            competicion.setFecha(competicionModel.getFecha());
            competicion.setLugar(competicionModel.getLugar());
            return competicion;
        }
    
}