package com.maxtattoo.service;

import com.maxtattoo.database.entity.SittingNeedle;
import com.maxtattoo.database.repository.SittingNeedleRepository;
import org.jvnet.hk2.annotations.Service;
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
    public SittingNeedle createSittingNeedleRelation(Long sittingId, Long needleId){
        SittingNeedle relation = new SittingNeedle(sittingId, needleId);
        return sittingNeedleRepository.save(relation);
    }
}
