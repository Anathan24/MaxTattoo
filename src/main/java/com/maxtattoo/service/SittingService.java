package com.maxtattoo.service;

import com.maxtattoo.database.repository.SittingRepository;
import com.maxtattoo.model.SittingModel;
import org.jvnet.hk2.annotations.Service;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class SittingService extends GenericService{

    @Autowired
    private SittingRepository sittingRepository;

    public SittingModel findSittingById(Long id){
        var sitting = sittingRepository.findSittingById(id);
        return super.modelBuilder.createSittingModel(sitting);
    }
}
