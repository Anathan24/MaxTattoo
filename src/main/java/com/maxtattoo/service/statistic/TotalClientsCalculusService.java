package com.maxtattoo.service.statistic;

import com.maxtattoo.database.repository.ClientRepository;
import com.maxtattoo.model.statistic.TotalStatisticWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TotalClientsCalculusService {

    private static final String FEMALE = "Female";
    private static final String MALE = "Male";

    @Autowired
    private ClientRepository clientRepository;

    public void calculateTotalClientsStatistic(TotalStatisticWrapper statistic, String startDate, String endDate) {
        Integer totalClients = clientRepository.countTotalClientsNumber();
        Integer totalMales = clientRepository.countTotalClientsNumber(MALE);
        Integer totalFemales = clientRepository.countTotalClientsNumber(FEMALE);

        statistic.getClientsStatistic().setTotalClientsNumber(totalClients);
        statistic.getClientsStatistic().setNumberOfMales(totalMales);
        statistic.getClientsStatistic().setNumberOfFemales(totalFemales);
    }
}