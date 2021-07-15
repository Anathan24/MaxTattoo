package com.maxtattoo.service;

import com.maxtattoo.database.entity.ClientOrder;
import com.maxtattoo.database.repository.ClientOrderRepository;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class ClientOrderService extends GenericService{

    @Autowired
    private ClientOrderRepository clientOrderRepository;

    /**
     * Creazione della relazione tra il cliente ed il suo ordine
     * @param clientId l'id del cliente
     * @param orderId l'id dell'ordine
     * @return il risultato dell'inserimento
     */
    public Long createClientOrderRelation(Long clientId, Long orderId){
        return clientOrderRepository.save(new ClientOrder(clientId, orderId)).getClientOrderId();
    }
}
