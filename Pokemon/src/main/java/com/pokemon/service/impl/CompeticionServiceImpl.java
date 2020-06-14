package com.pokemon.service.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.pokemon.converter.CompeticionConverter;
import com.pokemon.entity.CompeticionEntity;
import com.pokemon.model.CompeticionModel;
import com.pokemon.repository.CompeticionJpaRepository;
import com.pokemon.service.CompeticionService;

@Service("competicionServiceImpl")
public class CompeticionServiceImpl implements CompeticionService{
    
    @Autowired
    @Qualifier("competicionRepository")
    private CompeticionJpaRepository competicionJpaRepository;
    
    @Autowired
    private DozerBeanMapper dozer;
    
    @Autowired
    @Qualifier("competicionConverter")
    private CompeticionConverter competicionConverter;
    
    @Override
    public List<CompeticionModel> listCompeticion() {
        List<CompeticionEntity> listaCompeticion=competicionJpaRepository.findAll();
        List<CompeticionModel> listaCModel=new ArrayList<>();
        listaCompeticion.forEach(a->{
            CompeticionModel competicionModel=transform(a);
            listaCModel.add(competicionModel);
        });
        
        Collections.sort(listaCModel, (CompeticionModel c1, CompeticionModel c2) -> c1.getNombre().compareTo(c2.getNombre()));
        
        return listaCModel;
    }

    @Override
    public CompeticionModel addCompeticion(CompeticionModel competicionModel) {
        CompeticionEntity competicion=transform(competicionModel);
        return transform(competicionJpaRepository.save(competicion));
    }
 
    @Override
    public CompeticionModel updateCompeticion(int id){
        CompeticionModel competicionModel = new CompeticionModel();
        CompeticionEntity competicion = competicionJpaRepository.findById(id);
        competicionJpaRepository.deleteById(id);
        competicionModel = competicionConverter.entity2model(competicion);
        return competicionModel;
    } 

    @Override
    public int removeCompeticion(int id) {
        competicionJpaRepository.deleteById(id);
        return 0;
    }
    
    
    @Override
    public CompeticionEntity transform(CompeticionModel competicionModel) {
        return dozer.map(competicionModel, CompeticionEntity.class);
    }
    
    @Override
    public CompeticionModel transform(CompeticionEntity competicion) {
        return dozer.map(competicion, CompeticionModel.class);
    }
    
}
