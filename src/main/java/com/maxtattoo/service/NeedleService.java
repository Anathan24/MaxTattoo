package com.maxtattoo.service;

import com.maxtattoo.database.repository.NeedleRepository;
import com.maxtattoo.model.NeedleModel;
import org.jvnet.hk2.annotations.Service;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class NeedleService extends GenericService{

    @Autowired
    private NeedleRepository needleRepository;

    public NeedleModel findNeedleById(Long id){
        var needle = needleRepository.findNeedleById(id);
        return super.modelBuilder.createNeedleModel(needle);
    }
}
