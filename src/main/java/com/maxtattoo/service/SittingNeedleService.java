package com.maxtattoo.service;

import com.maxtattoo.database.entity.SittingNeedle;
import com.maxtattoo.database.repository.SittingNeedleRepository;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class SittingNeedleService extends GenericService{

    @Autowired
    private SittingNeedleRepository sittingNeedleRepository;

    /**
     * Creazione della relazione tra la seduta e l'ago utilizzato durante la seduta
     * @param sittingId
     * @param needleId
     * @return il risultato dell'inserimento
     */
    public Long createSittingNeedleRelation(Long sittingId, Long needleId){
        return sittingNeedleRepository.save(new SittingNeedle(sittingId, needleId)).getSittingNeedleId();
    }
}
