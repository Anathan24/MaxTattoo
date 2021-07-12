package com.maxtattoo.service;

import com.maxtattoo.database.repository.PaintRepository;
import com.maxtattoo.model.PaintModel;
import org.jvnet.hk2.annotations.Service;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class PaintService extends GenericService{

    @Autowired
    private PaintRepository paintRepository;

    public PaintModel findPaintById(Long id){
        var paint = paintRepository.findPaintById(id);
        return super.modelBuilder.createPaintModel(paint);
    }
}
