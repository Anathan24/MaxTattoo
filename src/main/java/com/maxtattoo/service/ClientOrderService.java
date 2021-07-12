package com.maxtattoo.service;

import com.maxtattoo.database.entity.ClientOrder;
import com.maxtattoo.database.repository.ClientOrderRepository;
import org.jvnet.hk2.annotations.Service;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class ClientOrderService extends GenericService{

    @Autowired
    private ClientOrderRepository clientOrderRepository;

    /**
     * Creazione della relazione tra il cliente ed il suo ordine
     * @param clientId
     * @param orderId
     * @return il risultato dell'inserimento
     */
    public ClientOrder createClientOrderRelation(Long clientId, Long orderId){
        ClientOrder relation = new ClientOrder(clientId, orderId);
        return clientOrderRepository.save(relation);
    }
}
